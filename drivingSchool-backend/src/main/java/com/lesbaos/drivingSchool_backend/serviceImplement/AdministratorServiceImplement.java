package com.lesbaos.drivingSchool_backend.serviceImplement;

import com.lesbaos.drivingSchool_backend.dao.AdministratorRepository;
import com.lesbaos.drivingSchool_backend.data.Administrator;
import com.lesbaos.drivingSchool_backend.dto.AdministratorRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.AdministratorResponseDTO;
import com.lesbaos.drivingSchool_backend.service.AdministratorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class AdministratorServiceImplement implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    public AdministratorServiceImplement(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }


    @Override
    public AdministratorResponseDTO createAdministrator(AdministratorRequestDTO administratorRequestDTO) {
        Administrator administrator = Administrator.builder()
                .firstName(administratorRequestDTO.getFirstName())
                .lastName(administratorRequestDTO.getLastName())
                .email(administratorRequestDTO.getEmail())
                .password(administratorRequestDTO.getPassword())
                .phone(administratorRequestDTO.getPhone())
                .build();
        administratorRepository.save(administrator);
        return mapToAdministratorResponseDTO(administrator);
    }

    @Override
    public AdministratorResponseDTO updateAdministrator(Long id, AdministratorRequestDTO administratorRequestDTO) {
        Administrator administrator = findAdministratorById(id);
        administrator.setFirstName(administratorRequestDTO.getFirstName());
        administrator.setLastName(administratorRequestDTO.getLastName());
        administrator.setEmail(administratorRequestDTO.getEmail());
        administrator.setPassword(administratorRequestDTO.getPassword());
        administrator.setPhone(administratorRequestDTO.getPhone());
        administratorRepository.save(administrator);
        return mapToAdministratorResponseDTO(administrator);
    }

    @Override
    public AdministratorResponseDTO getAdministratorById(Long id) {
        Administrator administrator = administratorRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Administrator with id %s not found", id))
        );
        return mapToAdministratorResponseDTO(administrator);
    }

    @Override
    public Administrator findAdministratorById(Long id) {
        return administratorRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Administrator with id %s not found", id))
        );
    }

    @Override
    public List<AdministratorResponseDTO> getAllAdministrators() {
        return administratorRepository.findAll().stream().map(this::mapToAdministratorResponseDTO).toList();
    }

    @Override
    public void deleteAdministrator(Long id) {
        Administrator administrator = findAdministratorById(id);
        administratorRepository.delete(administrator);
    }

    private AdministratorResponseDTO mapToAdministratorResponseDTO(Administrator administrator) {
        return AdministratorResponseDTO.builder()
                .id(administrator.getId())
                .firstName(administrator.getFirstName())
                .lastName(administrator.getLastName())
                .email(administrator.getEmail())
                .phone(administrator.getPhone())
                .password(administrator.getPassword())
                .build();
    }
}
