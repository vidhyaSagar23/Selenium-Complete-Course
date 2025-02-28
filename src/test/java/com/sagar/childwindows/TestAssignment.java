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

public class TestAssignment {
    @Test
    public void childWindow(){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//a[contains(text(), 'Click Here')]")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parent = iterator.next();
        String child = iterator.next();
        driver.switchTo().window(child);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("h3")));
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        driver.switchTo().window(parent);
        System.out.println(driver.findElement(By.tagName("h3")).getText());


    }
}
