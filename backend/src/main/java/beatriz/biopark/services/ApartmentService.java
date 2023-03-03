package beatriz.biopark.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beatriz.biopark.dto.ApartmentDTO;
import beatriz.biopark.entities.Apartment;
import beatriz.biopark.repositories.ApartmentRepository;
import beatriz.biopark.services.exceptions.DatabaseException;
import beatriz.biopark.services.exceptions.ResourceNotFoundException;

@Service
public class ApartmentService {

	@Autowired
	private ApartmentRepository repository;

	@Transactional(readOnly = true)
	public List<ApartmentDTO> findAll() {
		List<Apartment> apartments = repository.findAll();

		return apartments.stream().map(apartment -> new ApartmentDTO(apartment))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ApartmentDTO findById(Long id) {
		Optional<Apartment> obj = repository.findById(id);
		Apartment entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
		return new ApartmentDTO(entity);
	}

	@Transactional
	public ApartmentDTO insert(ApartmentDTO dto) {
		Apartment apartment = new Apartment(dto.getUser(), dto.getBedroom(), dto.getBathroom(), dto.getGarage(),
				dto.getFloor(), dto.getDimension(), dto.getBuilding(), dto.getStatusApartment(), dto.getRentAmount(),
				dto.getImageUrl());
		
		apartment = repository.save(apartment);
		return new ApartmentDTO(apartment);
	}
	
	@Transactional
	public ApartmentDTO update(Long id, ApartmentDTO dto) {
		try {
			Apartment apartment = repository.getOne(id);
			apartment.setUser(dto.getUser());
			apartment.setBedroom(dto.getBedroom());
			apartment.setBathroom(dto.getBathroom());
			apartment.setGarage(dto.getGarage());
			apartment.setFloor(dto.getFloor());
			apartment.setDimension(dto.getDimension());
			apartment.setBuilding(dto.getBuilding());
			apartment.setStatusApartment(dto.getStatusApartment());
			apartment.setRentAmount(dto.getRentAmount());
			apartment.setImageUrl(dto.getImageUrl());
			
			return new ApartmentDTO(apartment);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity not found!");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id " + id + " not found!");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

}
