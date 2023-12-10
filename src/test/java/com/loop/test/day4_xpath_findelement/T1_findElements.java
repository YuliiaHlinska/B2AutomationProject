package com.loop.test.day4_xpath_findelement;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T1_findElements {

    public static void main(String[] args) {

       /*
        1- Open a chrome browser
        2- Go to: https://www.nba.com
        3- Locate all the links in the page.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.nba.com");

        //3- Locate all the links in the page.

        List<WebElement> nbaLinks = driver.findElements(By.tagName("a")); // by tagname
        System.out.println("nbalinks.size = "  + nbaLinks.size());

        List<WebElement> nbaXpath = driver.findElements(By.xpath("//a")); // By xpath
        System.out.println("nbalinks.size = "  + nbaXpath.size());


        for (WebElement nbaLink: nbaLinks) {
            if(!nbaLink.getText().equals("")){
                System.out.println("nbaLink " + nbaLink.getText()); // find each link text of links
                System.out.println("nbaLink " + nbaLink.getAttribute("href")); // find the value of link, where href -   
            }
        }

        for (int i = 0; i < nbaLinks.size(); i++) {
            if(!nbaLinks.get(i).getText().equals("")){
                System.out.println("nba link = " + nbaLinks.get(i).getText());
                System.out.println("nba link = " + nbaLinks.get(i).getAttribute("href"));
            }
        }



    }
}
