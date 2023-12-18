package br.unigoias.canil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unigoias.canil.model.Cao;
import br.unigoias.canil.model.Raca;
import br.unigoias.canil.repository.CaoRepository;
import br.unigoias.canil.repository.RacaRepository;

@Service
public class RacaService {
	
	@Autowired
	private RacaRepository racaRepository;
	
	@Autowired
	private CaoRepository caoRepository;

	
	
	//Mostrar todas as racas
	public List<Raca> findAllRacas() {
		
		return racaRepository.findAll();
	}
	
	
	
	//Procurar raca por Id
	public ResponseEntity<Raca> findRacaById(Long id) {
		
		Optional<Raca> raca = racaRepository.findById(id);
		
		if (raca.isPresent()) {
			return ResponseEntity.ok(raca.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	//Adicionar uma nova raca
	public  ResponseEntity<Raca> save(Raca raca) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(racaRepository.save(raca));
	}
	
	//Deletar uma raca
	public ResponseEntity<Raca> deleteRaca(Long id) {
			
		if (racaRepository.existsById(id)) {
			racaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
			
		return ResponseEntity.notFound().build();
	}
	
	//Atualizar os dados de uma raca
	public ResponseEntity<Raca> updateRaca(Long id, Raca raca) {
		
		if (racaRepository.existsById(id)) {
			raca.setId(id);
			
			return ResponseEntity.ok(racaRepository.save(raca));
		}
			
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
	
	//Listar todos os çães
	public List<Cao> findAllCao() {
		
		return caoRepository.findAll();
	}
	
	
	//Adicionar um cao
	public ResponseEntity<Cao> addCao(Long racaId, Cao cao) { 
				
		Optional<Raca> raca = racaRepository.findById(racaId);
		
		if (raca.isPresent()) {
			
			cao.setRaca(raca.get());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(caoRepository.save(cao));
		}
			
		return ResponseEntity.notFound().build();
	}

	//Deletar uma cao
	public ResponseEntity<Raca> deleteCao(Long id) {
			
		if (racaRepository.existsById(id)) {
			racaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
			
		return ResponseEntity.notFound().build();
	}
	
	//Filtro Lista os cães de uma raca
	public List<Cao> findByAllRacaId(Long racaId) { 
		
		Optional<Raca> raca = racaRepository.findById(racaId);
		
		if (raca.isPresent()) {
			
			
			return caoRepository.findByRaca(raca.get());
		}
			
		return null;
	}


}
