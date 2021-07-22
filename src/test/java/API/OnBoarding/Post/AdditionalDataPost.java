package API.OnBoarding.Post;

import API.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class AdditionalDataPost extends BaseTest {

    @BeforeClass
    void reviewPage() throws IOException, JSONException {
        logger.info("Started login Testing API");
        Properties properties = new Properties();
        properties.load(new FileInputStream("dataApi.properties"));
        String url = properties.getProperty("ipCustomer");
        try {
            accesToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//filejson//accessToken.json"), StandardCharsets.UTF_8);
            System.out.println(accesToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given().header("Authorization", "Bearer " + accesToken);

        try {
            requestParams = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//filejson//additionalData.json"), StandardCharsets.UTF_8);
            System.out.println(requestParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams);
        response = httpRequest.request(Method.POST, "/onboarding/additional-data");

    }

    @Test(priority = 0)
    @Parameters({"statusCode"})
    void checkResponseBody(String statusCode) throws IOException {
        logger.info("Checking Response Body");
        String responseBoody = response.getBody().asString();
        logger.info("Response Body =>" + responseBoody);
        Assert.assertEquals(responseBoody.contains(statusCode), true);
        //   Assert.assertEquals(responseBoody.contains(description), true);
    }

    @Test(priority = 1)
    void checkResponseCode() {
        logger.info("Checking Status Code");
        int responseCode = response.getStatusCode();
        Assert.assertEquals(responseCode, 200);
    }

}
