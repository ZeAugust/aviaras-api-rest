package com.jose.aviaras.dtos;

import com.jose.aviaras.domain.Categoria;

public class CategoriaDTO {
	
	private Integer id;
	private String nome;
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
