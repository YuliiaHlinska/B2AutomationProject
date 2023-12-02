package com.loop.test.day3_locators_css_xpath;

import com.loop.test.utilities.LoopCampConstans;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;

public class T2_getText_getAttribute {
    public static void main(String[] args) {



    /*

    go to url: https://loopcamp.vercel.app/registration_form.html
    verify header text expected:  Registration form
    verify placeholder attribute value expected - username (could be first name, last name)

     */

        // got to url
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/registration_form.html");

        WebElement headerForForm = driver.findElement(By.tagName("h2"));
        String actualHeaderForForm = headerForForm.getText();

        if(actualHeaderForForm.equals(LoopCampConstans.EXPECTED_HEADER_FOR_FORM)){
            System.out.println("Expected header for forms: \"" + LoopCampConstans.EXPECTED_HEADER_FOR_FORM + "\" , matches actual header: \'" + actualHeaderForForm + "\' = Test PASSED");
        }else{
            System.out.println("Expected header for form: \"" + LoopCampConstans.EXPECTED_HEADER_FOR_FORM + "\", DOES NOT match actual header: \"" + actualHeaderForForm);
            System.err.println("TEST FAILED");
        }

        WebElement userNamePlaceHolder = driver.findElement(By.name("username"));
        String actualPlaceHolderForUsername = userNamePlaceHolder.getAttribute("placeholder");

        if (actualPlaceHolderForUsername.equals(LoopCampConstans.EXPECTED_PLACEHOLDER_USERNAME)){
            System.out.println("Expected header for username: \"" + LoopCampConstans.EXPECTED_HEADER_FOR_FORM + "\" , matches actual header: \'" + actualHeaderForForm + "\' = Test PASSED");
        } else {
            System.out.println("Expected placeholder for username: \"" + LoopCampConstans.EXPECTED_PLACEHOLDER_USERNAME + "\", DOES NOT match aplaceholder: \"" + actualPlaceHolderForUsername);
            System.err.println("TEST FAILED");
        }




    }
}
