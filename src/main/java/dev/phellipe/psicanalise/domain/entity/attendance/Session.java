package dev.phellipe.psicanalise.domain.entity.attendance;

import dev.phellipe.psicanalise.domain.validation.attendance.SessionValidation;
import dev.phellipe.psicanalise.domain.entity.customer.Customer;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Data
@Builder(buildMethodName = "buildInternal")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Session {
    private UUID id;
    private Customer customer;
    private LocalDateTime schedule;
    private double value;
    private String observation;

    private void validate() {
        SessionValidation.build().validate(this);
    }

    public void update(Session session) {
        this.customer = session.getCustomer();
        this.schedule = session.getSchedule();
        this.value = session.getValue();
        this.observation = session.getObservation();
    }

    public static class SessionBuilder {
        public Optional<Session> buildOptional() {
            return Optional.of(this.build());
        }

        public Session build() {
            Session session = this.buildInternal();
            session.validate();
            return session;
        }
    }
}
