package com.example.bootcamp.util;

import com.example.bootcamp.dto.VolunteerCenterDTO;
import com.example.bootcamp.entity.VolunteerCenter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VolunteerCenterMapper {
    public VolunteerCenterDTO convertToVolCenDTO(VolunteerCenter volunteerCenter){

        VolunteerCenterDTO volunteerCenterDTO = new VolunteerCenterDTO();
        volunteerCenterDTO.setName(volunteerCenter.getName());
        volunteerCenterDTO.setDescription(volunteerCenter.getDescription());
        volunteerCenterDTO.setCoordinate_x(volunteerCenter.getCoordinate_x());
        volunteerCenterDTO.setCoordinate_y(volunteerCenter.getCoordinate_y());

        return volunteerCenterDTO;

    }


}
