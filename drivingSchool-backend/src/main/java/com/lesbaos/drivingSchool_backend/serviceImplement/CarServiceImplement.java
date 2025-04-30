package com.lesbaos.drivingSchool_backend.serviceImplement;

import com.lesbaos.drivingSchool_backend.dao.CarRepository;
import com.lesbaos.drivingSchool_backend.data.Car;
import com.lesbaos.drivingSchool_backend.dto.CarRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.CarResponseDTO;
import com.lesbaos.drivingSchool_backend.service.AdministratorService;
import com.lesbaos.drivingSchool_backend.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImplement implements CarService {

    private final CarRepository carRepository;
    private final AdministratorService administratorService;

    public CarServiceImplement(CarRepository carRepository, AdministratorService administratorService) {
        this.carRepository = carRepository;
        this.administratorService = administratorService;
    }

    @Override
    public CarResponseDTO createCar(CarRequestDTO carRequestDTO) {
        Car car = Car.builder()
                .brand(carRequestDTO.getBrand())
                .model(carRequestDTO.getModel())
                .color(carRequestDTO.getColor())
                .isOut(carRequestDTO.getIsOut())
                .administrator(administratorService.findAdministratorById(carRequestDTO.getAdminId()))
                .build();
        carRepository.save(car);
        return mapToCarResponseDTO(car);
    }

    @Override
    public CarResponseDTO updateCar(Long id, CarRequestDTO carRequestDTO) {
        Car car = findCarById(id);
        car.setBrand(carRequestDTO.getBrand());
        car.setModel(carRequestDTO.getModel());
        car.setColor(carRequestDTO.getColor());
        car.setIsOut(carRequestDTO.getIsOut());
        car.setRegistration(carRequestDTO.getRegistration());
        car.setAdministrator(administratorService.findAdministratorById(carRequestDTO.getAdminId()));
        carRepository.save(car);
        return mapToCarResponseDTO(car);
    }

    @Override
    public void deleteCar(Long id) {
        Car car = findCarById(id);
        carRepository.delete(car);
    }

    @Override
    public CarResponseDTO getCarById(Long id) {
        Car car = findCarById(id);
        return mapToCarResponseDTO(car);
    }

    @Override
    public Car findCarById(Long id) {
        return carRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Car with ID %s not found", id))
         );
    }

    @Override
    public List<CarResponseDTO> findAllCars() {
        return carRepository.findAll().stream().map(this::mapToCarResponseDTO).collect(Collectors.toList());
    }

    private CarResponseDTO mapToCarResponseDTO(Car car) {
        return CarResponseDTO.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .color(car.getColor())
                .registration(car.getRegistration())
                .isOut(car.getIsOut())
                .build();
    }
}
