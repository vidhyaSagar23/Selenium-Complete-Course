package com.sagar.realtimeexcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class E2E {
    @Test
    public void e2e(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption2")).click();
        String word = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText();
        Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
        select.selectByVisibleText(word);
        driver.findElement(By.id("name")).sendKeys(word);
        driver.findElement(By.id("alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains(word), word +" is not present");
    }
}
