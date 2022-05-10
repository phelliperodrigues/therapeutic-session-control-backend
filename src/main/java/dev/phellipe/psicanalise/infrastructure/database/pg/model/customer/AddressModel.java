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
public class AddressModel {

    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "zip_code", nullable = false)
    private String zipCode;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "district", nullable = false)
    private String district;
    @Column(name = "state", nullable = false)
    private String state;
    @Column(name = "complement")
    private String complement;


}
