package com.jose.aviaras.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.jose.aviaras.domain.Categoria;

public class CategoriaDTO {
	
	private Integer id;
	@NotEmpty(message = "O campo NOME não pode estar vazio")
	@Length(min = 4, max = 100, message = "Deve contar um numero de caracteres entre 4 e 100")
	private String nome;
	@Length(min = 4, max = 300, message = "Deve contar um numero de caracteres entre 4 e 300")
	private String descricao;
	
	public CategoriaDTO() {
		super();
	}
	
	public CategoriaDTO(Categoria cat) {
		super();
		this.id = cat.getId();
		this.nome = cat.getNome();
		this.descricao = cat.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
