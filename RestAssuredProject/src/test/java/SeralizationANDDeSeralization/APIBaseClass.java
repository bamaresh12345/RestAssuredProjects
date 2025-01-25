package SeralizationANDDeSeralization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIBaseClass {


    public Response getAPI(String uri) //// IMP **** RESPONSE Response IS IMP
    {


        Response resp = RestAssured
                .given()
                .auth().none()
                .header("Content-Type","application/json")
                .when()
                .get(uri)
                .then()
                .extract()
                .response();


        return resp;  // IMP ****RESPONSE IS IMP
    }

    public Response postAPI(String body,String uri) //// IMP **** RESPONSE Response IS IMP
    {


        Response resp = RestAssured
                .given()
                .auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(uri)
                .then()
                .extract()
                .response();


        return resp;  // IMP ****RESPONSE IS IMP
    }

    public Response getAPIQueryParam(String uri) //// IMP **** RESPONSE Response IS IMP
    {


        Response resp = RestAssured
                .given()
                .auth().none()
                .header("Content-Type","application/json")
                .queryParam("firstname", "Amar")                        // firstname=Amar & lastname= Testing
                .queryParam("lastname", "Testing").log().all()
                //.baseUri("")
                .when()
                .get(uri)
                .then().log().all()
                .extract()
                .response();


        return resp;  // IMP ****RESPONSE IS IMP
    }

}
