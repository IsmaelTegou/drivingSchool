package com.lesbaos.drivingSchool_backend.service;

import com.lesbaos.drivingSchool_backend.data.Support;
import com.lesbaos.drivingSchool_backend.dto.SupportRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.SupportResponseDTO;

import java.util.List;

public interface SupportService {

    public SupportResponseDTO createSupport(SupportRequestDTO supportRequestDTO);
    public SupportResponseDTO updateSupport(Long id, SupportRequestDTO supportRequestDTO);
    public Support findSupportById(Long id);
    public SupportResponseDTO getSupportById(Long id);
    public List<SupportResponseDTO> findAllSupports();
    public void deleteSupport(Long id);
}
