package dev.phellipe.psicanalise.application.rest.controllers.customer.impl;

import dev.phellipe.psicanalise.application.rest.controllers.customer.CustomerController;
import dev.phellipe.psicanalise.application.rest.requests.customer.CustomerFilterRequest;
import dev.phellipe.psicanalise.application.rest.requests.customer.CustomerRequest;
import dev.phellipe.psicanalise.application.rest.responses.customer.CustomerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static dev.phellipe.psicanalise.application.rest.controllers.URLRequestMappers.CUSTOMER_API;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = CUSTOMER_API)
public class CustomerControllerImpl implements CustomerController {

    @Override
    public ResponseEntity<CustomerResponse> create(CustomerRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerResponse> findById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<CustomerResponse>> findAll(CustomerFilterRequest request, Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerResponse> update(UUID id, CustomerRequest request) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
