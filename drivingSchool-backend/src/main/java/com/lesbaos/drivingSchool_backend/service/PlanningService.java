package com.lesbaos.drivingSchool_backend.service;

import com.lesbaos.drivingSchool_backend.data.Planning;
import com.lesbaos.drivingSchool_backend.dto.PlanningResponseDTO;
import com.lesbaos.drivingSchool_backend.dto.PlanningRequestDTO;

import java.util.List;

public interface PlanningService {

    public PlanningResponseDTO createPlanning(PlanningRequestDTO planningRequestDTO);
    public PlanningResponseDTO updatePlanning(Long id, PlanningRequestDTO planningRequestDTO);
    public Planning findPlanningById(Long id);
    public PlanningResponseDTO getPlanningById(Long id);
    public List<PlanningResponseDTO> findAllPlannings();
    public void deletePlanning(Long id);
}
