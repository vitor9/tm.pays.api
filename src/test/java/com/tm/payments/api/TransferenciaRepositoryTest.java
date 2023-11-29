package com.tm.payments.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.tm.payments.api.model.Transferencia;
import com.tm.payments.api.repository.TransferenciaRepository;

@DataJpaTest
public class TransferenciaRepositoryTest {

	@Autowired
    private TransferenciaRepository transferenciaRepository;

    @Test
    @Transactional
    public void testSalvarEConsultarTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.setContaOrigem("123456");
        transferencia.setContaDestino("789012");
        transferencia.setValorTransferencia(BigDecimal.valueOf(100.00));
        transferencia.setDataTransferencia(LocalDate.now());

        transferenciaRepository.save(transferencia);

        Transferencia transferenciaSalva = transferenciaRepository.findById(transferencia.getId()).orElse(null);
        transferenciaRepository.findAll();

        assertThat(transferenciaSalva).isNotNull();
        assertThat(transferenciaSalva.getContaOrigem()).isEqualTo("123456");
        assertThat(transferenciaSalva.getContaDestino()).isEqualTo("789012");
        assertThat(transferenciaSalva.getValorTransferencia()).isEqualTo(BigDecimal.valueOf(100.00));
        assertThat(transferenciaSalva.getDataTransferencia()).isEqualTo(LocalDate.now());
        
    }
	
}
