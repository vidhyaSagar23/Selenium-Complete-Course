package com.sagar.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAssignment {
    @Test
    public void suggestiveDropDown(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Actions actions =new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[@class='ui-menu-item']/div[text()='India']"))).build().perform();
        actions.doubleClick(driver.findElement(By.xpath("//li[@class='ui-menu-item']/div[text()='India']"))).build().perform();
        String s = driver.findElement(By.xpath("//input[@id='autocomplete']")).getAttribute("value");
        System.out.println(s);
    }
}
