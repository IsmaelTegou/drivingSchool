package com.lesbaos.drivingSchool_backend.dao;

import com.lesbaos.drivingSchool_backend.data.Planning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningRepository extends JpaRepository<Planning, Long> {

}
