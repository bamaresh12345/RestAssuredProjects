package FromFilesSchemaValidateBodyRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;

public class SchemaValidation {
    public SchemaValidation() throws IOException {
    }

    public String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.JSON_SCHEMA),"UTF-8");
    public String tokenAPIRequestBody = FileUtils.readFileToString(new File(FileNameConstants.JSON_TOKEN_REQUEST_BODY),"UTF-8");
    public String tokenAPIREquestJSONFile = FileUtils.readFileToString(new File(FileNameConstants.JSON_TOKEN_REQUEST_BODY_JSON_FILE),"UTF-8");
    public String putAPIRequestBody = FileUtils.readFileToString(new File(FileNameConstants.JSON_PUT_REQUEST_BODY),"UTF-8");
     String token=""; //data Chaining for token
    int bookingId =0;  //data Chaining for bookingId


    @Test
    public void ReadtxtORJSonFiles() throws IOException {

        System.out.println(jsonSchema.toString());  // PRINTS the txt jsonFile
        System.out.println(tokenAPIREquestJSONFile.toString());  // PRINTS the jsonFile

    }


    @Test
    public void JsutGetBookingIDfromPost() throws IOException {

        Bookingdates bookingdates = new Bookingdates("2023-03-25", "2023-03-03"); // *** IMP
        Booking booking = new Booking("Pojo1", "", 120, true, bookingdates, "breakfast"); // *** IMP bookingdates

        ObjectMapper objmapper = new ObjectMapper();

        String json = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(json);

        Response resp = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(booking)
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .when()
                .post()
                .then()
                .extract()
                .response();

        Assert.assertEquals(resp.getStatusCode(), 200);

        bookingId = resp.path("bookingid"); // will get the latest booking ID

        //*****************ValidteJSONSCHAMA***************************

        String baseURI = "https://restful-booker.herokuapp.com/booking/" + bookingId;

        System.out.println("booking id : " + bookingId);
    }

    @Test
        public void SchamaValidationfromFile()
        {
           Response resp = (Response) RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .baseUri("https://restful-booker.herokuapp.com/booking")
                    .when()
                    .get("/{bookingid}", bookingId)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

            System.out.println("jsonSchema " + jsonSchema);
            System.out.println("SchamaValidationfromFile resp -->" + resp.asString());
            System.out.println("SchamaValidationfromFile resp -->" + resp.prettyPrint());


        }





    @Test
    public void RequestBodayAsFile()
    {
        //token generation
        Response responsetoken =	RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(tokenAPIRequestBody)  // tokenAPIRequestBody  got from file as instance variable
                     .baseUri("https://restful-booker.herokuapp.com/auth")
                .when()
                    .post()
                .then()
                    .extract()
                    .response();

        token = responsetoken.path("token"); // --> this very good use path and id

        System.out.println("token --> " + token);
        System.out.println("RequestBodayAsFile responsetoken -->" + responsetoken.asString());
        System.out.println("RequestBodayAsFile responsetoken -->" + responsetoken.prettyPrint());

    }

    @Test
    public void UpdateBookingfromJSONTEXTFile()

    {
    //update booking
        Response responseupdateBooking =	RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(putAPIRequestBody)
                .header("Cookie","token="+token)
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .when()
                .put("{bookingid}",bookingId)   // bookingId from data chaining
                .then()
                //.assertThat().body(JsonSchemaValidator.matchesJsonSchema("file.json"))
                .extract()
                .response();

        String firstname = responseupdateBooking.path("firstname"); // --> this very good use path and id

        System.out.println("firstname --> " + firstname);

        System.out.println("UpdateBookingfromJSONTEXTFile responseupdateBooking -->" + responseupdateBooking.asString());
        System.out.println("UpdateBookingfromJSONTEXTFile responseupdateBooking -->" + responseupdateBooking.prettyPrint());

    }


    @Test
    public void DOJSONOBJECTVALIDATIONFROMFILE()
    {
        //DO JSONOBJECT VALIDATION FROM FILE
    }

}
