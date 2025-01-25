package PracticeMethods;

import BaseClass.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class StaticAndDynamicTables extends baseClass
{

    @Test
    public void StaticTables()
    {
        WebDriver driver = new ChromeDriver();

        System.out.println("*** am Here***");

        System.out.println("rad data from file " + prop.getProperty("urltestautomationpractice"));
        //driver.get(prop.getProperty("urltestautomationpractice"));
        driver.get(prop.getProperty("urltestautomationpractice"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //find total number of rows in table

//-->      //table[@name='BookTable']/tbody/tr/td -->to remove  /tbody/ --> its mentioned as table[@name='BookTable']//tr **** VERY IMP
        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("Number of rows : " +rows);

        //2nd way to find total number of rows in table
        int rows2 = driver.findElements(By.tagName("tr")).size();
        System.out.println("Number of rows : " +rows2);  // 14 becasue it has multiple tables in a page
        System.out.println("*** am Here***");

        //find the number of table columns
        int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
        System.out.println("Number of rows : " + columns);

        //2nd way to find total number of rows in table
        int columns1 = driver.findElements(By.tagName("th")).size();
        System.out.println("Number of rows : " +columns1);  // 14 becasue it has multiple tables in a page


        //Read data from specific row and column
        String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();//findElemlent* and getText()
        System.out.println("5th row and 1st cell data : " + data);

        //Read data from specific 3rd row and 4th column
        String data2 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[3]//td[4]")).getText();//findElemlent* and getText()
        System.out.println("5th row and 1st cell data : " + data2);

        System.out.println("**********Table Data**********");

        // read all data from the table
        for(int r=2; r<rows; r++)
        {
            for(int c=1; c<columns;c++)
            {
                String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
                System.out.println(value);
            }
        }



        //Print book names whose auther is MUkesh

        for(int r=2; r<rows; r++)
        {
            String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();

            if(authorName.equals("Mukesh"))
            {
                String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
                System.out.println("MUkesh's Book Name : " + bookName);
            }

        }

        //Find the total price of the books  NOTE : getText() always retuns StringVlaue
        int totalPrice=0;
        for(int r=2; r<rows; r++)
        {
            String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
            System.out.println(price);
            totalPrice = totalPrice + Integer.parseInt(price);


        }

        System.out.println("total price of the books : "+totalPrice);


    }
}
