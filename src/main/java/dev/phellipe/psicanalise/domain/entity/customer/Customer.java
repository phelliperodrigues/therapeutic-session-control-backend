package dev.phellipe.psicanalise.domain.entity.customer;

import dev.phellipe.psicanalise.domain.validation.customer.CustomerValidation;
import dev.phellipe.psicanalise.domain.entity.managerial.PaymentMethod;
import lombok.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Data
@Builder(buildMethodName = "buildInternal")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    private UUID id;
    private String name;
    private String documentNumber;
    private String rg;
    private Address address;
    private Contact contact;
    private Set<PaymentMethod> paymentMethods = new HashSet<>();

    private void validate() {
        CustomerValidation.build().validate(this);
    }

    public void update(Customer customer) {
        this.name = customer.getName();
        this.documentNumber = customer.getDocumentNumber();
        this.rg = customer.getRg();
        this.address = customer.getAddress();
        this.contact = customer.getContact();
        this.paymentMethods = customer.getPaymentMethods();
    }

    public static class CustomerBuilder {
        public Optional<Customer> buildOptional() {
            return Optional.of(this.build());
        }

        public Customer build() {
            Customer customer = this.buildInternal();
            customer.validate();
            return customer;
        }
    }
}
