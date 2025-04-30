package com.lesbaos.drivingSchool_backend.serviceImplement;

import com.lesbaos.drivingSchool_backend.dao.CandidateRepository;
import com.lesbaos.drivingSchool_backend.data.Candidate;
import com.lesbaos.drivingSchool_backend.dto.CandidateRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.CandidateResponseDTO;
import com.lesbaos.drivingSchool_backend.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CandidateServiceImplement implements CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateServiceImplement(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public CandidateResponseDTO createCandidate(CandidateRequestDTO candidateRequestDTO) {
        Candidate candidate = Candidate.builder()
                .firstName(candidateRequestDTO.getFirstName())
                .lastName(candidateRequestDTO.getLastName())
                .email(candidateRequestDTO.getEmail())
                .phone(candidateRequestDTO.getPhone())
                .password(candidateRequestDTO.getPassword())
                .typeCandidate(candidateRequestDTO.getTypeCandidate())
                .build();
        candidateRepository.save(candidate);
        return mapToCandidateResponseDTO(candidate);
    }

    @Override
    public CandidateResponseDTO updateCandidate(Long id, CandidateRequestDTO candidateRequestDTO) {
        Candidate candidate = findCandidateById(id);
        candidate.setFirstName(candidateRequestDTO.getFirstName());
        candidate.setLastName(candidateRequestDTO.getLastName());
        candidate.setEmail(candidateRequestDTO.getEmail());
        candidate.setPhone(candidateRequestDTO.getPhone());
        candidate.setPassword(candidateRequestDTO.getPassword());
        candidate.setTypeCandidate(candidateRequestDTO.getTypeCandidate());
        candidateRepository.save(candidate);
        return mapToCandidateResponseDTO(candidate);
    }

    @Override
    public void deleteCandidate(Long id) {
        Candidate candidate = findCandidateById(id);
        candidateRepository.delete(candidate);
    }

    @Override
    public CandidateResponseDTO getCandidateById(Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Candidate with id %s not found", id))
        );
        return mapToCandidateResponseDTO(candidate);
    }

    @Override
    public Candidate findCandidateById(Long id){
        return candidateRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Candidate with id %s not found", id))
        );
    }

    @Override
    public List<CandidateResponseDTO> getAllCandidate() {
        return candidateRepository.findAll().stream().map(this::mapToCandidateResponseDTO).collect(Collectors.toList());
    }

    private CandidateResponseDTO mapToCandidateResponseDTO(Candidate candidate) {
        return CandidateResponseDTO.builder()
                .id(candidate.getId())
                .firstName(candidate.getFirstName())
                .lastName(candidate.getLastName())
                .email(candidate.getEmail())
                .phone(candidate.getPhone())
                .password(candidate.getPassword())
                .typeCandidate(candidate.getTypeCandidate())
                .build();
    }
}
