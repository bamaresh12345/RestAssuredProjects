package Test2FrameWork.Tests;

import SeralizationANDDeSeralization.Bookingdates;
import Test2FrameWork.EndPoints.BookingEndPoints;
import Test2FrameWork.PayLoad.Booking;
import Test2FrameWork.PayLoad.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingTests {

    Faker faker;
    Booking bookingPayload;
    int bookingid =0;
    @BeforeClass
    public void setUpData()
    {

        faker = new Faker();
        bookingPayload = new Booking();

        bookingPayload.setFirstname(faker.name().firstName());
        bookingPayload.setLastname(faker.name().lastName());
        bookingPayload.setTotalprice(faker.number().numberBetween(10,20));
        bookingPayload.setDepositpaid(true);
        bookingPayload.setAdditionalneeds("breakfast");
        bookingPayload.setBookingdates(new Bookingdates("2018-01-01","2019-01-01"));


    }

    @Test(priority = 0)
    public static void gerateToken()
    {
        BookingEndPoints bt = new BookingEndPoints();

        bt.gerateTokenNew();
    }

    @Test(priority = 0)
    public void testPostBooking()
    {
        Response resp = BookingEndPoints.createBooking(bookingPayload);
        resp.then().log().all();

        Assert.assertEquals(resp.getStatusCode(),200);
        System.out.println(resp.prettyPrint());

        bookingid = resp.getBody().path("bookingid");

        System.out.println("bookingid--> " + bookingid);

    }



    @Test(priority = 1)
    public void testGetBooking()
    {
        System.out.println("bookingid--> " + bookingid);
        Response resp = BookingEndPoints.getBooking(bookingid);
        resp.then().log().all();

        Assert.assertEquals(resp.getStatusCode(),200);
        System.out.println(resp.prettyPrint());

    }

    @Test(priority = 3)
    public void testUpdateBooking()
    {

        bookingPayload.setAdditionalneeds("lunch");
        Response resp = BookingEndPoints.UpdateBooking(bookingPayload,bookingid);
        resp.then().log().all();

        Assert.assertEquals(resp.getStatusCode(),200);
        System.out.println(resp.prettyPrint());



    }

    @Test(priority = 4)
    public void testDeleteBooking()
    {


        Response resp = BookingEndPoints.deleteBooking(bookingid);
        resp.then().log().all();

        Assert.assertEquals(resp.getStatusCode(),201);
        System.out.println(resp.prettyPrint());



    }
}
