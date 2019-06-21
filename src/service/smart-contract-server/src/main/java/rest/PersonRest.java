package rest;


import com.google.gson.reflect.TypeToken;
import dao.PersonDao;
import dto.PersonLoginDto;
import entity.LoginEntity;
import entity.PersonEntity;
import lombok.extern.jbosslog.JBossLog;
import rest.configuration.path.RestPath;
import utils.JsonUtil;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.List;

@Path(RestPath.REST_PERSON)
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@JBossLog
public class PersonRest implements Serializable {



    @Inject
    private PersonDao personDao;
    /*private static Gson gson= new Gson();*/


    @POST
    @Path(RestPath.TEST_POST_OWNER_SAVE)
    public Response saveOwner(String jsonBody) {
        try {
            //log.info("testingPostService" + jsonBody);
            System.out.println("jsonPropietary: "+jsonBody);
            LoginEntity loginEntity = getLoginEntity(jsonBody, true);
            personDao.persist(loginEntity);
            return Response.ok(true).build();
        } catch (Exception e) {
           // log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path(RestPath.TEST_POST_TENANT_SAVE)
    public Response saveTenant(String jsonBody) {
        try {
          //  log.info("testingPostService" + jsonBody);
            LoginEntity loginEntity = getLoginEntity(jsonBody, false);
            personDao.persist(loginEntity);
            return Response.ok(true).build();
        } catch (Exception e) {
          //  log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public LoginEntity getLoginEntity(String jsonBody, boolean b) {
        TypeToken<PersonLoginDto> typeToken = new TypeToken<PersonLoginDto>() {
        };
        PersonLoginDto personLoginDto = JsonUtil.fromJson(jsonBody, typeToken);
        PersonEntity personEntity = PersonEntity.build(personLoginDto.getLastname(), personLoginDto.getAge(), b);
        return LoginEntity.build(personLoginDto.getLogin(), personLoginDto.getPassword(), personEntity);
    }

    @GET
    @Path(RestPath.LIST)
    public Response getPersonList() {
        try {
          //  log.info("testingPostService" + jsonBody);
            System.out.println("jsonPerson: ");
            List<PersonEntity> personList = personDao.getPersonList();
            return Response.ok(personList).build();
        } catch (Exception e) {
          //  log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path(RestPath.LIST_OWNER)
    public Response getOwnerList() {
        try {
          //  log.info("testingPostService" + jsonBody);
            System.out.println("jsonPropietary: ");
            List<PersonEntity> personList = personDao.getOwnerList();
            return Response.ok(personList).build();
        } catch (Exception e) {
          //  log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    @GET
    @Path(RestPath.LIST_TENANT)
    public Response getTenantList() {
        try {
          //  log.info("testingPostService" + jsonBody);
            System.out.println("jsonArrendatary: ");
            List<PersonEntity> personList = personDao.getArrendataryList();
            return Response.ok(personList).build();
        } catch (Exception e) {
          //  log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


}
