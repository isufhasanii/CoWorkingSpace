package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.model.Buchungsanfrage;

@ApplicationScoped
public class BuchungsanfragenService {
    @Inject
    EntityManager entityManager;

    public Buchungsanfrage updateStatus(int buchungsanfrageId, String status, Buchungsanfrage buchungsanfrage) {
        buchungsanfrage.setStatus(status);
        return entityManager.merge(buchungsanfrage);
    }
}
