package com.lesbaos.drivingSchool_backend.data;

import com.lesbaos.drivingSchool_backend.enumerations.TypeCandidate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "candidates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate implements Serializable {

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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeCandidate typeCandidate;

//    @ManyToMany (mappedBy = "candidates")
//    private List<Support> supports;
//
//    @ManyToMany (mappedBy = "candidates")
//    private List<Planning> plannings;
//
//    @ManyToMany (mappedBy = "candidates")
//    private List<Course> courses;

}
