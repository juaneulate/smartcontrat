package dao;

import entity.PersonEntity;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Named
public class PersonDao extends BaseDaoImpl {

    public List<PersonEntity> getPersonList() {
        String hql = "SELECT ue " +
                " FROM PersonEntity ue ";
        TypedQuery<PersonEntity> query = em.createQuery(hql, PersonEntity.class);
        return query.getResultList();
    }

    public List<PersonEntity> getOwnerList() {
        String hql = "SELECT ue " +
                " FROM PersonEntity ue" +
                " where ue.personType = true ";
        TypedQuery<PersonEntity> query = em.createQuery(hql, PersonEntity.class);
        return query.getResultList();
    }

    public List<PersonEntity> getArrendataryList() {
        String hql = "SELECT ue " +
                " FROM PersonEntity ue" +
                " where ue.personType = false ";
        TypedQuery<PersonEntity> query = em.createQuery(hql, PersonEntity.class);
        return query.getResultList();
    }

    public Optional<PersonEntity> getPersonById(long personId) {
        String hql = "SELECT ue " +
                " FROM PersonEntity ue" +
                " where ue.personId = :personId ";
        TypedQuery<PersonEntity> query = em.createQuery(hql, PersonEntity.class);
        query.setParameter("personId", personId);

        List<PersonEntity> resultList = query.getResultList();
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));
    }


}
