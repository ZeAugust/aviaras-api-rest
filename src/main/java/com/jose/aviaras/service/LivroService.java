package com.jose.aviaras.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.aviaras.domain.Livro;
import com.jose.aviaras.dtos.LivroDTO;
import com.jose.aviaras.repositories.LivroRepository;
import com.jose.aviaras.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService{
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro findById(Integer id){
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado para o id: " + id));
	}
	
	public List<LivroDTO> findAll(){
		List<Livro> list = livroRepository.findAll();
		List<LivroDTO> livrosDTO = list.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
		return livrosDTO;
	}
}
