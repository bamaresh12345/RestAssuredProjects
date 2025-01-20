package Test2FrameWork.PayLoad;

public class tokenPayLoad {




    public String CreatetokenPayLoad()
    {

        String json ="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        return String.format(json);
    }
}
