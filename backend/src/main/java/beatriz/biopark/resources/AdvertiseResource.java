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

import beatriz.biopark.dto.AdvertiseDTO;
import beatriz.biopark.services.AdvertiseService;

@RestController
@RequestMapping(value = "/advertises")
public class AdvertiseResource {
	
	
	@Autowired
	private AdvertiseService service;
	
	@GetMapping
	public ResponseEntity<List<AdvertiseDTO>> findAll() {
		
		List<AdvertiseDTO> advertiseList = service.findAll();
		
		return ResponseEntity.ok().body(advertiseList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdvertiseDTO> findById(@PathVariable Long id) {
		
		AdvertiseDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);
	}

	
	@PostMapping
	public ResponseEntity<AdvertiseDTO> insert(@RequestBody AdvertiseDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AdvertiseDTO> update(@PathVariable Long id, @RequestBody AdvertiseDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
