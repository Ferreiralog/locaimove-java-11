package com.ifma.locaimovel.repositoreies;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifma.locaimovel.entiteis.Endereco;

//interface de acesso ao BD

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
