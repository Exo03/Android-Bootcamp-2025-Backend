package com.example.bootcamp.service.impl;

import com.example.bootcamp.dto.VolunteerCenterDTO;
import com.example.bootcamp.entity.VolunteerCenter;
import com.example.bootcamp.exception.VolunteerCenterNotFoundException;
import com.example.bootcamp.repository.PersonRepository;
import com.example.bootcamp.repository.VolunteerCenterRepository;
import com.example.bootcamp.service.VolunteerCenterService;
import com.example.bootcamp.util.VolunteerCenterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VolunteerCenterServiceImpl implements VolunteerCenterService {

    private final VolunteerCenterRepository volunteerCenterRepository;
    private final PersonRepository personRepository;

    @Override
    public List<VolunteerCenterDTO> getAllVolunteerCenter() {
        return volunteerCenterRepository.findAll()
                .stream().map(VolunteerCenterMapper::convertToVolCenDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VolunteerCenterDTO getVolunteerCenterById(Long id) {

        return volunteerCenterRepository.findById(id)
                .map(VolunteerCenterMapper::convertToVolCenDTO)
                .orElseThrow(() -> new VolunteerCenterNotFoundException("Volunteer center not found!"));
    }

    @Override
    public VolunteerCenterDTO getVolunteerCenterByName(String name) {
        VolunteerCenter volunteerCenter = volunteerCenterRepository.findByName(name)
                .orElseThrow(() -> new VolunteerCenterNotFoundException("Volunteer center with name: " + name + " not found"));

        return VolunteerCenterMapper.convertToVolCenDTO(volunteerCenter);
    }

    @Override
    public VolunteerCenterDTO updateVolunteerCenter(Long id, VolunteerCenterDTO dto) {
        VolunteerCenter volunteerCenter = volunteerCenterRepository.findById(id)
                .orElseThrow(() -> new VolunteerCenterNotFoundException("Volunteer center not found!"));

        volunteerCenter.setName(dto.getName());
        volunteerCenter.setDescription(dto.getDescription());
        volunteerCenter.setCoordinate_x(dto.getCoordinate_x());
        volunteerCenter.setCoordinate_y(dto.getCoordinate_y());

        return VolunteerCenterMapper.convertToVolCenDTO(volunteerCenterRepository.save(volunteerCenter));
    }

    @Override
    public VolunteerCenterDTO createVolunteerCenter(VolunteerCenterDTO volunteerCenter) {

        VolunteerCenter volunteerCenter1 = new VolunteerCenter();
        volunteerCenter1.setName(volunteerCenter.getName());
        volunteerCenter1.setDescription(volunteerCenter.getDescription());
        volunteerCenter1.setCoordinate_x(volunteerCenter.getCoordinate_x());
        volunteerCenter1.setCoordinate_y(volunteerCenter.getCoordinate_y());

        return VolunteerCenterMapper.convertToVolCenDTO(volunteerCenterRepository.save(volunteerCenter1));
    }

    @Override
    public Page<VolunteerCenterDTO> getVolunteerCenterPaginated(Pageable pageable) {
        return volunteerCenterRepository.findAll(pageable)
                .map(VolunteerCenterMapper::convertToVolCenDTO);
    }

    @Override
    public void deleteVolunteerCenter(Long id) {
        volunteerCenterRepository.deleteById(id);
    }
}
