package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Admin;
import ch.zli.m223.model.Mitglied;

@ApplicationScoped
public class AdminService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Admin createAdmin(Admin admin) {
        return entityManager.merge(admin);
    }

    @Transactional
    public void deleteAdmin(int adminId) {
        var entity = entityManager.find(Mitglied.class, adminId);
        entityManager.remove(entity);
    }

    @Transactional
    public Admin updateAdmin(int adminId, Admin admin) {
        admin.setAdminId(adminId);
        return entityManager.merge(admin);
    }

    public List<Admin> findAll() {
        var query = entityManager.createQuery("FROM Admin", Admin.class);
        return query.getResultList();
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

    public List<Mitglied> findAllMitglieder() {
        var query = entityManager.createQuery("FROM Mitglied", Mitglied.class);
        return query.getResultList();
    }
}

