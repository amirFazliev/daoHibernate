package hm.daohibernate.repository;

import hm.daohibernate.domain.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create (Persons persons) {

        entityManager.persist(persons);
    }
    @Transactional
    public List<Persons> getPersonsByCity(String city) {
        var query = entityManager.createQuery("select persons from Persons persons where persons.city=:city", Persons.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}
