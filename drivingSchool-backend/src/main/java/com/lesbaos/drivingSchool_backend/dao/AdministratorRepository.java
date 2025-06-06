package com.lesbaos.drivingSchool_backend.dao;

import com.lesbaos.drivingSchool_backend.data.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
