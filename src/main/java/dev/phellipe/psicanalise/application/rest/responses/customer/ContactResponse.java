package dev.phellipe.psicanalise.application.rest.responses.customer;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactResponse {
    private String phone;
    private String contactPhone;
    private String email;

}
