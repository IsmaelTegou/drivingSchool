package com.lesbaos.drivingSchool_backend.serviceImplement;

import com.lesbaos.drivingSchool_backend.dao.SupportRepository;
import com.lesbaos.drivingSchool_backend.data.Support;
import com.lesbaos.drivingSchool_backend.dto.SupportRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.SupportResponseDTO;
import com.lesbaos.drivingSchool_backend.service.AdministratorService;
import com.lesbaos.drivingSchool_backend.service.SupportService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class SupportImplement implements SupportService {

    private final SupportRepository supportRepository;
    private final AdministratorService administratorService;

    public SupportImplement(SupportRepository supportRepository, AdministratorService administratorService) {
        this.supportRepository = supportRepository;
        this.administratorService = administratorService;
    }

    @Override
    public SupportResponseDTO createSupport(SupportRequestDTO supportRequestDTO) {
        Support support = Support.builder()
                .name(supportRequestDTO.getName())
                .typeSupport(supportRequestDTO.getTypeSupport())
                .administrator(administratorService.findAdministratorById(supportRequestDTO.getAdministratorId()))
                .build();
        supportRepository.save(support);
        return mapToSupportResponseDTO(support);
    }

    @Override
    public SupportResponseDTO updateSupport(Long id, SupportRequestDTO supportRequestDTO) {
        Support support = findSupportById(id);
        support.setName(supportRequestDTO.getName());
        support.setTypeSupport(supportRequestDTO.getTypeSupport());
        support.setAdministrator(administratorService.findAdministratorById(supportRequestDTO.getAdministratorId()));
        supportRepository.save(support);
        return mapToSupportResponseDTO(support);
    }

    @Override
    public Support findSupportById(Long id) {
        return supportRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The support with id %s not found", id))
        );
    }

    @Override
    public SupportResponseDTO getSupportById(Long id) {
        return mapToSupportResponseDTO(findSupportById(id));
    }

    @Override
    public List<SupportResponseDTO> findAllSupports() {
        return supportRepository.findAll().stream().map(this::mapToSupportResponseDTO).toList();
    }

    @Override
    public void deleteSupport(Long id) {
        Support support = findSupportById(id);
        supportRepository.delete(support);
    }

    private SupportResponseDTO mapToSupportResponseDTO(Support support) {
        return SupportResponseDTO.builder()
                .id(support.getId())
                .name(support.getName())
                .typeSupport(support.getTypeSupport())
                .lastnameAdmin(support.getAdministrator().getLastName())
                .build();
    }
}
