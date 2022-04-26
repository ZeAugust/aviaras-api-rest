package com.jose.aviaras.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jose.aviaras.domain.Categoria;
import com.jose.aviaras.dtos.CategoriaDTO;
import com.jose.aviaras.service.CategoriaService;

@RestController
@RequestMapping(value= "/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		return  ResponseEntity.ok().body(categoriaService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		return ResponseEntity.ok().body(categoriaService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria cat){
		cat = categoriaService.create(cat);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId()).toUri();
		return ResponseEntity.created(uri).body(cat);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO catDTO){
		Categoria cat = categoriaService.uptade(id, catDTO);
		return ResponseEntity.ok().body(new CategoriaDTO(cat));
	}
}
