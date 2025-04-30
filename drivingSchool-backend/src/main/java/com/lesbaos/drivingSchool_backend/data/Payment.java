package com.lesbaos.drivingSchool_backend.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment implements Serializable {

//******************************************* ATTRIBUTS ************************************************************

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String paymentMethod;

    @ManyToOne
    private Administrator administrator;
}
