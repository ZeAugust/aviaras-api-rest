package com.jose.aviaras.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.aviaras.domain.Categoria;
import com.jose.aviaras.domain.Livro;
import com.jose.aviaras.repositories.CategoriaRepository;
import com.jose.aviaras.repositories.LivroRepository;

@Service
public class AviarasService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		
			Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
			Categoria cat2 = new Categoria(null, "Fantasia medieval", "Historias do periodo medival envolvendo seres fantasticos e magia");
			Categoria cat3 = new Categoria(null, "Aventura", "Tramas empolgante");
			Categoria cat4 = new Categoria(null, "Terror", "Historias que despertam medo nas pessoas");
			
			Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum amet", cat1);
			Livro l2 = new Livro(null, "O Hobbit", "J.R.R Tolkien", "História de um Hobbit", cat2);
			Livro l3 = new Livro(null, "Percy Jackson", "Rick Riordan", "Um menino que é filho do Netuno", cat3);
			Livro l4 = new Livro(null, "It - A Coisa", "Stephen King", "Palahço do mal", cat4);
			
			
			cat1.getLivros().addAll(Arrays.asList(l1));
			cat2.getLivros().addAll(Arrays.asList(l2));
			cat3.getLivros().addAll(Arrays.asList(l3));
			cat4.getLivros().addAll(Arrays.asList(l4));
			
			this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
			this.livroRepository.saveAll(Arrays.asList(l1,l2 ,l3 ,l4));		
		
	}
}
