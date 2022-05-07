package dev.phellipe.psicanalise.application.rest.requests.managerial;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentMethodRequest {
    private UUID id;
    private String description;
}
