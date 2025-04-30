package com.lesbaos.drivingSchool_backend.service;

import com.lesbaos.drivingSchool_backend.data.Administrator;
import com.lesbaos.drivingSchool_backend.dto.AdministratorRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.AdministratorResponseDTO;

import java.util.List;

public interface AdministratorService {

    public AdministratorResponseDTO createAdministrator(AdministratorRequestDTO administratorRequestDTO);
    public AdministratorResponseDTO updateAdministrator(Long id, AdministratorRequestDTO administratorRequestDTO);
    public AdministratorResponseDTO getAdministratorById(Long id);
    public Administrator findAdministratorById(Long id);
    public List<AdministratorResponseDTO> getAllAdministrators();
    public void deleteAdministrator(Long id);



}
