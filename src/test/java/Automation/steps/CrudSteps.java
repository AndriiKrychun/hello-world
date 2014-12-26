package Automation.steps;

import Automation.AlmAccessory;
import Automation.AlmUtils;
import Automation.ConnectionProperties;
import Automation.CookieStorage;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CrudSteps {
    public static String id;
    public static String statusCode;
    ConnectionProperties props;
    CookieStorage cookieStorage;
    RestClient client;


    AlmAccessory accessory = new AlmAccessory();


    @When("I create new defect")
    public void postSomeDefectTest() throws IOException, InterruptedException {
        prepare();
        Resource defectResource = client.resource(props.getBaseDirUri() + "api/domains/" + props.getDomain() + "/projects/" + props.getProject() + "/defects/");
        cookieStorage.applyCookies(defectResource);
        AlmAccessory.Defect newDefect = new AlmAccessory.Defect();
        Date time = Calendar.getInstance().getTime();
        newDefect.creationTime = new SimpleDateFormat("YYYY-MM-dd").format(time);
        newDefect.detectedBy = "sa";
        newDefect.severity = "3-High";
        newDefect.name = "defect from testPostDefect method created on " + new SimpleDateFormat("YYYY-MM-dd HH:mm").format(time);
        ClientResponse defectResponce = null;
        try {
            defectResponce = defectResource.contentType(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, new ObjectMapper().writeValueAsString(newDefect));
        } catch (Exception e) {
            e.printStackTrace();
        }
        statusCode = String.valueOf(defectResponce.getStatusCode());

    }

    @Then("statusCode of post request should be $statusCode")
    public void checkPostDefectResult(String statusCode) {
//        System.out.println(statusCode);
        if (!(statusCode.equals("200"))) {
            throw new RuntimeException("ArErr");
        }
    }


    @Given("defect")
    public void postDefect() {
        String defectId = null;
        try {
            defectId = accessory.postDefect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        id = defectId;
    }

    @When("I delete this defect")
    public void deleteDefectTest() {
        prepare();
        String defectId = id;
        Resource defectResource = client.resource(props.getBaseDirUri() + "api/domains/" + props.getDomain() + "/projects/" + props.getProject() + "/defects/" + defectId);
        cookieStorage.applyCookies(defectResource);
        ClientResponse defectResponce = defectResource.delete();
        statusCode = String.valueOf(defectResponce.getStatusCode());
    }

    @Then("statusCode of delete request should be $statusCode")
    public void checkResult(String statusCode) {
//        System.out.println(statusCode);
        if (!(statusCode.equals("200"))) {
            throw new RuntimeException("ArErr");
        }

    }


    public void prepare() {
        props = AlmUtils.getConnectionProperties();
        cookieStorage = AlmUtils.loginWithDefaults();
        client = new RestClient();

    }


}
