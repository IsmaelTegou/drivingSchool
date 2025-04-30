package com.lesbaos.drivingSchool_backend.controller;

import com.lesbaos.drivingSchool_backend.data.Planning;
import com.lesbaos.drivingSchool_backend.dto.PaymentResponseDTO;
import com.lesbaos.drivingSchool_backend.dto.PlanningRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.PlanningResponseDTO;
import com.lesbaos.drivingSchool_backend.service.PlanningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PlanningController {

    private final PlanningService planningService;

    public PlanningController(PlanningService planningService) {
        this.planningService = planningService;
    }

    @PostMapping("/createPlanning")
    public ResponseEntity<PlanningResponseDTO> createPlanning(@RequestBody PlanningRequestDTO planningRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planningService.createPlanning(planningRequestDTO));
    }

    @PutMapping("/updatePlanning/{id}")
    public ResponseEntity<PlanningResponseDTO> updatePlanning(@PathVariable Long id, @RequestBody PlanningRequestDTO planningRequestDTO) {
        return ResponseEntity.ok(planningService.updatePlanning(id, planningRequestDTO));
    }

    @GetMapping("/findPlanningById/{id}")
    public ResponseEntity<PlanningResponseDTO> findPlanningById(@PathVariable Long id) {
        return ResponseEntity.ok(planningService.getPlanningById(id));
    }

    @GetMapping("/findAllPlannings")
    public ResponseEntity<List<PlanningResponseDTO>> findAllPlannings() {
        return ResponseEntity.ok(planningService.findAllPlannings());
    }

    @DeleteMapping("/deletePlanning/{id}")
    public ResponseEntity<Void> deletePlanning(@PathVariable Long id) {
        planningService.deletePlanning(id);
        return ResponseEntity.noContent().build();
    }
}


