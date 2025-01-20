package FromFilesSchemaValidateBodyRequest;

public class Bookingdates {

    public String checkin;
    public String checkout;

    //MUST Constructor else it will fail for mapper
    public Bookingdates() {

    }

    public Bookingdates(String checkindate, String checkoutdate) {

        setCheckin(checkindate);  // ** SET is IMP else have set explicitly
        setCheckout(checkoutdate);  // ** SET is IMP  else have set explicitly
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
