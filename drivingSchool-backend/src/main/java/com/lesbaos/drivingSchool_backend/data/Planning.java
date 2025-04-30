package com.lesbaos.drivingSchool_backend.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "plannings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Planning implements Serializable {

//******************************************* ATTRIBUTS ************************************************************

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private Administrator administrator;

//    @ManyToMany
//    private List<Instructor> instructors;
//
//    @ManyToMany
//    private List<Candidate> candidates;

    @OneToMany (mappedBy = "planning")
    private List<Course> courses;

}
