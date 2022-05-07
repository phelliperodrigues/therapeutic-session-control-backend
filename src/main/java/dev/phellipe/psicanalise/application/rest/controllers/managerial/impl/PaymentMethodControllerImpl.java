package dev.phellipe.psicanalise.application.rest.controllers.managerial.impl;

import dev.phellipe.psicanalise.application.rest.controllers.managerial.PaymentMethodController;
import dev.phellipe.psicanalise.application.rest.requests.managerial.PaymentMethodRequest;
import dev.phellipe.psicanalise.application.rest.responses.managerial.PaymentMethodResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static dev.phellipe.psicanalise.application.rest.controllers.URLRequestMappers.PAYMENT_METHOD_API;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = PAYMENT_METHOD_API)
public class PaymentMethodControllerImpl implements PaymentMethodController {
    @Override
    public ResponseEntity<PaymentMethodResponse> create(PaymentMethodRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<PaymentMethodResponse> findById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<PaymentMethodResponse>> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<PaymentMethodResponse> update(UUID id, PaymentMethodRequest request) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
