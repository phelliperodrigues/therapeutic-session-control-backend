package dev.phellipe.psicanalise.application.rest.requests.customer;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactRequest {
    private String phone;
    private String contactPhone;
    private String email;

}
