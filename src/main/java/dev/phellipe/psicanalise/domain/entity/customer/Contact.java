package dev.phellipe.psicanalise.domain.entity.customer;

import dev.phellipe.psicanalise.domain.validation.customer.ContactValidation;
import lombok.*;

import java.util.Optional;

@Data
@Builder(buildMethodName = "buildInternal")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {
    private String phone;
    private String ContactPhone;
    private String email;

    private void validate() {
        ContactValidation.build().validate(this);
    }

    public static class ContactBuilder {
        public Optional<Contact> buildOptional() {
            return Optional.of(this.build());
        }

        public Contact build() {
            Contact contact = this.buildInternal();
            contact.validate();
            return contact;
        }
    }
}
