package com.lesbaos.drivingSchool_backend.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usadministrators")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Administrator implements Serializable {

//******************************************* ATTRIBUTS ************************************************************

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

//    @OneToMany(mappedBy = "administrator", fetch = FetchType.LAZY)
//    private List<Payment> payments;
//
//    @OneToMany (mappedBy = "administrator", fetch = FetchType.LAZY)
//    private List<Car> cars;
//
//    @OneToMany (mappedBy = "administrator", fetch = FetchType.LAZY)
//    private List<Course> courses;
//
//    @OneToMany (mappedBy = "administrator", fetch = FetchType.LAZY)
//    private List<Support> supports;

}
