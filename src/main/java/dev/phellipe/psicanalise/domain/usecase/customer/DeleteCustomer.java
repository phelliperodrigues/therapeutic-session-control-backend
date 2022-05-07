package dev.phellipe.psicanalise.domain.usecase.customer;

import dev.phellipe.psicanalise.domain.repository.customer.CustomerRepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Slf4j
@Component
public record DeleteCustomer(CustomerRepositoryFacade customerRepository) {

    public void execute(UUID id) {
        customerRepository.findById(id).ifPresentOrElse(customer -> {
            customerRepository.delete(customer);
            log.info("Cliente deletado com sucesso! id {}", id);

        }, () -> {
            var msg = "Erro ao Deletar! Cliente não encontrado com id " + id;
            log.error(msg);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
        });
    }
}
