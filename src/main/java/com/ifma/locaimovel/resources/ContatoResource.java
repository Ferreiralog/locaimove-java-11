package com.ifma.locaimovel.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifma.locaimovel.entiteis.Contato;
import com.ifma.locaimovel.services.ContatoService;

@RestController
@RequestMapping(value = "/Contato")
public class ContatoResource {
	@Autowired
	private ContatoService service;

	@GetMapping
	public ResponseEntity<List<Contato>> findAll() {
		List<Contato> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Contato> findById(@PathVariable Integer id) {
		Contato obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}
}
