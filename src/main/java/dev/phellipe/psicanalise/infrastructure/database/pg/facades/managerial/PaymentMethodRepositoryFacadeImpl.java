package dev.phellipe.psicanalise.infrastructure.database.pg.facades.managerial;

import dev.phellipe.psicanalise.domain.entity.managerial.PaymentMethod;
import dev.phellipe.psicanalise.domain.repository.managerial.PaymentMethodRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentMethodRepositoryFacadeImpl implements PaymentMethodRepositoryFacade {
    @Override
    public PaymentMethod save(PaymentMethod customer) {
        return null;
    }

    @Override
    public Optional<PaymentMethod> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Page<PaymentMethod> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(PaymentMethod customer) {

    }
}
