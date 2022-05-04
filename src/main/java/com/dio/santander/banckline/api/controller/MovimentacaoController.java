package com.dio.santander.banckline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.banckline.api.dto.NovaMovimentacao;
import com.dio.santander.banckline.api.models.Movimentacao;
import com.dio.santander.banckline.api.repository.MovimentacaoRepository;
import com.dio.santander.banckline.api.service.MovimentacaoService;

@CrossOrigin
@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	
	@Autowired
	MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	MovimentacaoService movimentacaoService;
	
	
	@GetMapping()
	public List<Movimentacao> findAll() {
		return movimentacaoRepository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovaMovimentacao novaMovimentacao ) {
		movimentacaoService.save(novaMovimentacao);
		
	}
}
