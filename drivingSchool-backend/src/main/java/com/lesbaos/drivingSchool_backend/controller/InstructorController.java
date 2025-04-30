package com.lesbaos.drivingSchool_backend.controller;

import com.lesbaos.drivingSchool_backend.data.Instructor;
import com.lesbaos.drivingSchool_backend.dto.CourseResponseDTO;
import com.lesbaos.drivingSchool_backend.dto.InstructorRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.InstructorResponseDTO;
import com.lesbaos.drivingSchool_backend.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/createInstructor")
    public ResponseEntity<InstructorResponseDTO> createInstructor(@RequestBody InstructorRequestDTO InstructorRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(instructorService.createInstructor(InstructorRequestDTO));
    }

    @GetMapping("/findInstructorById/{id}")
    public ResponseEntity<InstructorResponseDTO> findInstructorById(@PathVariable Long id) {
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }

    @PutMapping("/updateInstructor/{id}")
    public ResponseEntity<InstructorResponseDTO> updateInstructor(@PathVariable Long id, @RequestBody InstructorRequestDTO InstructorRequestDTO) {
        return ResponseEntity.ok(instructorService.updateInstructor(id, InstructorRequestDTO));
    }

    @DeleteMapping("/deleteInstructor/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findAllInstructors")
    public ResponseEntity<List<InstructorResponseDTO>> findAllInstructors() {
        return ResponseEntity.ok(instructorService.findAllInstructors());
    }
}
