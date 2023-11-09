package hm.daohibernate.controller;

import hm.daohibernate.domain.Persons;
import hm.daohibernate.repository.AppRepository;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/persons")
public class AppController {

    private final AppRepository appRepository;
    private final Flyway flyway;

    @Autowired
    public AppController(AppRepository appRepository, Flyway flyway) {
        this.appRepository = appRepository;
        this.flyway = flyway;
    }

    @PostMapping("/create")
    public void create(@RequestBody Persons persons) {
        appRepository.create(persons);
    }

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) throws SQLException {
        return appRepository.getPersonsByCity(city);
    }

    @PostMapping("/migrate")
    public void migrate() {
        flyway.migrate();
    }
}
