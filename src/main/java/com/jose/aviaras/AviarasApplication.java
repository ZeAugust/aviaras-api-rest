package com.jose.aviaras;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jose.aviaras.domain.Categoria;
import com.jose.aviaras.domain.Livro;
import com.jose.aviaras.repositories.CategoriaRepository;
import com.jose.aviaras.repositories.LivroRepository;

@SpringBootApplication
public class AviarasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AviarasApplication.class, args);
	}
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum amet", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
		
	}

}
