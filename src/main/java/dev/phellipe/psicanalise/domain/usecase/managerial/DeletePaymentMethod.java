package dev.phellipe.psicanalise.domain.usecase.managerial;

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
public record DeletePaymentMethod(PaymentMethodRepositoryFacade paymentMethodRepository) {

    public void execute(UUID id){
        paymentMethodRepository.findById(id).ifPresentOrElse(paymentMethod -> {
            paymentMethodRepository.delete(paymentMethod);
            log.info("Metodo de Pagamento deletado com sucesso! id {}", id);
        }, () -> {
            var msg = "Erro ao Deletar! Metodo de Pagamento não encontrado com id " + id;
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
        });
    }
}
