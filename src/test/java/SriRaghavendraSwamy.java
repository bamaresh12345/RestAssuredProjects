import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class SriRaghavendraSwamy {

    @Test
    public void launchheadlessBrowser() {

       Playwright pt = Playwright.create();
        Browser browser = pt.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.gururaghavendra1.org/");
        System.out.println(page.title());
    }
}
