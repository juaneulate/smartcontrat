package dao;

import entity.ContractEntity;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ContractDao extends BaseDaoImpl {

    public List<ContractEntity> findAll() {
        String hql = "SELECT cc " +
                " FROM ContractEntity cc ";
        TypedQuery<ContractEntity> query = em.createQuery(hql, ContractEntity.class);
        return query.getResultList();
    }

    public Optional<ContractEntity> getById(long id) {
        String hql = "SELECT cc " +
                " FROM ContractEntity cc " +
                " WHERE cc.idcontrato=:id ";
        TypedQuery<ContractEntity> query = em.createQuery(hql, ContractEntity.class);
        query.setParameter("id", id);
        List<ContractEntity> resultList = query.getResultList();
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));
    }

    public List<ContractEntity> findAllByPersonId(long personId) {
        String hql = "SELECT cc " +
                " FROM ContractEntity cc " +
                "  where cc.personEntity.personId = :personId";
        TypedQuery<ContractEntity> query = em.createQuery(hql, ContractEntity.class);
        query.setParameter("personId", personId);
        return query.getResultList();
    }

}
