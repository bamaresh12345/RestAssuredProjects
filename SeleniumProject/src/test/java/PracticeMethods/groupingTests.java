package PracticeMethods;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class groupingTests {

    public WebDriver driver;


    @Test(groups = {"sanity"})
    public void test1() throws InterruptedException {

        System.out.println("Hello Test1  \"sanity\" " + Thread.currentThread());

    }


    @Test(groups= {"sanity","smoke"})
    public void test2() throws InterruptedException {

        System.out.println("Hello Test2  \"sanity\",\"smoke\" " + Thread.currentThread());

    }

    @Test(groups= {"regression"})
    public void test3() throws InterruptedException {

        System.out.println("Hello Test2  \"regression\" " + Thread.currentThread());

    }

    @Test(groups= {"sanity","regression"})
    public void test4() throws InterruptedException {

        System.out.println("Hello Test4 \"sanity\",\"regression\" " + Thread.currentThread());

    }

}
