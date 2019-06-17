package dao;

import javax.persistence.Query;
import java.util.Date;

public class UtilDao extends BaseDaoImpl {

    public Date currentTimeStamp() {
        String sql = "SELECT current_timestamp ";
        Query query = em.createNativeQuery(sql);
        return (Date) query.getSingleResult();
    }

}
