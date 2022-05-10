package dev.phellipe.psicanalise.infrastructure.database.pg.repository.managerial;

import dev.phellipe.psicanalise.infrastructure.database.pg.model.managerial.PaymentMethodModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentMethodModelRepository extends JpaRepository<PaymentMethodModel, UUID> {
}