package dev.phellipe.psicanalise.application.rest.controllers.customer;

import dev.phellipe.psicanalise.application.rest.requests.customer.CustomerFilterRequest;
import dev.phellipe.psicanalise.application.rest.requests.customer.CustomerRequest;
import dev.phellipe.psicanalise.application.rest.responses.customer.CustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static dev.phellipe.psicanalise.application.rest.controllers.URLRequestMappers.CUSTOMER_API;
import static dev.phellipe.psicanalise.application.rest.controllers.URLRequestMappers.CUSTOMER_API_BY_ID;

@RequestMapping(path = CUSTOMER_API)
@Tag(name = "Customers API")
public interface CustomerController {

    @Operation(summary = "Create a customer", description = "", method = "create(CustomerRequest request)")
    @PostMapping
    @Tag(name = "Customers API")
    ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest request);

    @Operation(summary = "Fetch a customer by id", description = "", method = "findById(UUID id)")
    @GetMapping(path = CUSTOMER_API_BY_ID)
    @Tag(name = "Customers API")
    ResponseEntity<CustomerResponse> findById(@PathVariable("id") UUID id);

    @Operation(summary = "Fetch and filter all customer pageable", description = "", method = "findAll(CustomerFilterRequest request)")
    @GetMapping
    @Tag(name = "Customers API")
    ResponseEntity<Page<CustomerResponse>> findAll(CustomerFilterRequest request, Pageable pageable);

    @Operation(summary = "Update a customer by id", description = "", method = "update(UUID id, CustomerRequest request)")
    @PutMapping(path = CUSTOMER_API_BY_ID)
    @Tag(name = "Customers API")
    ResponseEntity<CustomerResponse> update(@PathVariable("id") UUID id, @RequestBody CustomerRequest request);

    @Operation(summary = "Drop a customer by id", description = "", method = "deleteById(UUID id)")
    @DeleteMapping(path = CUSTOMER_API_BY_ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Tag(name = "Customers API")
    void deleteById(@PathVariable("id") UUID id);
}
