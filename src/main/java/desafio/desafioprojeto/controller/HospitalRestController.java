package desafio.desafioprojeto.controller;

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

import desafio.desafioprojeto.model.Hospital;
import desafio.desafioprojeto.service.HospitalService;

/**
*
*@author jardeljbastos
*
*/

@RestController
@RequestMapping("hospital")
public class HospitalRestController {

	@Autowired
	private HospitalService hospitalService;

	@GetMapping
	public ResponseEntity<Iterable<Hospital>> buscarTodos() {
		return ResponseEntity.ok(hospitalService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hospital> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(hospitalService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Hospital> inserir(@RequestBody Hospital hospital) {
		hospitalService.inserir(hospital);
		return ResponseEntity.ok(hospital);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Hospital> atualizar(@PathVariable Long id, @RequestBody Hospital hospital) {
		hospitalService.atualizar(id, hospital);
		return ResponseEntity.ok(hospital);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		hospitalService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
