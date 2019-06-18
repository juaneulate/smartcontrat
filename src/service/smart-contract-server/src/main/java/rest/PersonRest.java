package rest;


import com.google.gson.Gson;
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

@Path(RestPath.REST_PERSON)
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@JBossLog
public class PersonRest implements Serializable {



    @Inject
    private PersonDao personDao;
    /*private static Gson gson= new Gson();*/


    @POST
    @Path(RestPath.TEST_POST_PROPIETARY_SAVE)
    public Response savePropietary(String jsonBody) {
        try {
            //log.info("testingPostService" + jsonBody);
            System.out.println("jsonPropietary: "+jsonBody);
            TypeToken<PersonLoginDto> typeToken= new TypeToken<PersonLoginDto>(){};
            PersonLoginDto personLoginDto= JsonUtil.fromJson(jsonBody,typeToken);
            PersonEntity personEntity= new PersonEntity(personLoginDto.getLastname(),personLoginDto.getAge(),true);
            LoginEntity loginEntity=new LoginEntity(personLoginDto.getLogin(),personLoginDto.getPassword(),personEntity);
            personDao.persist(loginEntity);
            return Response.ok(true).build();
        } catch (Exception e) {
           // log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path(RestPath.TEST_POST_ARRENDETARY_SAVE)
    public Response saveArrendatary(String jsonBody) {
        try {
          //  log.info("testingPostService" + jsonBody);
            System.out.println("jsonPropietary: "+jsonBody);
            TypeToken<PersonEntity> typeToken= new TypeToken<PersonEntity>(){};
            PersonEntity personPropietary= JsonUtil.fromJson(jsonBody,typeToken);
            System.out.println(personPropietary);
            personPropietary.setPersonType(false);
            personDao.persist(personPropietary);
            return Response.ok(true).build();
        } catch (Exception e) {
          //  log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


}
