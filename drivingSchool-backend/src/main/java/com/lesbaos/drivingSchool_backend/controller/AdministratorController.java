package com.lesbaos.drivingSchool_backend.controller;

import com.lesbaos.drivingSchool_backend.data.Administrator;
import com.lesbaos.drivingSchool_backend.dto.AdministratorRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.AdministratorResponseDTO;
import com.lesbaos.drivingSchool_backend.service.AdministratorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AdministratorController {
    private final AdministratorService administratorService;
    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @PostMapping("/createAdministrator")
    public ResponseEntity<AdministratorResponseDTO> createAdministrator(@RequestBody AdministratorRequestDTO administratorRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(administratorService.createAdministrator(administratorRequestDTO));
    }

    @PutMapping("/updateAdministrator/{id}")
    public ResponseEntity<AdministratorResponseDTO> updateAdministrator(@PathVariable Long id, @RequestBody AdministratorRequestDTO administratorRequestDTO) {
        return ResponseEntity.ok(administratorService.updateAdministrator(id, administratorRequestDTO));
    }

    @GetMapping("/findAdministratorById/{id}")
    public ResponseEntity<AdministratorResponseDTO> findAdministratorById(@PathVariable Long id) {
        return ResponseEntity.ok(administratorService.getAdministratorById(id));
    }

    @GetMapping("/findAllAdministrators")
    public ResponseEntity<List<AdministratorResponseDTO>> findAllAdministrators() {
        return ResponseEntity.ok(administratorService.getAllAdministrators());
    }

    @DeleteMapping("/deleteAdministrator/{id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
        administratorService.deleteAdministrator(id);
        return ResponseEntity.noContent().build();
    }
}
