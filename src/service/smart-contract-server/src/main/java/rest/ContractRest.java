
package rest;

import dao.LoginDao;
import entity.ContractEntity;
import entity.PersonEntity;
import lombok.extern.jbosslog.JBossLog;
import rest.configuration.path.RestPath;
import service.ContractService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path(RestPath.REST_CONTRACT)
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@JBossLog
public class ContractRest implements Serializable {

    @Inject
    private ContractService contractService;

    @Inject
    private LoginDao loginDao;

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

    @GET
    @Path(RestPath.LIST)
    public Response restContractList(@QueryParam(RestPath.LOGIN) String login) {
        try {
            // log.info("restContractList");
            Optional<PersonEntity> personByUserNameOpt = loginDao.getPersonByUserName(login);
            if (personByUserNameOpt.isPresent()) {
                List<ContractEntity> all = contractService.findAllByPersonId(personByUserNameOpt.get().getPersonId());
                return Response.ok(all).build();
            } else {
                return Response.ok(new ArrayList()).build();
            }
        } catch (Exception e) {
            //log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}

