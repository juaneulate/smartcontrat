package rest;


import dao.LoginDao;
import entity.UserEntity;
import lombok.extern.jbosslog.JBossLog;
import rest.configuration.path.RestPath;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Optional;

@Path(RestPath.REST_USER)
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@JBossLog
public class UserRest implements Serializable {

    @Inject
    private LoginDao loginDao;

    @GET
    @Path(RestPath.LOGIN)
    public Response restValidateLogin(@QueryParam(RestPath.USERNAME) String username,
                                      @QueryParam(RestPath.PASSWORD) String password) {
        try {
            log.info("restValidateLogin");
            Optional<UserEntity> userEntity = loginDao.validateUser(username, password);
            log.info("userEntity.isPresent() : " + userEntity.isPresent());
            return Response.ok(userEntity.isPresent()).build();
        } catch (Exception e) {
            log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
