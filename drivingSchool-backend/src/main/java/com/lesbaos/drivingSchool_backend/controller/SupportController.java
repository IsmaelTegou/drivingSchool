package com.lesbaos.drivingSchool_backend.controller;

import com.lesbaos.drivingSchool_backend.data.Support;
import com.lesbaos.drivingSchool_backend.dto.SupportRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.SupportResponseDTO;
import com.lesbaos.drivingSchool_backend.service.SupportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SupportController {

    private final SupportService supportService;

    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    @PostMapping("/createSupport")
    public ResponseEntity<SupportResponseDTO> createSupport(@RequestBody SupportRequestDTO supportRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supportService.createSupport(supportRequestDTO));
    }

    @PutMapping("/updateSupport/{id}")
    public ResponseEntity<SupportResponseDTO> updateSupport(@PathVariable Long id, @RequestBody SupportRequestDTO supportRequestDTO) {
        return ResponseEntity.ok(supportService.updateSupport(id, supportRequestDTO));
    }

    @GetMapping("/findSupportById/{id}")
    public ResponseEntity<SupportResponseDTO> findSupportById(@PathVariable Long id) {
        return ResponseEntity.ok(supportService.getSupportById(id));
    }

    @GetMapping("/findAllSupports")
    public ResponseEntity<List<SupportResponseDTO>> findAllSupports() {
        return ResponseEntity.ok(supportService.findAllSupports());
    }

    @DeleteMapping("/deleteSupport/{id}")
    public ResponseEntity<Void> deleteSupport(@PathVariable Long id) {
        supportService.deleteSupport(id);
        return ResponseEntity.noContent().build();
    }
}
