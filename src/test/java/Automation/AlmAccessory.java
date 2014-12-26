package Automation;

import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;

/**
 * Created by akrychun on 12/24/14.
 */
public class AlmAccessory {
     ConnectionProperties props = AlmUtils.getConnectionProperties();
    private  CookieStorage cookieStorage;

    public  String postDefect() throws Exception{

        RestClient client = new RestClient();
        Resource defectResource = client.resource(props.getBaseDirUri() + "api/domains/" + props.getDomain() + "/projects/" + props.getProject() + "/defects/");
        CookieStorage cookieStorage =  AlmUtils.loginWithDefaults();
        cookieStorage.applyCookies(defectResource);
        Defect newDefect = new Defect();
        newDefect.creationTime = "2001-01-01";
        newDefect.detectedBy="sa";
        newDefect.severity="3-High";
        newDefect.name="Some defect";
        ClientResponse defectResponce = defectResource.contentType(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, new ObjectMapper().writeValueAsString(newDefect));
        return new ObjectMapper().readValue(defectResponce.getEntity(String.class), HashMap.class).get("id").toString();
    }

    public void deleteDefect(String defectId) {
        RestClient client = new RestClient();
        Resource defectResource = client.resource(props.getBaseDirUri() + "api/domains/" + props.getDomain() + "/projects/" + props.getProject() + "/defects/" + defectId);
        cookieStorage.applyCookies(defectResource);
        defectResource.delete();
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
