package dev.phellipe.psicanalise.application.rest.requests.customer;

import dev.phellipe.psicanalise.application.rest.requests.managerial.PaymentMethodRequest;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerRequest {

    private UUID id;
    private String name;
    private String documentNumber;
    private String rg;
    private AddressRequest address;
    private ContactRequest contact;
    private Set<PaymentMethodRequest> paymentMethods = new HashSet<>();
}
