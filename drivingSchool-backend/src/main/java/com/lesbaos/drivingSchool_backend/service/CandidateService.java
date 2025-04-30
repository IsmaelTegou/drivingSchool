package com.lesbaos.drivingSchool_backend.service;

import com.lesbaos.drivingSchool_backend.data.Candidate;
import com.lesbaos.drivingSchool_backend.dto.CandidateRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.CandidateResponseDTO;

import java.util.List;

public interface CandidateService {

    public CandidateResponseDTO createCandidate(CandidateRequestDTO candidateRequestDTO);
    public CandidateResponseDTO updateCandidate(Long id, CandidateRequestDTO candidateRequestDTO);
    public Candidate findCandidateById(Long id);
    public CandidateResponseDTO getCandidateById(Long id);
    public List<CandidateResponseDTO> getAllCandidate();
    public void deleteCandidate(Long id);
}
