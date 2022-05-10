package dev.phellipe.psicanalise.infrastructure.database.pg.model.customer;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class ContactModel {
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "contact_phone")
    private String contactPhone;
    @Column(name = "email", nullable = false)
    private String email;

}
