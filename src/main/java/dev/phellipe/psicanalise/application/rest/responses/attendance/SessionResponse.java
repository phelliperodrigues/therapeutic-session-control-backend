package dev.phellipe.psicanalise.application.rest.responses.attendance;

import dev.phellipe.psicanalise.application.rest.responses.customer.CustomerResponse;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SessionResponse {

    private UUID id;
    private CustomerResponse customer;
    private LocalDateTime schedule;
    private double value;
    private String observation;
}
