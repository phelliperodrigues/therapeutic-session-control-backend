package dev.phellipe.psicanalise.application.rest.controllers.customer.impl;

import dev.phellipe.psicanalise.application.rest.controllers.customer.CustomerController;
import dev.phellipe.psicanalise.application.rest.mappers.customer.CustomerMapper;
import dev.phellipe.psicanalise.application.rest.requests.customer.CustomerFilterRequest;
import dev.phellipe.psicanalise.application.rest.requests.customer.CustomerRequest;
import dev.phellipe.psicanalise.application.rest.responses.customer.CustomerResponse;
import dev.phellipe.psicanalise.domain.usecase.customer.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

import static dev.phellipe.psicanalise.application.rest.controllers.URLRequestMappers.CUSTOMER_API;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = CUSTOMER_API)
public class CustomerControllerImpl implements CustomerController {

    private final CreateCustomer createCustomer;
    private final DeleteCustomer deleteCustomer;
    private final FetchCustomerById fetchCustomerById;
    private final FindCustomer findCustomer;
    private final UpdateCustomer updateCustomer;

    @Override
    public ResponseEntity<CustomerResponse> create(CustomerRequest request) {
        var customer = createCustomer.execute(CustomerMapper.convertToEntity(request));
        return ResponseEntity.created(URI.create("")).body(CustomerMapper.convertToResponse(customer));
    }

    @Override
    public ResponseEntity<CustomerResponse> findById(UUID id) {
        var customer = fetchCustomerById.execute(id);
        return ResponseEntity.ok(CustomerMapper.convertToResponse(customer));
    }

    @Override
    public ResponseEntity<Page<CustomerResponse>> findAll(CustomerFilterRequest request, Pageable pageable) {
        var customers = findCustomer.execute(CustomerMapper.convertToEntity(request), pageable);
        var response = CustomerMapper.convertToResponsePageable(customers);
        return ResponseEntity.ok(new PageImpl<>(response, pageable, customers.getTotalElements()));
    }

    @Override
    public ResponseEntity<CustomerResponse> update(UUID id, CustomerRequest request) {
        var customer = updateCustomer.execute(id, CustomerMapper.convertToEntity(request));
        return ResponseEntity.ok(CustomerMapper.convertToResponse(customer));
    }

    @Override
    public void deleteById(UUID id) {
        deleteCustomer.execute(id);
    }
}
