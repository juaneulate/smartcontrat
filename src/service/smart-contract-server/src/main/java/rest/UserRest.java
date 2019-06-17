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
    LoginDao loginDao;

    @GET
    @Path("/login")
    public Response restValidateLogin(@QueryParam("username")String username, @QueryParam("password")String password ) {
        try {
            // log.info("restInfuraService");

            Optional<UserEntity> userEntity=loginDao.validateUser(username,password);
            if(userEntity.isPresent()){
                return Response.ok(true).build();
            }


            return Response.ok(false).build();
        } catch (Exception e) {
            //log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
