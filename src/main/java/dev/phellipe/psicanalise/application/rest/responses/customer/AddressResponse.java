package dev.phellipe.psicanalise.application.rest.responses.customer;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressResponse {
    private String street;
    private String number;
    private String zipCode;
    private String city;
    private String district;
    private String state;
    private String complement;
}
