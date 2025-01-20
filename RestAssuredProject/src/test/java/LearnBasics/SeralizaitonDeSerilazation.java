package LearnBasics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static LearnBasics.baseClassL.APIpostMethodUsingPOJOObject;


public class SeralizaitonDeSerilazation {

    @Test
    public void Seralization() throws JsonProcessingException {

        EmployePOJO emp = new EmployePOJO("Amar", "Tesitng", new String[]{"python1", "python2", "python3"}, "ICE", "test@test.com");

        //ObjectMapper with fasterxml.jackson.databind Seralization
        ObjectMapper objmapper = new ObjectMapper();
        String json = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);

        System.out.println(json);


        JSONObject jo = new JSONObject(json.toString());

        for (int i = 0; i < jo.getJSONArray("skills").length(); i++) {


            String skillName = jo.getJSONArray("skills").toString();
            System.out.println(skillName);

            String eachValue = jo.getJSONArray("skills").get(i).toString();
            System.out.println(eachValue);

            //if object is inside the array
            //String bookName = jo.getJSONArray("book").getJSONObject(i).get("titleName").toString();

        }


        String baseURI = "https://reqres.in/api/users/1";
        Response resp2 = APIpostMethodUsingPOJOObject(baseURI,json);

        System.out.println("test--> "+resp2.asString()); // *** asString() works not isString()

        EmployePOJO empOutput = objmapper.readValue(resp2.asString(),EmployePOJO.class);

        System.out.println("Name : " + empOutput.getName());
        System.out.println("getJob() : " + empOutput.getJob());
       // System.out.println("getSkills : " + empOutput.getSkills());
       // System.out.println("getCompanyName : " + empOutput.getdetails().getCompanyName());
       // System.out.println("getEmailId : " + empOutput.getdetails().getEmailId());



        //Verify child object
        JsonPath jsonp1 = resp2.jsonPath();
        System.out.println(" Company 1 from Method : "+ jsonp1.getString("details.companyName"));
        System.out.println(" email Id  from Method :  "+ resp2.getBody().path("details.emailId"));



    }

    @Test
    public void DeSeralization() throws JsonProcessingException {

    }
}
