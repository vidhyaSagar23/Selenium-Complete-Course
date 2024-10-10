package com.sagar.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestAssignment {

    @Test
    public void assignment() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        login(driver, "rahulshettyacademy","learning");
        selectProduct(driver, wait);
    }

    public void login(WebDriver driver, String userName, String password) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='admin']")).click();
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
    }

    public void selectProduct(WebDriver driver, WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Add ']")));
        List<WebElement> addButtons = driver.findElements(By.xpath("//button[text()='Add ']"));

        for (WebElement button:addButtons){
             button.click();
        }
        driver.findElement(By.xpath("//a[contains(text(),' Checkout')]")).click();
    }
}
