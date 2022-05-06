package dev.phellipe.psicanalise.domain.repository.managerial;

import dev.phellipe.psicanalise.domain.entity.managerial.PaymentMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface PaymentMethodRepositoryFacade {
    PaymentMethod save(PaymentMethod customer);

    Optional<PaymentMethod> findById(UUID id);

    Page<PaymentMethod> findAll(Pageable pageable);

    void delete(PaymentMethod customer);
}
