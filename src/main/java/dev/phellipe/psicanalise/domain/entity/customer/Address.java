package dev.phellipe.psicanalise.domain.entity.customer;

import dev.phellipe.psicanalise.domain.validation.customer.AddressValidation;
import lombok.*;

import java.util.Optional;

@Data
@Builder(buildMethodName = "buildInternal")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    private String street;
    private String number;
    private String zipCode;
    private String city;
    private String district;
    private String state;
    private String complement;

    private void validate() {
        AddressValidation.build().validate(this);
    }

    public static class AddressBuilder {
        public Optional<Address> buildOptional() {
            return Optional.of(this.build());
        }

        public Address build() {
            Address address = this.buildInternal();
            address.validate();
            return address;
        }
    }


}
