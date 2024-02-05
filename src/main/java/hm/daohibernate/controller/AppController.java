package hm.daohibernate.controller;

import hm.daohibernate.domain.Persons;
import hm.daohibernate.repository.AppRepository;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class AppController {
    private final AppRepository appRepository;

    @PostMapping("/create")
    @Secured("ROLE_WRITE")
    public void create(@RequestBody Persons persons) {
        appRepository.save(persons);
    }

    @GetMapping("/by-city")
    @Secured("ROLE_READ")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) {
        return appRepository.findByCity(city);
    }

    @GetMapping("/by-age")
    @RolesAllowed("ROLE_READ")
    public List<Persons> getPersonsByAge(@RequestParam("age") int age) {
        return appRepository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/by-name-and-surname")
    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    public Optional<Persons> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return appRepository.findByNameAndSurname(name, surname);
    }

    @GetMapping("/by-username")
    public List<Persons> getPersonsByUsername(@RequestParam("username") String username, Authentication authentication) {
        if (username.equals(authentication.getName())) {
            return appRepository.findByUsername(username);
        }
        return Collections.emptyList();
    }
}
