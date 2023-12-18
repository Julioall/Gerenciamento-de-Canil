package br.unigoias.canil.controller;

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

import br.unigoias.canil.model.Cao;
import br.unigoias.canil.model.Raca;
import br.unigoias.canil.service.RacaService;

@RestController
@RequestMapping("/raca")
public class RacaController {

	@Autowired
	private RacaService racaService;
	
	@GetMapping()
	public List<Raca> findAll() {
		
		return racaService.findAllRacas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Raca> findById(@PathVariable Long id) {
		
		return racaService.findRacaById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Raca> deleteById(@PathVariable Long id) {
		
		return racaService.deleteRaca(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Raca> update(@PathVariable Long id, @RequestBody Raca novaRaca) {
		
		return racaService.updateRaca(id,novaRaca);
	}
	@PostMapping
	public ResponseEntity<Raca> save(@RequestBody Raca raca) {
		return racaService.save(raca);
	}
	
	@PostMapping("/{racaId}/cao")
	public ResponseEntity<Cao> addCao(@PathVariable Long racaId, @RequestBody Cao cao) {
		return racaService.addCao(racaId, cao);
	}
	
	@PostMapping("/{racaId}/cao")
	public List<Cao> findByAllRacaId(@PathVariable Long racaId) {
		return racaService.findByAllRacaId(racaId);
	}
}
