package com.sagar.jspopup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestJSPopUp {

    @Test
    public void jsPopUp(){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys("sagar");

        driver.findElement(By.id("alertbtn")).click();

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();

        driver.close();
    }
}
