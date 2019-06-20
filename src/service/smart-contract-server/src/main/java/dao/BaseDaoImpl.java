package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;

public class BaseDaoImpl implements Serializable {

    @PersistenceContext
    protected EntityManager em;

    public <T> T save(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T merge(T entity) {
        entity = em.merge(entity);
        return entity;
    }

    @Transactional
    public <T> void persist(T entity) {

        em.persist(entity);

    }

    public <T> void remove(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

}
