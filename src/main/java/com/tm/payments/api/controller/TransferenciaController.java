package com.tm.payments.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm.payments.api.model.Transferencia;
import com.tm.payments.api.repository.TransferenciaRepository;

@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

	 private final TransferenciaRepository transferenciaRepository;

	    @Autowired
	    public TransferenciaController(TransferenciaRepository transferenciaRepository) {
	        this.transferenciaRepository = transferenciaRepository;
	    }

	    @GetMapping
	    public List<Transferencia> listarTransferencias() {
	        return transferenciaRepository.findAll();
	    }

	    @PostMapping
	    public Transferencia realizarTransferencia(@RequestBody Transferencia transferencia) {
	        return transferenciaRepository.save(transferencia);
	    }
	
}
