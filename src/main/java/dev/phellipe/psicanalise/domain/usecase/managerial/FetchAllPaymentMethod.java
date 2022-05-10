package dev.phellipe.psicanalise.domain.usecase.managerial;

import dev.phellipe.psicanalise.domain.entity.managerial.PaymentMethod;
import dev.phellipe.psicanalise.domain.repository.managerial.PaymentMethodRepositoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FetchAllPaymentMethod {
    private final PaymentMethodRepositoryFacade paymentMethodRepository;

    public Page<PaymentMethod> execute(Pageable pageable) {
        log.info("Buscando todos os Metodo de Pagamentos");
        return paymentMethodRepository.findAll(pageable);
    }
}
