
package rest;

import lombok.extern.jbosslog.JBossLog;
import rest.configuration.path.RestPath;
import testing.InfuraService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.math.BigInteger;

@Path(RestPath.REST_INFURA)
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@JBossLog
public class InfuraRest implements Serializable {

    @Inject
    private InfuraService infuraService;

    @GET
    @Path(RestPath.LIST)
    public Response restInfuraService() {
        try {
           // log.info("restInfuraService");

            BigInteger bigInteger = infuraService.writeToContract();
            String s = infuraService.readFromContract();

            return Response.ok().build();
        } catch (Exception e) {
            //log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}

