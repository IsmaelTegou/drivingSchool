package com.lesbaos.drivingSchool_backend.controller;

import com.lesbaos.drivingSchool_backend.dto.CandidateRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.CandidateResponseDTO;
import com.lesbaos.drivingSchool_backend.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/createCandidate")
    public ResponseEntity<CandidateResponseDTO> createCandidate(@RequestBody CandidateRequestDTO candidateRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.createCandidate(candidateRequestDTO));
    }

    @PutMapping("/updateCandidate/{id}")
    public ResponseEntity<CandidateResponseDTO> updateCandidate(@PathVariable Long id, @RequestBody CandidateRequestDTO candidateRequestDTO) {
        return ResponseEntity.ok(candidateService.updateCandidate(id, candidateRequestDTO));
    }

    @DeleteMapping("/deleteCandidate/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findCandidateById/{id}")
    public ResponseEntity<CandidateResponseDTO> findCandidateById(@PathVariable Long id) {
        return ResponseEntity.ok(candidateService.getCandidateById(id));
    }

    @GetMapping("/findAllCandidate")
    public ResponseEntity<List<CandidateResponseDTO>> findAllCandidate() {
        return ResponseEntity.ok(candidateService.getAllCandidate());
    }
}
