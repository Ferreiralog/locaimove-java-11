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
	
	//CRUD Inserir cliente na tabela Cliente
	
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id_nome) {
		repository.deleteById(id_nome);
	}
	
	public Cliente update(Integer id_nome, Cliente obj) {
		
		Cliente entity = repository.getOne(id_nome);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setData_nascimento(obj.getData_nascimento());
		
		
	}

			
}
