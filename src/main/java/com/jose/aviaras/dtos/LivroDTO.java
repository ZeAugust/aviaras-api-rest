package com.jose.aviaras.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.jose.aviaras.domain.Livro;

public class LivroDTO {
	
	private Integer id;
	@Length(min = 4, max = 100, message = "O número de caracteres deve estar entre 4 e 100")
	private String nome_autor;
	@NotEmpty(message= "Campo Titulo é requerido")
	@Length(min = 4, max = 100, message = "O número de caracteres deve estar entre 4 e 100")
	private String titulo;
	@Length(min = 4, max = 2000000, message = "O número de caracteres deve estar entre 4 e 100")
	private String texto;
	
	public LivroDTO() {
		super();
	}
	
	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.nome_autor = livro.getNome_autor();
		this.titulo = livro.getTitulo();
		this.texto = livro.getTexto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
