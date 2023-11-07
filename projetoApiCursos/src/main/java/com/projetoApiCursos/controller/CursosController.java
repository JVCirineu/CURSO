package com.projetoApiCursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoApiCursos.entities.Cursos;
import com.projetoApiCursos.service.CursosService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*")
public class CursosController {
	private final CursosService cursosServices;

	@Autowired
	public CursosController(CursosService cursosServices) {
		this.cursosServices = cursosServices;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cursos> buscaCursosControlId(@PathVariable Long id){
		Cursos cursos = cursosServices.buscaCursosId(id);
		if(cursos != null) {
			return ResponseEntity.ok(cursos);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Cursos>> buscaTodosFuncionarioCursosControl(){
		List<Cursos> Cursos = cursosServices.buscaTodosCursos();
		return ResponseEntity.ok(Cursos);
	}

	@PostMapping
	public ResponseEntity<Cursos> salvaCursosControl(@RequestBody @Valid Cursos cursos){
		Cursos salvaCursos = cursosServices.salvaCursos(cursos);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaCursos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cursos> alteraCursosControlId(@PathVariable Long id,@RequestBody @Valid Cursos cursos ){
		Cursos alteraCursos = cursosServices.alterarCursos(id, cursos);
		if(alteraCursos != null) {
			return ResponseEntity.ok(cursos);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Cursos> apagaCursosControl(@PathVariable Long id){
		boolean apagar = cursosServices.apagarCursos(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {	
			return ResponseEntity.notFound().build();
		}
	}
}

