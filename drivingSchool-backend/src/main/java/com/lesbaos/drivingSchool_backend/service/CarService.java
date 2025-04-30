package com.lesbaos.drivingSchool_backend.service;

import com.lesbaos.drivingSchool_backend.data.Car;
import com.lesbaos.drivingSchool_backend.dto.CarRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.CarResponseDTO;

import java.util.List;

public interface CarService {

    public CarResponseDTO createCar(CarRequestDTO carRequestDTO);
    public CarResponseDTO updateCar(Long id, CarRequestDTO carRequestDTO);
    public void deleteCar(Long id);
    public Car findCarById(Long id);
    public CarResponseDTO getCarById(Long id);
    public List<CarResponseDTO> findAllCars();
}
