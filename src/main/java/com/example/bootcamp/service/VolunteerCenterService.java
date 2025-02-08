package com.example.bootcamp.service;

import com.example.bootcamp.dto.VolunteerCenterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VolunteerCenterService {
    List<VolunteerCenterDTO> getAllVolunteerCenter();

    VolunteerCenterDTO getVolunteerCenterById(Long id);

    VolunteerCenterDTO getVolunteerCenterByName(String name);

    VolunteerCenterDTO updateVolunteerCenter(Long id, VolunteerCenterDTO dto);

    VolunteerCenterDTO createVolunteerCenter(VolunteerCenterDTO volunteerCentre);

    Page<VolunteerCenterDTO> getVolunteerCenterPaginated(Pageable pageable);

    void deleteVolunteerCenter(Long id);
}
