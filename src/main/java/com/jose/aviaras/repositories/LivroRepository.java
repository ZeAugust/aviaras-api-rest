package com.jose.aviaras.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jose.aviaras.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	@Query("SELECT coc FROM Livro coc WHERE coc.categoria.id = :id_cat")
	List<Livro> findAllByCategoria(@Param(value = "id_cat")Integer id_cat);

}
