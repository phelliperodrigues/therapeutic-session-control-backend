package dev.phellipe.psicanalise.application.rest.responses.customer;

import dev.phellipe.psicanalise.application.rest.responses.managerial.PaymentMethodResponse;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerResponse {

    private UUID id;
    private String name;
    private String documentNumber;
    private String rg;
    private AddressResponse address;
    private ContactResponse contact;
    private Set<PaymentMethodResponse> paymentMethods = new HashSet<>();
}
