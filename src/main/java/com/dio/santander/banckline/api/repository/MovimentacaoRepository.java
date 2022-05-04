package com.dio.santander.banckline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.santander.banckline.api.models.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

}
