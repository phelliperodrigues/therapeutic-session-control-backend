package dev.phellipe.psicanalise.domain.repository.customer;

import dev.phellipe.psicanalise.domain.entity.customer.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepositoryFacade {
    Customer save(Customer customer);

    Optional<Customer> findById(UUID id);

    Page<Customer> findAll(Pageable pageable);

    void delete(Customer customer);

    Page<Customer> findAll(Example<Customer> filters, Pageable pageable);
}
