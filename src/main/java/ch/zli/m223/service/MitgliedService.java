package ch.zli.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Mitglied;

@ApplicationScoped
public class MitgliedService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Mitglied createMitglied(Mitglied mitglied) {
        return entityManager.merge(mitglied);
    }

    @Transactional
    public void deleteMitglied(Long mitgliedId) {
        var entity = entityManager.find(Mitglied.class, mitgliedId);
        entityManager.remove(entity);
    }

    @Transactional
    public Mitglied updateMitglied(int mitgliedId, Mitglied mitglied) {
        mitglied.setMitgliedId(mitgliedId);
        return entityManager.merge(mitglied);
    }

    public List<Mitglied> findAll() {
        var query = entityManager.createQuery("FROM Mitglied", Mitglied.class);
        return query.getResultList();
    }
}
