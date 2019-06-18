package rest;


import dao.LoginDao;
import entity.LoginEntity;
import entity.PersonEntity;
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
    public Response restValidateLogin(@QueryParam(RestPath.LOGIN) String login,
                                      @QueryParam(RestPath.PASSWORD) String password) {
        try {
     //       log.info("restValidateLogin");
            Optional<LoginEntity> userEntity = loginDao.validateUser(login, password);
        //   log.info("userEntity.isPresent() : " + userEntity.isPresent());
            return Response.ok(userEntity.isPresent()).build();
        } catch (Exception e) {
//           log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path(RestPath.GET_PERSON)
    public Response getPersonByUserName(@QueryParam(RestPath.LOGIN) String login) {
        try {
     //       log.info("restValidateLogin");
            Optional<PersonEntity> PersonEntity = loginDao.getPersonByUserName(login);
        //   log.info("userEntity.isPresent() : " + userEntity.isPresent());
            return Response.ok(PersonEntity.get()).build();
        } catch (Exception e) {
//           log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
