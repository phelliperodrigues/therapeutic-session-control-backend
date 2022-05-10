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
public class FetchPaymentMethodById {
    private final PaymentMethodRepositoryFacade paymentMethodRepository;

    public PaymentMethod execute(UUID id) {
        log.info("Buscando Metodo de Pagamento com id {}", id);
        return paymentMethodRepository.findById(id).orElseThrow(() -> {
            var msg = "Metodo de Pagamento não encontrado com id " + id;
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
        });
    }
}
