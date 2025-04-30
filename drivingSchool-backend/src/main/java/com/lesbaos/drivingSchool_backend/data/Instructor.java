package com.lesbaos.drivingSchool_backend.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "instructors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor implements Serializable {

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

//    @ManyToMany (mappedBy = "instructors")
//    private List<Car> cars;

//    @ManyToMany (mappedBy = "instructors")
//    private List<Planning> plannings;

//    @ManyToMany (mappedBy = "instructors")
//    private List<Course> courses;

//    @ManyToMany (mappedBy = "instructors")
//    private List<Support> supports;

}
