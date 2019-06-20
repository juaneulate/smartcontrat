
package rest;

import com.google.gson.reflect.TypeToken;
import dao.ContractDao;
import dao.LoginDao;
import dto.ContractDto;
import dto.PersonLoginDto;
import entity.ContractEntity;
import entity.LoginEntity;
import entity.PersonEntity;
import lombok.extern.jbosslog.JBossLog;
import rest.configuration.path.RestPath;
import service.ContractService;
import utils.JsonUtil;

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
    private ContractDao contractDao;

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
    public Response restContractList(@QueryParam(RestPath.VALIDATE) String login) {
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
    @POST
    @Path(RestPath.LIST)
    public Response resContractSave(String jsonBody) {
        try {
            //log.info("testingPostService" + jsonBody);
            System.out.println("jsonPropietary: "+jsonBody);
            ContractEntity contractEntity = getContractEntity(jsonBody);
            contractDao.persist(contractEntity);
            return Response.ok(true).build();
        } catch (Exception e) {
            // log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public ContractEntity getContractEntity(String jsonBody) {
        TypeToken<ContractDto> typeToken = new TypeToken<ContractDto>() {};
        ContractDto contractDto = JsonUtil.fromJson(jsonBody, typeToken);
        ContractEntity contractEntity = ContractEntity.build(contractDto.getRegistroBilletera(),contractDto.getMontoTotal(),contractDto.getCuota(),contractDto.isEstadoContrato(),contractDto.getNombreContrato());
        return ContractEntity.build(contractDto.getRegistroBilletera(),contractDto.getCuota(),contractDto.getCuota(),contractDto.isEstadoContrato(),contractDto.getNombreContrato(),contractEntity);
    }




}

