package com.jose.aviaras.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Categoria implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@NotEmpty(message = "O campo NOME não pode estar vazio")
		@Length(min = 4, max = 100, message = "Deve contar um numero de caracteres entre 4 e 100")
		private String nome;
		@Length(min = 4, max = 300, message = "Deve contar um numero de caracteres entre 4 e 300")
		private String descricao;
		
		@OneToMany(mappedBy = "categoria")
		private List<Livro> livros = new ArrayList<>();
		
		public Categoria() {
			super();
		}

		public Categoria(Integer id, String nome, String descricao) {
			super();
			this.id = id;
			this.nome = nome;
			this.descricao = descricao;
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

		public List<Livro> getLivros() {
			return livros;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Categoria other = (Categoria) obj;
			return id == other.id;
		}

		@Override
		public String toString() {
			return "Categoria [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
		}
		
}
