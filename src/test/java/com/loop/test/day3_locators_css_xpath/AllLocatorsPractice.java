package com.loop.test.day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {

    public static void main(String[] args) {
        //setup the driver
        WebDriverManager.chromedriver().setup();

        //create driver object
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // navigate to
        driver.get("https://loopcamp.vercel.app/registration_form.html");

        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Loop");

        WebElement lasttname = driver.findElement(By.name("lastname"));
        lasttname.sendKeys("Academy");

        //this will return ud 3 elements, and always will cleck the first one,
        // thats why we should pay attantion
        WebElement gender = driver.findElement(By.name("gender"));
        gender.click();



    }
}
