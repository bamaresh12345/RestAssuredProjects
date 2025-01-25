package LearnBasics;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.util.Map;

public class baseClassL {


    public static Response APIPostWithMaps(String baseuri, Map map)
    {

        Response resp = RestAssured
                                .given()
                                    .auth().none()
                                    .header("Content-Type", "application/json")
                                    .contentType(ContentType.JSON)
                                    //.baseUri("https://reqres.in/api/users")   // OR
                                    .body(map)
                                .when()
                                    .post(baseuri)
                                .then()
                                    .extract()
                                    .response();

        return resp;

    }


    public static Response APIpostMethodUsingJsonObject(String baseURI,String jo ) //with JsonObject is IMPORTANT
    {


        Response resp = RestAssured
                .given()
                .auth().none()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                //.baseUri("https://reqres.in/api/users")   // OR
                .body(jo)
                .when()
                .post(baseURI)
                .then()
                .extract()
                .response();


        return resp;

    }


    public static Response APIpostMethodUsingPOJOObject(String baseURI,String requestBody ) //with POJOObject is IMPORTANT
    {


        Response resp = RestAssured
                .given()
                .auth().none()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                //.baseUri("https://reqres.in/api/users")   // OR
                .body(requestBody)
                .when()
                .post(baseURI)
                .then()
                .extract()
                .response();


        return resp;

    }

    public static Response APIGetMethodUsingPOJOObject(String baseURI,String requestBody ) //with POJOObject is IMPORTANT
    {


        Response resp = RestAssured
                .given()
                .auth().none()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                //.baseUri("https://reqres.in/api/users")   // OR
                //.body(requestBody)
                .when()
                .get(baseURI)
                .then()
                .extract()
                .response();


        return resp;

    }
}
