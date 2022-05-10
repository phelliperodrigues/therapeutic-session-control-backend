package dev.phellipe.psicanalise.infrastructure.database.pg.model.customer;

import dev.phellipe.psicanalise.infrastructure.database.pg.model.managerial.PaymentMethodModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customers")
public class CustomerModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "document_number", nullable = false, unique = true)
    private String documentNumber;

    @Column(name = "rg", nullable = false, unique = true)
    private String rg;

    @Embedded
    private AddressModel address;

    @Embedded
    private ContactModel contact;

    @ManyToMany(targetEntity = PaymentMethodModel.class)
    @JoinTable(
            name = "customers_payment_methods",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_method_id")
    )
    @ToString.Exclude
    private Set<PaymentMethodModel> paymentMethods = new HashSet<>();

}
