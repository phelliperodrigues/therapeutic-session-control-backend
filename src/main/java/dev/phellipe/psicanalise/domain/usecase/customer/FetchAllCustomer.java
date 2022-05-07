package dev.phellipe.psicanalise.domain.usecase.customer;

import dev.phellipe.psicanalise.domain.entity.customer.Customer;
import dev.phellipe.psicanalise.domain.repository.customer.CustomerRepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public record FetchAllCustomer(
        CustomerRepositoryFacade customerRepository) {

    public Page<Customer> execute(Pageable pageable) {
        log.info("Buscando todos os clientes");
        return customerRepository.findAll(pageable);
    }
}
