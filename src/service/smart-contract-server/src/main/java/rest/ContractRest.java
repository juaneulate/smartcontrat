
package rest;

import entity.ContractEntity;
import lombok.extern.jbosslog.JBossLog;
import rest.configuration.path.RestPath;
import service.ContractService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.List;

@Path(RestPath.REST_CONTRACT)
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@JBossLog
public class ContractRest implements Serializable {

    @Inject
    private ContractService contractService;

    @GET
    @Path(RestPath.LIST)
    public Response restContractList() {
        try {
           // log.info("restContractList");

            List<ContractEntity> all = contractService.findAll();
            return Response.ok(all).build();
        } catch (Exception e) {
            //log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}

