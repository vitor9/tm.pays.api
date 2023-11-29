package com.tm.payments.api.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Data
public class Transferencia {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contaOrigem;

    private String contaDestino;

    private BigDecimal valorTransferencia;

    private LocalDate dataTransferencia;

}
