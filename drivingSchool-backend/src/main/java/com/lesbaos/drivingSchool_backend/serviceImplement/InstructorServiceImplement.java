package com.lesbaos.drivingSchool_backend.serviceImplement;

import com.lesbaos.drivingSchool_backend.dao.InstructorRepository;
import com.lesbaos.drivingSchool_backend.data.Instructor;
import com.lesbaos.drivingSchool_backend.dto.InstructorRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.InstructorResponseDTO;
import com.lesbaos.drivingSchool_backend.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class InstructorServiceImplement implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImplement(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public InstructorResponseDTO createInstructor(InstructorRequestDTO instructorRequestDTO) {
        Instructor instructor = Instructor.builder()
                .phone(instructorRequestDTO.getPhone())
                .email(instructorRequestDTO.getEmail())
                .password(instructorRequestDTO.getPassword())
                .firstName(instructorRequestDTO.getFirstName())
                .lastName(instructorRequestDTO.getLastName())
                .build();
        instructorRepository.save(instructor);
        return mapToInstructorResponseDTO(instructor);
    }

    @Override
    public Instructor findInstructorById(Long id) {
        return instructorRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Instructor with id %s not found", id))
        );
    }

    @Override
    public InstructorResponseDTO getInstructorById(Long id) {
        Instructor instructor = findInstructorById(id);
        return mapToInstructorResponseDTO(instructor);
    }

    @Override
    public InstructorResponseDTO updateInstructor(Long id, InstructorRequestDTO instructorRequestDTO) {
        Instructor instructor = findInstructorById(id);
        instructor.setPhone(instructorRequestDTO.getPhone());
        instructor.setEmail(instructorRequestDTO.getEmail());
        instructor.setPassword(instructorRequestDTO.getPassword());
        instructor.setFirstName(instructorRequestDTO.getFirstName());
        instructor.setLastName(instructorRequestDTO.getLastName());
        instructorRepository.save(instructor);
        return mapToInstructorResponseDTO(instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        Instructor instructor = findInstructorById(id);
        instructorRepository.delete(instructor);
    }

    @Override
    public List<InstructorResponseDTO> findAllInstructors() {
        return instructorRepository.findAll().stream().map(this::mapToInstructorResponseDTO).toList();
    }

    private InstructorResponseDTO mapToInstructorResponseDTO(Instructor instructor) {
        return InstructorResponseDTO.builder()
                .id(instructor.getId())
                .firstName(instructor.getFirstName())
                .lastName(instructor.getLastName())
                .email(instructor.getEmail())
                .phone(instructor.getPhone())
                .password(instructor.getPassword())
                .build();
    }
}
