package com.ifma.locaimovel.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifma.locaimovel.entiteis.Locacao;
import com.ifma.locaimovel.services.LocacaoService;

@RestController
@RequestMapping(value = "/Locacao")
public class LocacaoResource {
	@Autowired
	private LocacaoService service;

	@GetMapping
	public ResponseEntity<List<Locacao>> findAll() {
		List<Locacao> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Locacao> findById(@PathVariable Integer id) {
		Locacao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}
}
