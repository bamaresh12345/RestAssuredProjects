package BodyFromStringFormat;

public class BookingTemplateAPI {

    public String createBooking(String firstName,int totalprice)
    {

        String body = "{\r\n"
                + "    \"firstname\" : \"%s\",\r\n"
                + "    \"lastname\" : \"Brown\",\r\n"
                + "    \"totalprice\" : %d,\r\n"
                + "    \"depositpaid\" : true,\r\n"
                + "    \"bookingdates\" : {\r\n"
                + "        \"checkin\" : \"2018-01-01\",\r\n"
                + "        \"checkout\" : \"2019-01-01\"\r\n"
                + "    },\r\n"
                + "    \"additionalneeds\" : \"Breakfast\"\r\n"
                + "}";

        return String.format(body, firstName,totalprice);
    }
}
