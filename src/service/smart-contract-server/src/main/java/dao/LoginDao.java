package dao;

import entity.ContractEntity;
import entity.UserEntity;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Named
public class LoginDao extends BaseDaoImpl {

    public Optional<UserEntity> validateUser(String login, String password) {
        String hql = "SELECT ue " +
                " FROM UserEntity ue " +
                " WHERE ue.login=:login and ue.password=:password ";
        TypedQuery<UserEntity> query = em.createQuery(hql, UserEntity.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<UserEntity> resultList = query.getResultList();
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));
    }
}
