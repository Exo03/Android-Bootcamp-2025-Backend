package com.example.bootcamp.controller;

import com.example.bootcamp.dto.PersonDTO;
import com.example.bootcamp.dto.VolunteerCenterDTO;
import com.example.bootcamp.service.PersonService;
import com.example.bootcamp.service.VolunteerCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/volunteer")
public class VolunteerCenterController {

    public final VolunteerCenterService volunteerCenterService;
    public final PersonService personService;

    @GetMapping
    public List<VolunteerCenterDTO> getAllVolunteerCenter(){
        return volunteerCenterService.getAllVolunteerCenter();
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<VolunteerCenterDTO> getVolunteerCenterById(@PathVariable long id){
        return ResponseEntity.ok(volunteerCenterService.getVolunteerCenterById(id));
    }

    @GetMapping("/one/{volunteerId}")
    public List<PersonDTO> getAllPersonAtVolunteerCenter(@PathVariable long volunteerId){
        return personService.getAllPersonAtCenter(volunteerId);
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<VolunteerCenterDTO>> getAllVolunteerCenterPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(volunteerCenterService.getVolunteerCenterPaginated(pageable));
    }

    @GetMapping("/{name}")
    public ResponseEntity<VolunteerCenterDTO> getVolunteerCenterByName(@PathVariable String name){
        return ResponseEntity.ok(volunteerCenterService.getVolunteerCenterByName(name));
    }

    @PostMapping("/register")
    public ResponseEntity<VolunteerCenterDTO> createVolunteerCenter(@RequestBody VolunteerCenterDTO volunteerCenter) {
        return ResponseEntity.ok(volunteerCenterService.createVolunteerCenter(volunteerCenter));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VolunteerCenterDTO> updateVolunteerCenter(@RequestBody VolunteerCenterDTO dto, @PathVariable long id) {
        return ResponseEntity.ok(volunteerCenterService.updateVolunteerCenter(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVolunteerCenter(@PathVariable long id){
        volunteerCenterService.deleteVolunteerCenter(id);
    }
}
