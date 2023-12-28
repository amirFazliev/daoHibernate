package hm.daohibernate.repository;

import hm.daohibernate.domain.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppRepository extends JpaRepository<Persons, Long> {
    @Query("SELECT p FROM Persons p WHERE p.city = :city")
    List findByCity(@Param("city") String city);

    @Query("SELECT p FROM Persons p WHERE p.age < :age ORDER BY p.age")
    List<Persons> findByAgeLessThanOrderByAge(@Param("age") int age);

    @Query("SELECT p FROM Persons p WHERE p.name = :name AND p.surname = :surname")
    Optional<Persons> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}