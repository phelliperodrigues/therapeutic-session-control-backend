package dev.phellipe.psicanalise.application.rest.requests.customer;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressRequest {
    private String street;
    private String number;
    private String zipCode;
    private String city;
    private String district;
    private String state;
    private String complement;
}
