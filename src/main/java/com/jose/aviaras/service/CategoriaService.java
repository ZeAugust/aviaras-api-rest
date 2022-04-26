package com.jose.aviaras.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jose.aviaras.domain.Categoria;
import com.jose.aviaras.dtos.CategoriaDTO;
import com.jose.aviaras.repositories.CategoriaRepository;
import com.jose.aviaras.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! Id:" + id));
	}
	
	public List<CategoriaDTO> findAll(){
		List<Categoria> list = categoriaRepository.findAll();
		List<CategoriaDTO> listCatDTO = list.stream().map(cat -> new CategoriaDTO(cat)).collect(Collectors.toList());
		return listCatDTO;
	}
	
	public Categoria create(Categoria cat) {
		return categoriaRepository.save(cat);
	}
	
	public Categoria uptade(Integer id, CategoriaDTO catDTO) {
		Categoria cat = findById(id);
		cat.setNome(catDTO.getNome());
		cat.setDescricao(catDTO.getDescricao());
		return categoriaRepository.save(cat);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.jose.aviaras.service.exceptions.DataIntegrityViolationException("Catgoria não pode ser deletado! Possui livros associados");
		}
	}
}
