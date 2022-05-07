package dev.phellipe.psicanalise.application.rest.mappers.managerial;

import dev.phellipe.psicanalise.application.rest.requests.managerial.PaymentMethodRequest;
import dev.phellipe.psicanalise.application.rest.responses.managerial.PaymentMethodResponse;
import dev.phellipe.psicanalise.domain.entity.managerial.PaymentMethod;

public class PaymentMethodMapper {

    public static PaymentMethodResponse convertToResponse(PaymentMethod paymentMethod) {
        return PaymentMethodResponse.builder()
                .id(paymentMethod.getId())
                .description(paymentMethod.getDescription())
                .build();
    }

    public static PaymentMethod convertToEntity(PaymentMethodRequest request) {
        return PaymentMethod.builder()
                .id(request.getId())
                .description(request.getDescription())
                .build();
    }
}
