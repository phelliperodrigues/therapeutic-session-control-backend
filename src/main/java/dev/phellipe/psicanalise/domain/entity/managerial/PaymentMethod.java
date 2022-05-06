package dev.phellipe.psicanalise.domain.entity.managerial;

import dev.phellipe.psicanalise.domain.validation.managerial.PaymentMethodValidation;
import lombok.*;

import java.util.Optional;
import java.util.UUID;

@Data
@Builder(buildMethodName = "buildInternal")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentMethod {
    private UUID id;
    private String description;

    private void validate() {
        PaymentMethodValidation.build().validate(this);
    }

    public void update(PaymentMethod paymentMethod) {
        this.description = paymentMethod.getDescription();
    }

    public static class PaymentMethodBuilder {
        public Optional<PaymentMethod> buildOptional() {
            return Optional.of(this.build());
        }

        public PaymentMethod build() {
            PaymentMethod paymentMethod = this.buildInternal();
            paymentMethod.validate();
            return paymentMethod;
        }
    }
}
