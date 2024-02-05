package org.example.gtgwebmanagement.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.gtgwebmanagement.models.entity.Bowl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BowlDAOImpl implements BowlDAO {

    private final EntityManager entityManager;

    @Autowired
    public BowlDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Bowl bowl) {
        entityManager.persist(bowl);
    }

    @Override
    public Bowl findById(long id) {
        return entityManager.find(Bowl.class, id);
    }

    @Override
    public Bowl[] findAll() {
        Query query = entityManager.createQuery("from Bowl");
        return (Bowl[]) query.getResultList().toArray(Bowl[]::new);
    }

    @Override
    @Transactional
    public void update(Bowl bowl) {
        entityManager.merge(bowl);
    }

    @Override
    @Transactional
    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("delete from Bowl");
        query.executeUpdate();
    }
}
