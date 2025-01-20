package LearnBasics;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CreateBodyUsingHashMap extends  baseClassL{

    public static void main(String[] args) {
        // Create in main MAP object in key value pairs (Object *** IMP)
        Map<String, Object> map = new HashMap<>();
        map.put("Amar","Testing");
        map.put("Akbar","develop");

        // Create Array List to create array values Skills[]
        ArrayList<String> sk = new ArrayList<>();
        sk.add("c");
        sk.add("c++");
        sk.add("Java");

        // Create Map to store details in key value pairs (Object *** IMP)
        Map<String,Object> dtls = new HashMap<>();
        dtls.put("companyName","CompanyICE");
        dtls.put("emailId","Testing2@gmail.com");

        // Add in main MAP object
        map.put("skills",sk);
        map.put("details",dtls);


        Response resp = RestAssured
                            .given()
                                .auth().none()
                                .header("Content-Type","application/json")
                                .contentType(ContentType.JSON)
                                .body(map)
                            .when()
                                .post("https://reqres.in/api/users")
                            .then()
                                .extract()
                                .response();

        System.out.println(resp.body().asPrettyString());
        System.out.println("getStatusCode--> " +resp.getStatusCode());
        System.out.println("getStatusLine--> " +resp.getStatusLine());
        System.out.println("getCookies--> " +resp.getCookies());
        System.out.println("getHeaders--> " + resp.getHeaders());

        System.out.println(resp.body().asPrettyString());
        System.out.println(resp.getStatusCode());
        System.out.println(resp.getStatusLine());
        System.out.println(resp.getContentType());
        System.out.println(resp.getCookie(""));
        System.out.println(resp.getHeader("Content-Type"));

        System.out.println(resp.getDetailedCookies());



        Assert.assertEquals(resp.getStatusCode(),201);
        System.out.println(" Status code : " + resp.getStatusCode());
        System.out.println("Time : " + resp.getTime());
        System.out.println(resp.getBody().asPrettyString());


        //Method 1  using JSONPath
        JsonPath json = resp.jsonPath();
        System.out.println(json.getString("name"));
        Assert.assertEquals(resp.getBody().path("skills[1]"), "c++");

        //Method 2 using  resp.getBoday.path("KEY")
        String name = resp.getBody().path("name");  // System.out.println((resp.getBody().path("name")); --> will NOT work, need to assign to String on Int



        //Verify array object
        System.out.println(" skills 0 : "+ resp.getBody().path("skills[0]"));
        System.out.println(" skills 1 : "+ resp.getBody().path("skills[1]"));
        Assert.assertEquals(resp.getBody().path("skills[1]"), "c++");

        //Verify child object
        JsonPath jsonp = resp.jsonPath();
        System.out.println(" Company 1 : "+ jsonp.getString("details.companyName"));
        System.out.println(" email Id  : "+ resp.getBody().path("details.emailId"));


        Assert.assertEquals(resp.getBody().path("details.companyName"), "CompanyICE");
        Assert.assertEquals(resp.getBody().path("details.emailId"), "Testing2@gmail.com");

        System.out.println("\n***************Method 2****************");
        String baseURI = "https://reqres.in/api/users";

        Response resp2 = APIPostWithMaps(baseURI,map);

        //Verify child object
        JsonPath jsonp1 = resp2.jsonPath();
        System.out.println(" Company 1 from Method : "+ jsonp1.getString("details.companyName"));
        System.out.println(" email Id  from Method :  "+ resp2.getBody().path("details.emailId"));


        JsonPath jsonpath = resp2.jsonPath();
        System.out.println(" Company 1 from Method : "+ jsonp1.getString("details.companyName"));
        System.out.println(" email Id  from Method :  "+ resp2.getBody().path("details.emailId"));

        System.out.println(" Company 1 from Method : "+ jsonpath.getString("details.companyName"));
        System.out.println(" email Id  from Method :  "+ resp2.getBody().path("details.emailId"));








    }
}
