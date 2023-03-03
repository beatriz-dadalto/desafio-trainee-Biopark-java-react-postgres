package beatriz.biopark.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import beatriz.biopark.dto.ApartmentDTO;
import beatriz.biopark.services.ApartmentService;

@RestController
@RequestMapping(value = "/apartments")
public class ApartmentResource {
	
	@Autowired
	private ApartmentService service;
	
	@GetMapping
	public ResponseEntity<List<ApartmentDTO>> findAll() {
		List<ApartmentDTO> apartmentList = service.findAll();
		return ResponseEntity.ok().body(apartmentList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ApartmentDTO> findbyId(@PathVariable Long id) {
		ApartmentDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping()
	public ResponseEntity<ApartmentDTO> insert(@RequestBody ApartmentDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ApartmentDTO> update(@PathVariable Long id, @RequestBody ApartmentDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
