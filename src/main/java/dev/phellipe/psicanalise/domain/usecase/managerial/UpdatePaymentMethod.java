package dev.phellipe.psicanalise.domain.usecase.managerial;

import dev.phellipe.psicanalise.domain.entity.managerial.PaymentMethod;
import dev.phellipe.psicanalise.domain.repository.managerial.PaymentMethodRepositoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public record UpdatePaymentMethod(PaymentMethodRepositoryFacade paymentMethodRepository) {

    public PaymentMethod execute(UUID id, PaymentMethod paymentMethod) {
        return paymentMethodRepository.findById(id).map(fetch -> {
            log.info("Atualizando Metodo de Pagamento com id {}", id);
            fetch.update(paymentMethod);
            return paymentMethodRepository.save(fetch);
        }).orElseGet(() -> {
            var msg = "Erro ao Atualizar! Metodo de Pagamento não encontrado com id " + id;
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
        });
    }
}
