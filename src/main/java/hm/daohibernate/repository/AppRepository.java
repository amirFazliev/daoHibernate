package hm.daohibernate.repository;

import hm.daohibernate.domain.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppRepository extends JpaRepository<Persons, Long> {
    List <Persons> findByCity(String city);

    List<Persons> findByAgeLessThanOrderByAge(int age);

    Optional<Persons> findByNameAndSurname(String name, String surname);

    List<Persons> findByUsername(String username);
}
