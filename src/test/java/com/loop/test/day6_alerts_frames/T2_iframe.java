package com.loop.test.day6_alerts_frames;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class T2_iframe extends TestBase {
            /*
    1- Open a chrome browser
    2- Go to: https://loopcamp.vercel.app/iframe.html
    3- Clear text from comment body
    4- Type "Loop Academy" in comment body
    5- Verify "Loop Academy" text is written in comment body
    6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed

     */
@Test
    public void iFrameTest(){
    driver.get("https://loopcamp.vercel.app/iframe.html");

    //by web element
//    WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
//    driver.switchTo().frame(iframe);
//    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"))); the same like 29

    //by Id

//    driver.switchTo().frame("mce_0_ifr");

    //Byindex
    driver.switchTo().frame(0);


    WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
    textBox.clear();
    textBox.sendKeys("Loop Academy");
    driver.switchTo().defaultContent(); // will take us directly to the main html
    // driver.switchTo().parentFrame(); // this will take us to the parent frame
    //WebElement poweredBy = driver.findElement(By.xpath("//div[text()='Powered by ']"));

    WebElement heading = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame containing')]"));
    String actual = heading.getText();
    String expected = "An iFrame containing the TinyMCE WYSIWYG Editor";
    assertEquals(actual, expected, "actual does not match expected");

}

//@Test
//    public void amazonIframe(){
//    driver.get("https://www.amazon.com/");
//    List<WebElement> iframes = new ArrayList<>();
//    iframes = driver.findElements(By.xpath());
//}



}
