package com.dio.santander.banckline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.santander.banckline.api.models.Correntista;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

}
