package com.ifma.locaimovel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifma.locaimovel.entiteis.Contato;
import com.ifma.locaimovel.repositoreies.ContatoRepository;

@Service
public class ContatoService {

	// dependencia para o ContatoRepository

	@Autowired
	private ContatoRepository repository;

	public List<Contato> findAll() {
		return repository.findAll();

	}

	public Contato findById(Integer id_nome) {

		Optional<Contato> obj = repository.findById(id_nome);
		return obj.get();
	}
}
