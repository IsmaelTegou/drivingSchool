package com.lesbaos.drivingSchool_backend.data;

import com.lesbaos.drivingSchool_backend.enumerations.TypeSupport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "supports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Support {

//******************************************* ATTRIBUTS ************************************************************

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private TypeSupport typeSupport;

    @ManyToOne
    private Administrator administrator;

//    @ManyToMany
//    private List<Instructor> instructors;
//
//    @ManyToMany
//    private List<Candidate> candidates;

}
