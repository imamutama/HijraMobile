package API.OnBoarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    @org.testng.annotations.Test
    public void test1(){

        HashMap<String, Object> deviceValue = new HashMap<String, Object>();
        deviceValue.put("deviceId", 112);
        List<Map<String, Object>> parseList = new ArrayList<Map<String, Object>>();
        parseList.add(deviceValue);
        System.out.println(parseList);

    }
}
