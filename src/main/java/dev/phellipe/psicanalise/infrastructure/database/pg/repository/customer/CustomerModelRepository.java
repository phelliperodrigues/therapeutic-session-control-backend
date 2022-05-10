package dev.phellipe.psicanalise.infrastructure.database.pg.repository.customer;

import dev.phellipe.psicanalise.infrastructure.database.pg.model.customer.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerModelRepository extends JpaRepository<CustomerModel, UUID> {
}