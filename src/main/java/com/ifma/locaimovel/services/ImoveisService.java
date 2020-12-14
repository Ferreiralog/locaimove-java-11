package com.ifma.locaimovel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifma.locaimovel.entiteis.Imoveis;
import com.ifma.locaimovel.repositoreies.ImoveisRepository;

@Service
public class ImoveisService {

	// dependencia para o ImoveisRepository

	@Autowired
	private ImoveisRepository repository;

	public List<Imoveis> findAll() {
		return repository.findAll();

	}

	public Imoveis findById(Integer id_imovel) {

		Optional<Imoveis> obj = repository.findById(id_imovel);
		return obj.get();
	}
}
