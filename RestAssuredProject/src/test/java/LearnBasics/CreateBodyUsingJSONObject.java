package LearnBasics;


import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

public class CreateBodyUsingJSONObject {

    public static void main(String[] args) {

        JSONObject jo = new JSONObject();
        jo.put("name","Morcus");
        jo.put("job","Testing");

        JSONArray ja = new JSONArray();
        ja.put("JAVA");
        ja.put("PYTHON");
        ja.put("C#");

        JSONObject dt = new JSONObject();
        dt.put("CompanyName","TestCompany");
        dt.put("email","email@email.com");

        jo.put("skills",ja);
        jo.put("deatils",dt);

        Response resp = RestAssured
                            .given()
                                    .auth().none()
                                    .header("Content-Type", "application/json")
                                    .contentType(ContentType.JSON)
                                    .body(jo.toString())
                            .when()
                                    .post("https://reqres.in/api/users")
                            .then()
                                    .extract()
                                    .response();




        System.out.println(resp.body().asPrettyString());
        Assert.assertEquals(resp.getStatusCode(),201);

        String s = resp.body().path("companyName");
        System.out.println(s + " Value");


        Assert.assertEquals(resp.getStatusCode(),201);
        System.out.println(" Status code : " + resp.getStatusCode());
        System.out.println("Time : " + resp.getTime());
        System.out.println(resp.getBody().asPrettyString());


        //Method 1  using JSONPath
        JsonPath json = resp.jsonPath();
        System.out.println(json.getString("name"));
        Assert.assertEquals(resp.getBody().path("skills[1]"), "Java");

        //Method 2 using  resp.getBoday.path("KEY")
        String name = resp.getBody().path("name");  // System.out.println((resp.getBody().path("name")); --> will NOT work, need to assign to String on Int
        System.out.println("Name : " + name);
        Assert.assertEquals(name, "Morpus");

        //Verify array object
        System.out.println(" skills 0 : "+ resp.getBody().path("skills[0]"));
        System.out.println(" skills 1 : "+ resp.getBody().path("skills[1]"));
        Assert.assertEquals(resp.getBody().path("skills[1]"), "Java");

        //Verify child object
        System.out.println(" Company 1 : "+ resp.getBody().path("details.companyName"));
        System.out.println(" email Id  : "+ resp.getBody().path("details.emailId"));

        Assert.assertEquals((resp.getBody().path("details.companyName")), "CompanyICE");
        Assert.assertEquals(resp.getBody().path("details.emailId"), "Aamresha.bhovi@ice.com");


        System.out.println("\n***************Method 2****************");
        String baseURI = "https://reqres.in/api/users";

       /* Response resp2 = APIpostMethodUsingJsonObject(baseURI,jo.toString());

        //Verify child object
        JsonPath jsonp1 = resp2.jsonPath();
        System.out.println(" Company 1 from Method : "+ jsonp1.getString("details.companyName"));
        System.out.println(" email Id  from Method :  "+ resp2.getBody().path("details.emailId"));


        */
    }
}
