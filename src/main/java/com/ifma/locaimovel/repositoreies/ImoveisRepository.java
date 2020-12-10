package com.ifma.locaimovel.repositoreies;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifma.locaimovel.entiteis.Imoveis;

//interface de acesso ao BD

public interface ImoveisRepository extends JpaRepository<Imoveis, Integer> {

}
