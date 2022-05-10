package dev.phellipe.psicanalise.application.rest.controllers.managerial.impl;

import dev.phellipe.psicanalise.application.rest.controllers.managerial.PaymentMethodController;
import dev.phellipe.psicanalise.application.rest.requests.managerial.PaymentMethodRequest;
import dev.phellipe.psicanalise.application.rest.responses.managerial.PaymentMethodResponse;
import dev.phellipe.psicanalise.domain.usecase.managerial.*;
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

import static dev.phellipe.psicanalise.application.rest.controllers.URLRequestMappers.PAYMENT_METHOD_API;
import static dev.phellipe.psicanalise.application.rest.mappers.managerial.PaymentMethodMapper.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = PAYMENT_METHOD_API)
public class PaymentMethodControllerImpl implements PaymentMethodController {

    private final CreatePaymentMethod createPaymentMethod;
    private final DeletePaymentMethod deletePaymentMethod;
    private final FetchAllPaymentMethod fetchAllPaymentMethod;
    private final FetchPaymentMethodById fetchPaymentMethodById;
    private final UpdatePaymentMethod updatePaymentMethod;

    @Override
    public ResponseEntity<PaymentMethodResponse> create(PaymentMethodRequest request) {
        var paymentMethod = createPaymentMethod.execute(convertToEntity(request));
        return ResponseEntity.created(URI.create("")).body(convertToResponse(paymentMethod));
    }

    @Override
    public ResponseEntity<PaymentMethodResponse> findById(UUID id) {
        var paymentMethod = fetchPaymentMethodById.execute(id);
        return ResponseEntity.ok(convertToResponse(paymentMethod));
    }

    @Override
    public ResponseEntity<Page<PaymentMethodResponse>> findAll(Pageable pageable) {
        var paymentMethods = fetchAllPaymentMethod.execute(pageable);
        var response = convertToResponsePageable(paymentMethods);
        return ResponseEntity.ok(new PageImpl<>(response, pageable, paymentMethods.getTotalElements()));
    }

    @Override
    public ResponseEntity<PaymentMethodResponse> update(UUID id, PaymentMethodRequest request) {
        var paymentMethod = updatePaymentMethod.execute(id, convertToEntity(request));
        return ResponseEntity.ok(convertToResponse(paymentMethod));
    }

    @Override
    public void deleteById(UUID id) {
        deletePaymentMethod.execute(id);
    }
}
