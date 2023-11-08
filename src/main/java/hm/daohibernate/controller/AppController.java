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


@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class AppController {

    @Autowired
    private AppRepository appRepository;

//    @GetMapping("/create")
//    public void create(
//            @RequestParam("name") String name,
//            @RequestParam("surname") String surname,
//            @RequestParam("age") int age,
//            @RequestParam("phoneNumber") String phoneNumber,
//            @RequestParam("city") String city) {
//        Persons persons = new Persons(name, surname, age, phoneNumber, city);
//        appRepository.create(persons);
//    }

    @PostMapping("/create")
    public void create(@RequestBody Persons persons) {
        appRepository.create(persons);
    }

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) throws SQLException {
        return appRepository.getPersonsByCity(city);
    }
}
