package dev.phellipe.psicanalise.infrastructure.database.pg.model.attendance;

import dev.phellipe.psicanalise.infrastructure.database.pg.model.customer.CustomerModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "sessions")
public class SessionModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(targetEntity = CustomerModel.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerModel customer;

    @Column(name = "schedule", nullable = false)
    private LocalDateTime schedule;

    @Column(name = "value", nullable = false)
    private double value;

    @Column(name = "observation")
    private String observation;


}
