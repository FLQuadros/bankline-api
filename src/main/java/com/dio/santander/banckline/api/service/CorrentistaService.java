package com.dio.santander.banckline.api.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banckline.api.dto.NovoCorrentista;
import com.dio.santander.banckline.api.models.Conta;
import com.dio.santander.banckline.api.models.Correntista;
import com.dio.santander.banckline.api.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
	
	@Autowired
	CorrentistaRepository correntistaRepository;
	
	public void save(NovoCorrentista novoCorrentista) {
		Correntista correntista = new Correntista();
		correntista.setCpf(novoCorrentista.getCpf());
		correntista.setNome(novoCorrentista.getNome());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		
		correntista.setConta(conta);
		correntistaRepository.save(correntista);
	}
}
