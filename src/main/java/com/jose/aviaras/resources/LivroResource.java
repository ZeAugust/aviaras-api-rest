package com.jose.aviaras.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.aviaras.domain.Livro;
import com.jose.aviaras.dtos.LivroDTO;
import com.jose.aviaras.service.LivroService;

@RestController
@RequestMapping(value = "/livro")
public class LivroResource {
		
	@Autowired
	private LivroService livroService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro livro = livroService.findById(id);
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(){
		List<LivroDTO> livrosDTO = livroService.findAll();
		return ResponseEntity.ok().body(livrosDTO);
	}
}