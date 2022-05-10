package dev.phellipe.psicanalise.domain.usecase.managerial;

import dev.phellipe.psicanalise.domain.entity.managerial.PaymentMethod;
import dev.phellipe.psicanalise.domain.repository.managerial.PaymentMethodRepositoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreatePaymentMethod {
    private final PaymentMethodRepositoryFacade paymentMethodRepository;

    public PaymentMethod execute(PaymentMethod paymentMethod) {
        var created = paymentMethodRepository.save(paymentMethod);
        log.info("Metodo de Pagamento criado, ID: {}", paymentMethod.getId());
        return created;
    }
}
