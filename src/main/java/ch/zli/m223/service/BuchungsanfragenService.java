package ch.zli.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Buchungsanfrage;
import ch.zli.m223.model.Mitglied;

@ApplicationScoped
public class BuchungsanfragenService {
    @Inject
    EntityManager entityManager;

    public Buchungsanfrage updateStatus(int buchungsanfrageId, String status, Buchungsanfrage buchungsanfrage) {
        buchungsanfrage.setStatus(status);
        return entityManager.merge(buchungsanfrage);
    }
}
