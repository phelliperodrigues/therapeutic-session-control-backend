package dev.phellipe.psicanalise.application.rest.controllers.managerial;

import dev.phellipe.psicanalise.application.rest.requests.managerial.PaymentMethodRequest;
import dev.phellipe.psicanalise.application.rest.responses.managerial.PaymentMethodResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static dev.phellipe.psicanalise.application.rest.controllers.URLRequestMappers.PAYMENT_METHOD_API;
import static dev.phellipe.psicanalise.application.rest.controllers.URLRequestMappers.PAYMENT_METHOD_API_BY_ID;

@RequestMapping(path = PAYMENT_METHOD_API)
@Tag(name = "Payment Methods API")
public interface PaymentMethodController {

    @Operation(summary = "Create a payment method", description = "", method = "create(PaymentMethodRequest request)")
    @PostMapping
    @Tag(name = "Payment Methods API")
    ResponseEntity<PaymentMethodResponse> create(@RequestBody PaymentMethodRequest request);

    @Operation(summary = "Fetch a payment method by id", description = "", method = "findById(UUID id)")
    @GetMapping(path = PAYMENT_METHOD_API_BY_ID)
    @Tag(name = "Payment Methods API")
    ResponseEntity<PaymentMethodResponse> findById(@PathVariable("id") UUID id);

    @Operation(summary = "Fetch and filter all payment method pageable", description = "", method = "findAll(Pageable pageable)")
    @GetMapping
    @Tag(name = "Payment Methods API")
    ResponseEntity<Page<PaymentMethodResponse>> findAll(Pageable pageable);

    @Operation(summary = "Update a payment method by id", description = "", method = "update(UUID id, PaymentMethodRequest request)")
    @PutMapping(path = PAYMENT_METHOD_API_BY_ID)
    @Tag(name = "Payment Methods API")
    ResponseEntity<PaymentMethodResponse> update(@PathVariable("id") UUID id, @RequestBody PaymentMethodRequest request);

    @Operation(summary = "Drop a payment method by id", description = "", method = "deleteById(UUID id)")
    @DeleteMapping(path = PAYMENT_METHOD_API_BY_ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Tag(name = "Payment Methods API")
    void deleteById(@PathVariable("id") UUID id);
}
