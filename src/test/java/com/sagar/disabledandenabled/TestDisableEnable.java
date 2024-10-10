package com.sagar.disabledandenabled;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDisableEnable {
    @Test
    public void disableAndEnable(){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://spicejet.com");
//
//        System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'Return Date')]")).isSelected());
//
//        driver.findElement(By.xpath("//div[contains(text(), 'Return Date')]")).click();
//
//        System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'Return Date')]")).isSelected());

//        System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'Return Date')]")).getAttribute("style"));

        System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'Return Date')]")).getCssValue("opacity"));
        driver.findElement(By.xpath("//div[text()='round trip']")).click();
        System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'Return Date')]")).getCssValue("opacity"));

        if(driver.findElement(By.xpath("//div[contains(text(), 'Return Date')]")).getCssValue("opacity").contains("1")){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }
}
