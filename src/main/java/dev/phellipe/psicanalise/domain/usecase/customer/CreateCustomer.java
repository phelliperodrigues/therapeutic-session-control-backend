package dev.phellipe.psicanalise.domain.usecase.customer;

import dev.phellipe.psicanalise.domain.entity.customer.Customer;
import dev.phellipe.psicanalise.domain.repository.customer.CustomerRepositoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public final class CreateCustomer {

    private final CustomerRepositoryFacade customerRepository;

    public Customer execute(Customer customer) {
        var created = customerRepository.save(customer);
        log.info("Novo cliente criado, ID: {}", customer.getId());
        return created;
    }


}
