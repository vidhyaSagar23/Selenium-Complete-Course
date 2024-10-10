package com.sagar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Flipkart {

    @Test
    public void m1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Fashion']"))).perform();
    }
}
