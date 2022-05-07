package dev.phellipe.psicanalise.domain.usecase.customer;

import dev.phellipe.psicanalise.domain.entity.customer.Customer;
import dev.phellipe.psicanalise.domain.repository.customer.CustomerRepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public record FindCustomer(CustomerRepositoryFacade customerRepository) {

    public Page<Customer> execute(Customer filter, Pageable pageable){
        var filters = Example.of(filter,
                ExampleMatcher
                        .matching()
                        .withIgnoreCase()
                        .withIgnoreNullValues()
                        .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING)
        ) ;
        return customerRepository.findAll(filters, pageable);
    }
}
