package com.lesbaos.drivingSchool_backend.serviceImplement;

import com.lesbaos.drivingSchool_backend.dao.PlanningRepository;
import com.lesbaos.drivingSchool_backend.data.Course;
import com.lesbaos.drivingSchool_backend.data.Planning;
import com.lesbaos.drivingSchool_backend.dto.PlanningRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.PlanningResponseDTO;
import com.lesbaos.drivingSchool_backend.service.AdministratorService;
import com.lesbaos.drivingSchool_backend.service.PlanningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class PlanningServiceImplement implements PlanningService {

    private final PlanningRepository planningRepository;
    private final AdministratorService administratorService;

    public PlanningServiceImplement(PlanningRepository planningRepository, AdministratorService administratorService) {
        this.planningRepository = planningRepository;
        this.administratorService = administratorService;
    }

    @Override
    public PlanningResponseDTO createPlanning(PlanningRequestDTO planningRequestDTO) {
        Planning planning = Planning.builder()
                .title(planningRequestDTO.getTitle())
                .administrator(administratorService.findAdministratorById(planningRequestDTO.getAdministratorId()))
                .courses(new ArrayList<Course>())
                .build();
        planningRepository.save(planning);
        return mapToPlanningResponseDTO(planning);
    }

    @Override
    public PlanningResponseDTO updatePlanning(Long id, PlanningRequestDTO planningRequestDTO) {
        Planning planning = findPlanningById(id);
        planning.setTitle(planningRequestDTO.getTitle());
        planning.setAdministrator(administratorService.findAdministratorById(planningRequestDTO.getAdministratorId()));
        planningRepository.save(planning);
        return mapToPlanningResponseDTO(planning);
    }

    @Override
    public Planning findPlanningById(Long id) {
        return planningRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Planning with id %d not found", id))
        );
    }

    @Override
    public PlanningResponseDTO getPlanningById(Long id) {
        return mapToPlanningResponseDTO(findPlanningById(id));
    }

    @Override
    public List<PlanningResponseDTO> findAllPlannings() {
        return planningRepository.findAll().stream().map(this::mapToPlanningResponseDTO).toList();
    }

    @Override
    public void deletePlanning(Long id) {
        Planning planning = findPlanningById(id);
        planningRepository.delete(planning);
    }

    private PlanningResponseDTO mapToPlanningResponseDTO(Planning planning) {
        return PlanningResponseDTO.builder()
                .id(planning.getId())
                .title(planning.getTitle())
                .lastnameAdmin(planning.getAdministrator().getLastName())
                .coursesNames(planning.getCourses().stream().map(Course::getName).toList())
                .build();
    }
}
