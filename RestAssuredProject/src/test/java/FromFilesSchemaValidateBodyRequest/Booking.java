package FromFilesSchemaValidateBodyRequest;

public class Booking {

    public String firstname;

    public String lastname;
    public int totalprice;
    public boolean depositpaid;
    public Bookingdates bookingdates;
    public String additionalneeds;


    //MUST Constructor else it will fail for mapper
    public Booking() {

    }

    public Booking(String ftname, String lname, int price, boolean deposit,
                   Bookingdates bookingdatesnew, String additionalneeds1)
    {

        setFirstname(ftname);  // ** SET is IMP else have set explicitly
        setLastname(lname);    // ** SET is IMP else have set explicitly
        setTotalprice(price);   // ** SET is IMP else have set explicitly
        setDepositpaid(deposit);    // ** SET is IMP else have set explicitly
        setBookingdates(bookingdatesnew);
        setAdditionalneeds(additionalneeds1);
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public boolean isDepositpaid() {
        return depositpaid;
    }
    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }
    public Bookingdates getBookingdates() {
        return bookingdates;
    }
    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }
    public String getAdditionalneeds() {
        return additionalneeds;
    }
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

}
