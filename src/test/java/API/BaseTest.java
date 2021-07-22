package API;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public static RequestSpecification httpRequest;
    public static Response response;
    public Logger logger;
    public Object accesToken;
    public Object requestParams;

    @BeforeClass
    public void setup(){
        logger = Logger.getLogger("LoggerRestAPI");
        PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);
    }
}
