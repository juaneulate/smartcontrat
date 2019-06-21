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

@Path(RestPath.REST_LOGIN)
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@JBossLog
public class LoginRest implements Serializable {


    @Inject
    private LoginDao loginDao;

    @GET
    @Path(RestPath.VALIDATE)
    public Response restValidateLogin(@QueryParam(RestPath.USERNAME) String login,
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
    public Response getPersonByUserName(@QueryParam(RestPath.USERNAME) String login) {
        try {
            //       log.info("restValidateLogin");
            Optional<PersonEntity> personOpt = loginDao.getPersonByUserName(login);
            //   log.info("userEntity.isPresent() : " + userEntity.isPresent());
            if (personOpt.isPresent()) {
                return Response.ok(personOpt.get()).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
//           log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
