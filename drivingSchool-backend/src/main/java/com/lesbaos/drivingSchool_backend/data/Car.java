package com.lesbaos.drivingSchool_backend.data;

import com.lesbaos.drivingSchool_backend.enumerations.StatutCar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car implements Serializable {

//******************************************* ATTRIBUTS ************************************************************

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String registration;

    @Column(nullable = false)
    private Boolean isOut;

    @ManyToOne
    private Administrator administrator;

//    @ManyToMany
//    private List<Instructor> instructors;

}
