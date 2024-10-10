package com.sagar.dropdowns.staticdropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestLoopingDropdowns {
    @Test
    public void dropDown(){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://spicejet.com");
        driver.findElement(By.xpath("//div[text()='Passengers']/parent::div")).click();
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.xpath("//div[text()='Adult']/parent::div/following-sibling::div/div[3]")).click();
        }
    }
}
