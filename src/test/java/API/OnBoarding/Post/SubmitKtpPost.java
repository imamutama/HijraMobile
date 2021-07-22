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

public class SubmitKtpPost extends BaseTest {

    @BeforeClass
    void submitEkyc() throws IOException, JSONException {
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
        httpRequest.header("Content-Type", "multipart/form-data");
        File file1_new2 = new File(System.getProperty("user.dir")+"//filejson//ektp.txt");
        File file1_new1 = new File(System.getProperty("user.dir")+"//filejson//ktp (1).jpg");
        httpRequest.multiPart("customerData", file1_new2);
        httpRequest.multiPart("image", file1_new1, "image/jpeg");
        response = httpRequest.request(Method.POST, "/onboarding/ktp");


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
