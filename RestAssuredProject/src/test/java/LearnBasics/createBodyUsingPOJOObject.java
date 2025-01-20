package LearnBasics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class createBodyUsingPOJOObject {

    public static void main(String[] args) throws JsonProcessingException {

        EmployePOJO emp = new EmployePOJO("Amar","Tesitng",new String[] {"python1","python2"},"ICE", "test@test.com");

        Response resp;

        resp = 	RestAssured
                .given()
                    .auth().none()
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON)
                    .body(emp)
                //.baseUri("https://reqres.in/api/users")   // OR
                .when()
                    .post("https://reqres.in/api/users")
                .then()
                    .extract()
                    .response();

        Assert.assertEquals(resp.getStatusCode(),201);
        System.out.println(" Status code : " + resp.getStatusCode());
        System.out.println("Time : " + resp.getTime());
        System.out.println(resp.getBody().asPrettyString());

        //Method 1  using JSONPath
        JsonPath json = resp.jsonPath();
        System.out.println(json.getString("name"));
        Assert.assertEquals(resp.getBody().path("skills[1]"), "Python");

        //Method 2 using  resp.getBoday.path("KEY")
        String name = resp.getBody().path("name");  // System.out.println((resp.getBody().path("name")); --> will NOT work, need to assign to String on Int
        System.out.println("Name : " + name);
        Assert.assertEquals(name, "Amar");

        //Verify array object
        System.out.println(" skills 0 : "+ resp.getBody().path("skills[0]"));
        System.out.println(" skills 1 : "+ resp.getBody().path("skills[1]"));
        Assert.assertEquals(resp.getBody().path("skills[1]"), "Python");

        //Verify child object
        System.out.println(" Company 1 : "+ resp.getBody().path("details.companyName"));
        System.out.println(" email Id  : "+ resp.getBody().path("details.emailId"));

        //Assert.assertEquals((resp.getBody().path("details.companyName")), "CompanyICE");
        //Assert.assertEquals(resp.getBody().path("details.emailId"), "Aamresha.bhovi@ice.com");

        System.out.println("\n***************Method 2****************");
        String baseURI = "https://reqres.in/api/users";

        ObjectMapper objmapper = new ObjectMapper();
        //seralization
        String requestbody = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);

        System.out.println(requestbody);
/*
        Response resp2 = APIpostMethodUsingPOJOObject(baseURI,requestbody);
        // ERROR The method APIpostMethodUsingPOJOObject(String, String) is undefined for the type createBodayUsingPOJOObject
        //SOLUTION not Extended the Method



        //Verify child object
        JsonPath jsonp1 = resp2.jsonPath();
        System.out.println(" Company 1 from Method : "+ jsonp1.getString("details.companyName"));
        System.out.println(" email Id  from Method :  "+ resp2.getBody().path("details.emailId"));

        //de-seralization
        //	EmployeePOJO emp2 = objmapper.readValue(requestbody,EmployeePOJO.class);

        //System.out.println(emp2.toString());

     */

    }
}
