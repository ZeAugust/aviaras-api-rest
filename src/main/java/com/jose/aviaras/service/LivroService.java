package com.jose.aviaras.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.aviaras.domain.Livro;
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

	public Livro update(Integer id, Livro livro) {
		Livro novoLivro = findById(id);
		updateValues(novoLivro, livro);
		return livroRepository.save(novoLivro);
	}

	private void updateValues(Livro novoLivro, Livro livro) {
		novoLivro.setTitulo(livro.getTitulo());
		novoLivro.setNome_autor(livro.getNome_autor());
		novoLivro.setTexto(livro.getTexto());
	}

	public Livro create(Livro livro) {
		livro.setId(null);
		return livroRepository.save(livro);
	}
}
