package com.ifma.locaimovel.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ifma.locaimovel.entiteis.Cliente;
import com.ifma.locaimovel.services.ClienteService;

@RestController
@RequestMapping(value = "/Cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id_nome}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id_nome) {
		Cliente obj = service.findById(id_nome);
		return ResponseEntity.ok().body(obj);

	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_nome}").buildAndExpand(obj.getId_nome()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	@DeleteMapping(value = "/{id_nome}")
	public ResponseEntity<Void> delete(@PathVariable Integer id_nome){
		service.delete(id_nome);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id_nome}")
	public ResponseEntity<Cliente> update(@PathVariable Integer id_nome, @RequestBody Cliente obj){
		obj = service.update(id_nome, obj);
		return ResponseEntity.ok().body(obj);
	}
}
