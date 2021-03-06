package rest;

import dao.UtilDao;
import dto.DetailTestDto;
import dto.TestDto;
import lombok.extern.jbosslog.JBossLog;
import org.jboss.logging.Logger;
import rest.configuration.path.RestPath;
import utils.JsonUtil;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Date;

@Path(RestPath.REST_UTIL)
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@JBossLog
public class UtilRest implements Serializable {



    @Inject
    private UtilDao utilDao;

    @GET
    @Path(RestPath.TEST_SQL)
    public Response testingSQlService() {
        try {
          //  log.info("Testing Rest DB");
            Date currentTimeStamp = utilDao.currentTimeStamp();
            return Response.ok(currentTimeStamp.toString()).build();
        } catch (Exception e) {
         //  log.info(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path(RestPath.TEST_GET)
    public Response testingGetService() {
        try {
           // log.info("testingGetService");

            return Response.ok("testing Get Service OK").build();
        } catch (Exception e) {
          //  log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path(RestPath.TEST_GET_SERVICE_WITH_PARAM)
    public Response testingGetWithParamService(@QueryParam(RestPath.CODE) String code) {
//        log.info("testingGetWithParamService : " + code);
        try {
         //   log.info("testingGetWithParamService: " + code);
            return Response.ok("testingGetWithParamService : " + code).build();
        } catch (Exception e) {
          //  log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path(RestPath.TEST_POST)
    public Response testingPostService(String jsonBody) {
        try {
         //   log.info("testingPostService" + jsonBody);
            return Response.ok(jsonBody).build();
        } catch (Exception e) {
         //   log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path(RestPath.TEST_POST_WITH_DTO)
    public Response testingPostWithDtoService(TestDto myDto) {
        try {
          //  log.info("testingPostWithDtoService :  " + JsonUtil.toJson(myDto));
            return Response.ok(JsonUtil.toJson(myDto)).build();
        } catch (Exception e) {
          //  log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path(RestPath.TEST_PUT)
    public Response testingPutService(DetailTestDto detailTestDto) {
        try {
           // log.info("testingPutService");
            return Response.ok(JsonUtil.toJson(detailTestDto)).build();
        } catch (Exception e) {
           // log.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
