package com.jose.aviaras.service;

import java.util.List;
import java.util.Optional;

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
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id){
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado para o id: " + id));
	}
	
	public List<Livro> findAll(Integer id_cat){
		categoriaService.findById(id_cat);
		return livroRepository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, LivroDTO livroDTO) {
		Livro novoLivro = findById(id);
		updateValues(novoLivro, livroDTO);
		return livroRepository.save(novoLivro);
	}

	private void updateValues(Livro novoLivro, LivroDTO livroDTO) {
		novoLivro.setTitulo(livroDTO.getTitulo());
		novoLivro.setNome_autor(livroDTO.getNome_autor());
		novoLivro.setTexto(livroDTO.getTexto());
	}

	public Livro create(Livro livro) {
		livro.setId(null);
		return livroRepository.save(livro);
	}

	public void delete(Integer id) {
		findById(id);
		livroRepository.deleteById(id);
	}
}
