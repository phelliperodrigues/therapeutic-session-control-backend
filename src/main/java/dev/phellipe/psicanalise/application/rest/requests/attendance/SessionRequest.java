package dev.phellipe.psicanalise.application.rest.requests.attendance;

import dev.phellipe.psicanalise.application.rest.requests.customer.CustomerRequest;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SessionRequest {

    private UUID id;
    @NotNull(message = "Cliente é Obrigatório")
    private CustomerRequest customer;
    @NotNull(message = "Data da sessão é Obrigatório")
    private LocalDateTime schedule;
    @Min(value = 0, message = "Valor invalido")
    private double value;
    private String observation;
}
