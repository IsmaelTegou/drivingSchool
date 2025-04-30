package com.lesbaos.drivingSchool_backend.dao;

import com.lesbaos.drivingSchool_backend.data.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
