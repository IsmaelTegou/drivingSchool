package com.lesbaos.drivingSchool_backend.dao;

import com.lesbaos.drivingSchool_backend.data.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support, Long> {
}
