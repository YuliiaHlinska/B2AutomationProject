package com.loop.test.day7_windows;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T0_iFrame_practice extends TestBase {
    /*
        go to - https://loopcamp.vercel.app/nested-frames.html
        validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

         */
    @Test
    public void left(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");



        //"LEFT"
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//*[contains(text(), 'LEFT')]"));

        String actualLeft = left.getText();
        Assert.assertEquals(actualLeft.trim(), "LEFT"); // compare actual and expected

        //"BOTTOM"
        driver.switchTo().defaultContent(); // top isn't a parent here, you need to go to HTML main frame
        driver.switchTo().frame("frame-bottom");
    }

    @Test
    public void right(){

    }

    @Test
    public void middle(){

    }
    @Test
    public void bottom(){

    }

}
