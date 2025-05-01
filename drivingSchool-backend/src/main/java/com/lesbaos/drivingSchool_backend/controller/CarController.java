package com.lesbaos.drivingSchool_backend.controller;

import com.lesbaos.drivingSchool_backend.dto.CarRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.CarResponseDTO;
import com.lesbaos.drivingSchool_backend.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/createCar")
    public ResponseEntity<CarResponseDTO> createCar(@RequestBody CarRequestDTO carRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.createCar(carRequestDTO));
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<CarResponseDTO> updateCar(@PathVariable Long id, @RequestBody CarRequestDTO carRequestDTO) {
        return ResponseEntity.ok(carService.updateCar(id, carRequestDTO));
    }

    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findCarById/{id}")
    public ResponseEntity<CarResponseDTO> findCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping("/findAllCars")
    public ResponseEntity<List<CarResponseDTO>> findAllCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }
}
