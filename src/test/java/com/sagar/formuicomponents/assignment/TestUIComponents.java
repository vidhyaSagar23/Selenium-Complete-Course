package com.sagar.formuicomponents.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestUIComponents {

    @Test
    public void uiComponents(){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("sagar");

        driver.findElement(By.xpath("(//input[@name='email'])")).sendKeys("sagar@gmail.com");

        driver.findElement(By.xpath("(//input[@type='password'])")).sendKeys("Sagar123!");

        driver.findElement(By.id("exampleCheck1")).click();

        Select gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));

        gender.selectByVisibleText("Male");

        driver.findElement(By.id("inlineRadio1")).click();

        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("2001-08-13");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
    }
}
