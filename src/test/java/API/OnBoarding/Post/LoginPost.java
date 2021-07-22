package API.OnBoarding.Post;

import API.BaseTest;
import Mobile.utils.ReadWriteText;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LoginPost extends BaseTest {
    @BeforeClass
    @Parameters({"username", "password", "deviceID"})
    void login(String username, String password, String deviceID) throws IOException, JSONException {
        logger.info("Started login Testing API");
        Properties properties = new Properties();
        properties.load(new FileInputStream("dataApi.properties"));
        String url = properties.getProperty("ipCiam");
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();

        HashMap<String, Object> deviceValue = new HashMap<String, Object>();
        deviceValue.put("deviceId", deviceID);
        List<Map<String, Object>> parseList = new ArrayList<Map<String, Object>>();
        parseList.add(deviceValue);

        requestParams.put("username", username);
        requestParams.put("passwd", password);
        requestParams.put("deviceInfo", parseList);

        logger.info("Body Param : " + requestParams);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.request(Method.POST, "/auth/sign-in");
        String complete = response.asString();
        System.out.println(complete);
        JsonPath js = new JsonPath(complete);
        String id = js.get("data.accessToken").toString();
        System.out.println(id);
        try (FileWriter file = new FileWriter("accessToken.json")) {
            file.write(id);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 0)
    @Parameters({"statusCode", "description"})
    void checkResponseBody(String statusCode, String description) throws IOException {
        logger.info("Checking Response Body");
        String responseBoody = response.getBody().asString();
        logger.info("Response Body =>" + responseBoody);
        Assert.assertEquals(responseBoody.contains(statusCode), true);
        Assert.assertEquals(responseBoody.contains(description), true);
    }

    @Test(priority = 1)
    void checkResponseCode() {
        logger.info("Checking Status Code");
        int responseCode = response.getStatusCode();
        Assert.assertEquals(responseCode, 200);
    }

}
