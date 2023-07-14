package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Raum;

@ApplicationScoped
public class RaumService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Raum createRaum(Raum raum) {
        return entityManager.merge(raum);
    }

    @Transactional
    public void deleteRaum(int raumId) {
        var entity = entityManager.find(Raum.class, raumId);
        entityManager.remove(entity);
    }

    @Transactional
    public Raum updateRaum(int raumId, Raum raum) {
        raum.setRaumId(raumId);
        return entityManager.merge(raum);
    }

    public List<Raum> findAll() {
        var query = entityManager.createQuery("FROM Raum", Raum.class);
        return query.getResultList();
    }
}
