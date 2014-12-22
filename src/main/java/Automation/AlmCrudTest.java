package Automation;

import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by akrychun on 12/22/14.
 */
public class AlmCrudTest {
    ConnectionProperties props = AlmUtils.getConnectionProperties();
    private CookieStorage cookieStorage;

    @Before
    public void setUp() throws Exception {
        cookieStorage = AlmUtils.loginWithDefaults();
    }

    public String postDefect() throws Exception{
        RestClient client = new RestClient();
        Resource defectResource = client.resource(props.getBaseDirUri() + "api/domains/" + props.getDomain() + "/projects/" + props.getProject() + "/defects/");
        cookieStorage.applyCookies(defectResource);
        Defect newDefect = new Defect();
        newDefect.creationTime = "2001-01-01";
        newDefect.detectedBy="sa";
        newDefect.severity="3-High";
        newDefect.name="Some defect";
        ClientResponse defectResponce = defectResource.contentType(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, new ObjectMapper().writeValueAsString(newDefect));
        return new ObjectMapper().readValue(defectResponce.getEntity(String.class), HashMap.class).get("id").toString();
    }

    public void deleteDefect(String defectId) throws Exception {
        RestClient client = new RestClient();
        Resource defectResource = client.resource(props.getBaseDirUri() + "api/domains/" + props.getDomain() + "/projects/" + props.getProject() + "/defects/" + defectId);
        cookieStorage.applyCookies(defectResource);
        defectResource.delete();
    }


    @Test
    public void testGetDomains() throws Exception {
        RestClient client = new RestClient();
        Resource domainsResource = client.resource(props.getBaseDirUri() + "api/domains/");
        cookieStorage.applyCookies(domainsResource);
        ClientResponse domainsResponse = domainsResource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get();
        Assert.assertEquals(200, domainsResponse.getStatusCode());
        String content = domainsResponse.getEntity(String.class);
        System.out.println(content);
        DomainsResult domainsResult = new ObjectMapper().readValue(content, DomainsResult.class);
        System.out.println(domainsResult.totalCount);
    }


    @Test
    public void testGetDefects() throws Exception{
        String id = postDefect();
        RestClient client = new RestClient();
        Resource defectsResource = client.resource(props.getBaseDirUri() + "api/domains/" + props.getDomain() + "/projects/" + props.getProject() + "/defects");
        cookieStorage.applyCookies(defectsResource);
        ClientResponse defectsResponce = defectsResource.accept(MediaType.APPLICATION_JSON_TYPE).get();
        Assert.assertEquals(200,defectsResponce.getStatusCode());
        String content = defectsResponce.getEntity(String.class);
        System.out.println(content);
        deleteDefect(id);
    }

    @Test
    public void testGetDefectById() throws Exception{
        String id = postDefect();
        RestClient client = new RestClient();
        Resource defectResource = client.resource(props.getBaseDirUri() + "api/domains/" + props.getDomain() + "/projects/" + props.getProject() + "/defects/" + id);
        cookieStorage.applyCookies(defectResource);
        ClientResponse defectResponce = defectResource.accept(MediaType.APPLICATION_JSON_TYPE).get();
        Assert.assertEquals(200,defectResponce.getStatusCode());
        String content = defectResponce.getEntity(String.class);
        System.out.println(content);
        deleteDefect(id);
    }

    @Test
    public void testPostDefect() throws Exception{
        RestClient client = new RestClient();
        Resource defectResource = client.resource(props.getBaseDirUri() + "api/domains/" + props.getDomain() + "/projects/" + props.getProject() + "/defects/");
        cookieStorage.applyCookies(defectResource);
        Date time = Calendar.getInstance().getTime();
        Defect newDefect = new Defect();
        newDefect.creationTime = new SimpleDateFormat("YYYY-MM-dd").format(time);
        newDefect.detectedBy="sa";
        newDefect.severity="3-High";
        newDefect.name="defect from testPostDefect method created on " + new SimpleDateFormat("YYYY-MM-dd HH:mm").format(time);
        ClientResponse defectResponce = defectResource.contentType(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, new ObjectMapper().writeValueAsString(newDefect));
        String id = new ObjectMapper().readValue(defectResponce.getEntity(String.class), HashMap.class).get("id").toString();
        Assert.assertEquals(201, defectResponce.getStatusCode());
        deleteDefect(id);
    }

    @Test
    public void testDeleteDefect() throws Exception {
        String defectId = postDefect();
        RestClient client = new RestClient();
        Resource defectResource = client.resource(props.getBaseDirUri() + "api/domains/" + props.getDomain() + "/projects/" + props.getProject() + "/defects/" + defectId);
        cookieStorage.applyCookies(defectResource);
        ClientResponse defectResponce = defectResource.delete();
        Assert.assertEquals(200, defectResponce.getStatusCode());
    }

    @Test
    public void testUpdateDefect() throws Exception {
        String defectId = postDefect();
        RestClient client = new RestClient();
        Resource defectResource = client.resource(props.getBaseDirUri() + "api/domains/" + props.getDomain() + "/projects/" + props.getProject() + "/defects/" + defectId);
        cookieStorage.applyCookies(defectResource);
        ClientResponse defectResponce = defectResource.contentType(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class, "{\"name\": \"Updated name\"}");
        Assert.assertEquals(200, defectResponce.getStatusCode());
        deleteDefect(defectId);
    }

    public static class Defect {
        public String name;
        @JsonProperty("creation-time")
        public String creationTime;
        @JsonProperty("detected-by")
        public String detectedBy;
        public String severity;

//        @JsonIgnore
//        public Object type;
//        @JsonProperty("has-change")
//        public Object hasChange;

    }

//    public static class DefectsResult {
//        public List<Defect> data;
//        @JsonProperty("total-count")
//        public int totalCount;
//    }

    public static class Domain {
        public String name;
        @JsonIgnore
        public Object projects;
    }

    public static class DomainsResult {
        public List<Domain> results;
        @JsonProperty("total-count")
        public int totalCount;
    }

}
