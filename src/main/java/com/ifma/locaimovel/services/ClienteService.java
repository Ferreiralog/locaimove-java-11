package com.ifma.locaimovel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifma.locaimovel.entiteis.Cliente;
import com.ifma.locaimovel.repositoreies.ClienteRepository;

@Service
public class ClienteService {

	// dependencia para o ClienteRepository

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();

	}

	public Cliente findById(Integer id_nome) {

		Optional<Cliente> obj = repository.findById(id_nome);
		return obj.get();
	}
}
