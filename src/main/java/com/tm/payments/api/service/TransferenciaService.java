package com.tm.payments.api.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.payments.api.model.Transferencia;
import com.tm.payments.api.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
    private TransferenciaRepository transferenciaRepository;

    public void processarTransferencia(Transferencia transferencia) {
        BigDecimal taxa = calcularTaxa(transferencia.getDataTransferencia());

        if (taxa.compareTo(BigDecimal.ZERO) == 0) {
            throw new RuntimeException("Não há taxa aplicável para a transferência.");
        }

        transferencia.setTaxa(taxa);
        transferenciaRepository.save(transferencia);
    }

    private static BigDecimal calcularTaxa(LocalDate dataTransferencia) {
        // Lógica para calcular a taxa com base nos dias de transferência
        int dias = calcularDiasEntreHojeEDataTransferencia(dataTransferencia);

        if (dias >= 0 && dias <= 3) {
            return BigDecimal.valueOf(2.5);
        } else if (dias >= 1 && dias <= 10) {
            return BigDecimal.ZERO;
        } else if (dias >= 11 && dias <= 20) {
            return BigDecimal.valueOf(8.2);
        } else if (dias >= 21 && dias <= 30) {
            return BigDecimal.valueOf(6.9);
        } else if (dias >= 31 && dias <= 40) {
            return BigDecimal.valueOf(4.7);
        } else if (dias >= 41 && dias <= 50) {
            return BigDecimal.valueOf(1.7);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private static int calcularDiasEntreHojeEDataTransferencia(LocalDate dataTransferencia) {
        LocalDate hoje = LocalDate.now();
        return (int) hoje.until(dataTransferencia).getDays();
    }
	
}
