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

import beatriz.biopark.dto.BuildingDTO;
import beatriz.biopark.entities.Building;
import beatriz.biopark.repositories.BuildingRepository;
import beatriz.biopark.services.exceptions.DatabaseException;
import beatriz.biopark.services.exceptions.ResourceNotFoundException;

@Service
public class BuildingService {
	
	@Autowired
	private BuildingRepository repository;
	
	@Transactional(readOnly = true)
	public List<BuildingDTO> findAll() {
		List<Building> buildings = repository.findAll();

		return buildings.stream().map(building -> new BuildingDTO(building)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public BuildingDTO findById(Long id) {
		Optional<Building> obj = repository.findById(id);
		Building entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
		return new BuildingDTO(entity);
	}

	@Transactional
	public BuildingDTO insert(BuildingDTO dto) {
		Building entity = new Building(dto.getName(), 
				dto.getStreet(), dto.getNumber(), dto.getCity(), dto.getNeighborhood(), dto.getFloors());

		entity = repository.save(entity);
		return new BuildingDTO(entity);
	}

	@Transactional
	public BuildingDTO update(Long id, BuildingDTO dto) {
		try {
			Building entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setStreet(dto.getStreet());
			entity.setNumber(dto.getNumber());
			entity.setCity(dto.getCity());
			entity.setNeighborhood(dto.getNeighborhood());
			entity.setFloors(dto.getFloors());
			
			return new BuildingDTO(entity);
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
