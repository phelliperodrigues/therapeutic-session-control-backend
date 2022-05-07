package dev.phellipe.psicanalise.infrastructure.database.pg.facades.customer;

import dev.phellipe.psicanalise.domain.entity.customer.Customer;
import dev.phellipe.psicanalise.domain.repository.customer.CustomerRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerRepositoryFacadeImpl implements CustomerRepositoryFacade {
    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public Page<Customer> findAll(Example<Customer> filters, Pageable pageable) {
        return null;
    }
}
