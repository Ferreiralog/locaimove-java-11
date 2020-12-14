package com.ifma.locaimovel.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifma.locaimovel.entiteis.Imoveis;
import com.ifma.locaimovel.services.ImoveisService;

@RestController
@RequestMapping(value = "/Imoveis")
public class ImoveisResource {
	@Autowired
	private ImoveisService service;

	@GetMapping
	public ResponseEntity<List<Imoveis>> findAll() {
		List<Imoveis> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id_imovel}")
	public ResponseEntity<Imoveis> findById(@PathVariable Integer id_imovel) {
		Imoveis obj = service.findById(id_imovel);
		return ResponseEntity.ok().body(obj);

	}
}
