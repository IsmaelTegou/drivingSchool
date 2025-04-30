package com.lesbaos.drivingSchool_backend.service;

import com.lesbaos.drivingSchool_backend.data.Instructor;
import com.lesbaos.drivingSchool_backend.dto.InstructorResponseDTO;
import com.lesbaos.drivingSchool_backend.dto.InstructorRequestDTO;

import java.util.List;

public interface InstructorService {

    public InstructorResponseDTO createInstructor(InstructorRequestDTO InstructorRequestDTO);
    public Instructor findInstructorById(Long id);
    public InstructorResponseDTO getInstructorById(Long id);
    public InstructorResponseDTO updateInstructor(Long id, InstructorRequestDTO instructorRequestDTO);
    public void deleteInstructor(Long id);
    public List<InstructorResponseDTO> findAllInstructors();

}
