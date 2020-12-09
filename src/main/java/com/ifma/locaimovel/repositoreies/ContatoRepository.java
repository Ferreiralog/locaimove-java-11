package com.ifma.locaimovel.repositoreies;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifma.locaimovel.entiteis.Contato;

//interface de acesso ao BD

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
