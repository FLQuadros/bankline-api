package com.dio.santander.banckline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banckline.api.dto.NovaMovimentacao;
import com.dio.santander.banckline.api.models.Correntista;
import com.dio.santander.banckline.api.models.Movimentacao;
import com.dio.santander.banckline.api.models.MovimentacaoTipo;
import com.dio.santander.banckline.api.repository.CorrentistaRepository;
import com.dio.santander.banckline.api.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	CorrentistaRepository correntistaRepository;
	
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		
		Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if( correntista != null ) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		
		movimentacaoRepository.save(movimentacao);
	}

}
