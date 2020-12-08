package com.ifma.locaimovel.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifma.locaimovel.entiteis.Cliente;

@RestController
@RequestMapping(value = "/Cliente")
public class ClienteResource {
    @GetMapping
	public ResponseEntity<Cliente> findAll() {

		Cliente c = new Cliente(1, "maria", "37654328712", "2019-09-3");

		return ResponseEntity.ok().body(c);

	}

}
