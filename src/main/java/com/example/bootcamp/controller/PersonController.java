package com.example.bootcamp.controller;

import com.example.bootcamp.dto.PersonDTO;
import com.example.bootcamp.dto.PersonGetDTO;
import com.example.bootcamp.dto.PersonRegisterDTO;
import com.example.bootcamp.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class PersonController {
    private final PersonService personService;

//    @GetMapping
//    public List<PersonDTO> getAllPerson() {
//        return personService.getAllPerson();
//    }

    @GetMapping
    public List<PersonGetDTO> getAllPerson() {
        return personService.getAllPersonsName();
    }

    @GetMapping("/info/{username}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable String username) {
        return ResponseEntity.ok(personService.getPersonByUsername(username));
    }

    @PostMapping("/register")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonRegisterDTO personRegisterDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personRegisterDTO));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<String> getByUsername(@PathVariable String username) {
        PersonDTO personDTO = personService.getPersonByUsername(username);
        return ResponseEntity.ok("User " + personDTO.getUsername() + " is registered");
    }

    @GetMapping("/login")
    public ResponseEntity<PersonDTO> login(Authentication authentication){
        return ResponseEntity.ok(personService.getPersonByUsername(authentication.getName()));
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable String username, @RequestBody PersonRegisterDTO personDTO) {
        return ResponseEntity.ok(personService.updatePerson(username, personDTO));
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Void> deletePerson(@PathVariable String username){
        personService.deletePerson(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<PersonDTO>> getAllPersonPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(personService.getAllPersonPaginated(pageable));
    }

    @PutMapping("volunteer/add/{username}/{name}")
    public ResponseEntity<PersonDTO> registerAtVolunteerCentre(@PathVariable String username, @PathVariable String name){
        return ResponseEntity.ok(personService.registerAtVolunteerCenter(username, name));
    }
}
