package com.dio.santander.banckline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.banckline.api.dto.NovoCorrentista;
import com.dio.santander.banckline.api.models.Correntista;
import com.dio.santander.banckline.api.repository.CorrentistaRepository;
import com.dio.santander.banckline.api.service.CorrentistaService;

@CrossOrigin
@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
	
	@Autowired
	CorrentistaRepository correntistaRepository;
	
	@Autowired
	CorrentistaService correntistaService;
	
	@GetMapping()
	public List<Correntista> findAll() {
		return correntistaRepository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovoCorrentista novoCorrentista) {
		correntistaService.save(novoCorrentista);
		
	}
}
