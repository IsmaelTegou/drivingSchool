package com.lesbaos.drivingSchool_backend.data;

import com.lesbaos.drivingSchool_backend.enumerations.TypeCourse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course implements Serializable {

//******************************************* ATTRIBUTS ************************************************************

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private TypeCourse typeCourse;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne
    private Administrator administrator;

    @ManyToOne
    private Planning planning;

//******************************************* CONSTRUCTORS ************************************************************


}
