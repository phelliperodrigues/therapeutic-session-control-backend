package dev.phellipe.psicanalise.application.rest.requests.attendance;

import dev.phellipe.psicanalise.application.rest.requests.customer.CustomerRequest;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SessionFilterRequest {

    private UUID id;
    private CustomerRequest customer;
    private LocalDateTime schedule;
    private double value;
    private String observation;
}
