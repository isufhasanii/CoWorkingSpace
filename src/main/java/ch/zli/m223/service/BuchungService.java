package ch.zli.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Buchung;
import ch.zli.m223.model.Mitglied;

@ApplicationScoped
public class BuchungService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Buchung createBuchung(Buchung buchung) {
        return entityManager.merge(buchung);
    }

    @Transactional
    public void deleteBuchung(int buchungId) {
        var entity = entityManager.find(Buchung.class, buchungId);
        entityManager.remove(entity);
    }

    @Transactional
    public Buchung updateBuchung(int buchungId, Buchung buchung) {
        buchung.setBuchungId(buchungId);
        return entityManager.merge(buchung);
    }

    public List<Buchung> findAll() {
        var query = entityManager.createQuery("FROM Buchung", Buchung.class);
        return query.getResultList();
    }
}
