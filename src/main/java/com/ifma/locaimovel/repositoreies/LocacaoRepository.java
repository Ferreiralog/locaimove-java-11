package com.ifma.locaimovel.repositoreies;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifma.locaimovel.entiteis.Locacao;

//interface de acesso ao BD

public interface LocacaoRepository extends JpaRepository<Locacao, Integer> {

}
