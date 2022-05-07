package dev.phellipe.psicanalise.application.rest.responses.managerial;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentMethodResponse {
    private UUID id;
    private String description;
}
