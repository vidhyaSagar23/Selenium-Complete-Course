package com.sagar.childwindows;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

 class TestChildWindows {
    @Test
    public void childWindows(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.cssSelector("a[class='blinkingText']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();

        String parent  = iterator.next();
        String child = iterator.next();
        driver.switchTo().window(child);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("p[class='im-para red']")));
        String word = driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
        String email = word.split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parent);
        driver.findElement(By.id("username")).sendKeys(email);

    }
}
