package API.OnBoarding.Post;

import API.BaseTest;
import Mobile.helper.DatabaseConnection;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class OTPVerifPost extends BaseTest {
    @BeforeClass
    @Parameters({"username"})
    void otpVerify(String username) throws IOException, JSONException {
        logger.info("Started login Testing API");
        Properties properties = new Properties();
        properties.load(new FileInputStream("dataApi.properties"));
        String url = properties.getProperty("ipCiam");
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT generated_token FROM otp_token WHERE user_id IN" +
                    "(SELECT user_id FROM user_login WHERE username = '" + username + "')";
            String getOtp = DatabaseConnection.QuerySql(sql, 1);
            JSONObject requestParams = new JSONObject();
            requestParams.put("otp", getOtp);
            requestParams.put("username", username);

            logger.info("Body Param : " + requestParams);

            httpRequest.header("Content-Type", "application/json");
            httpRequest.body(requestParams.toJSONString());
            response = httpRequest.request(Method.POST, "/verify/otp-verification");
        } catch (Exception e) {
            e.printStackTrace();
        }

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
