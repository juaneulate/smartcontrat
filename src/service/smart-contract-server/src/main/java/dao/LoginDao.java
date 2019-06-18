package dao;

import entity.LoginEntity;
import entity.PersonEntity;

import javax.inject.Named;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Named
public class LoginDao extends BaseDaoImpl {

    public Optional<LoginEntity> validateUser(String login, String password) {
        String hql = "SELECT ue " +
                " FROM UserEntity ue " +
                " WHERE ue.login=:login and ue.password=:password ";
        TypedQuery<LoginEntity> query = em.createQuery(hql, LoginEntity.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<LoginEntity> resultList = query.getResultList();
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));
    }

    public Optional<PersonEntity> getPersonByUserName(String UserName) {
        String hql = "SELECT ue.personEntity " +
                " FROM LoginEntity le" +
                " where le.login = :userName ";
        TypedQuery<PersonEntity> query = em.createQuery(hql, PersonEntity.class);
        query.setParameter("userName", UserName);

        List<PersonEntity> resultList = query.getResultList();
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));
    }
}
