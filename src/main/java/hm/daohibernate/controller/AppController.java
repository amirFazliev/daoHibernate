package hm.daohibernate.controller;

import hm.daohibernate.domain.Persons;
import hm.daohibernate.repository.AppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class AppController {
    @Autowired
    private final AppRepository appRepository;

    @PostMapping("/create")
    public void create(@RequestBody Persons persons) {
        appRepository.save(persons);
    }

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) {
        return appRepository.findByCity(city);
    }

    @GetMapping("/by-age")
    public List<Persons> getPersonsByAge(@RequestParam("age") int age) {
        return appRepository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<Persons> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return appRepository.findByNameAndSurname(name, surname);
    }
}
