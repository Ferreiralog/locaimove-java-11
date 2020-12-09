package com.ifma.locaimovel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifma.locaimovel.entiteis.Locacao;
import com.ifma.locaimovel.repositoreies.LocacaoRepository;

@Service
public class LocacaoService {

	// dependencia para o LocacaoRepository

	@Autowired
	private LocacaoRepository repository;

	public List<Locacao> findAll() {
		return repository.findAll();

	}

	public Locacao findById(Integer id_nome) {

		Optional<Locacao> obj = repository.findById(id_nome);
		return obj.get();
	}
}
