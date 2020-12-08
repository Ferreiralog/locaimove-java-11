package com.ifma.locaimovel.repositoreies;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifma.locaimovel.entiteis.Cliente;

//interface de acesso ao BD

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
