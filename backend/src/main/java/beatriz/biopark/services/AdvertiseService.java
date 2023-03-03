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

import beatriz.biopark.dto.AdvertiseDTO;
import beatriz.biopark.entities.Advertise;
import beatriz.biopark.repositories.AdvertiseRepository;
import beatriz.biopark.services.exceptions.DatabaseException;
import beatriz.biopark.services.exceptions.ResourceNotFoundException;

@Service
public class AdvertiseService {
	
	@Autowired
	private AdvertiseRepository repository;

	@Transactional(readOnly = true)
	public List<AdvertiseDTO> findAll() {
		List<Advertise> advertises = repository.findAll();

		return advertises.stream().map(advertise -> new AdvertiseDTO(advertise)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public AdvertiseDTO findById(Long id) {
		Optional<Advertise> obj = repository.findById(id);
		Advertise entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
		return new AdvertiseDTO(entity);
	}

	@Transactional
	public AdvertiseDTO insert(AdvertiseDTO dto) {
		Advertise entity = new Advertise(dto.getUser(), 
				dto.getTitle(), dto.getDescription(), dto.getCreatedAt(), false, dto.getApartment());

		entity = repository.save(entity);
		return new AdvertiseDTO(entity);
	}

	@Transactional
	public AdvertiseDTO update(Long id, AdvertiseDTO dto) {
		try {
			Advertise entity = repository.getOne(id);
			entity.setUser(dto.getUser());
			entity.setTitle(dto.getTitle());
			entity.setDescription(dto.getDescription());
			entity.setCreatedAt(dto.getCreatedAt());
			entity.setActive(false);
			entity.setApartment(dto.getApartment());
			return new AdvertiseDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id " + id + " not found!");
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
