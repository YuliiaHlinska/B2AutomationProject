package com.loop.test.day6_alerts_frames;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Practive_during_Class extends TestBase {
    @Test
    public void informationAlert() {
        driver.get("https://loopcamp.vercel.app/dropdown.html");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

        dropdown.getFirstSelectedOption().getText();

        List<String> list = new ArrayList<>();


        List<WebElement> listWebElements = dropdown.getOptions();

        for (WebElement listWebElement : listWebElements) {
            list.add(listWebElement.getText());
        }


        dropdown.selectByIndex(1);
        Assert.assertTrue(dropdown.isMultiple());
    }
}
