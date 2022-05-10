package dev.phellipe.psicanalise.domain.usecase.customer;

import dev.phellipe.psicanalise.domain.entity.customer.Customer;
import dev.phellipe.psicanalise.domain.repository.customer.CustomerRepositoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateCustomer {
    private final CustomerRepositoryFacade customerRepository;

    public Customer execute(UUID id, Customer customer) {
        return customerRepository.findById(id).map(fetch -> {
            log.info("Atualizando cliente com id {}", id);
            fetch.update(customer);
            return customerRepository.save(fetch);
        }).orElseGet(() -> {
            var msg = "Erro ao Atualizar! Cliente não encontrado com id " + id;
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
        });
    }
}
