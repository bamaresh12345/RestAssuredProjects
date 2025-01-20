package BodyFromStringFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class BookingPostAPI {


    @Test
    public void createBookingAPI()
    {

        // we can pass body as string for POST API thru
        BookingTemplateAPI bookingAPI = new BookingTemplateAPI();

        String jsonStr1 = bookingAPI.createBooking("Amar", 128); // only two parameters are valirables for method createBooking

        Response response;

        response =   RestAssured
                        .given()
                            .contentType(ContentType.JSON)
                            .header("Content-Type", "application/json")
                            .body(jsonStr1)
                            .baseUri("https://restful-booker.herokuapp.com/booking")
                            .log().headers()  // if needed log it
                        .when()
                            .post()
                        .then()
                            .extract()
                            .response();

        // Use JSON Path to Parse
            JsonPath jp = response.jsonPath();

        System.out.println("firstname--> " + jp.prettyPrint()); //--> Always PRINT prettyPRINT it will show the hirarchy
        System.out.println("bookingid --> " + jp.getString("bookingid"));
        System.out.println("firstname --> " + jp.getString("booking.firstname"));
        System.out.println("lastname --> " + jp.getString("booking.lastname"));
        System.out.println("totalprice-->  " +  jp.getString("booking.totalprice"));
        System.out.println("checkin-->  " + jp.getString("booking.bookingdates.checkin"));
        System.out.println("checkout-->  " + jp.getString("booking.bookingdates.checkout"));
        System.out.println("additionalneeds-->  " + jp.getString("booking.additionalneeds"));   // ** IMP

        System.out.println("************************************************");
        System.out.println("getCookies-->  " + response.getCookies());   // ** IMP
        System.out.println("getHeaders-->  " + response.getHeaders());   // ** IMP
        System.out.println("getStatusCode-->  " + response.getStatusCode());   // ** IMP


        /*
       {
            "bookingid": 1949,
            "booking": {
                "firstname": "Amar",
                "lastname": "Brown",
                "totalprice": 128,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Breakfast"
            }
        }
         */



    }



}
