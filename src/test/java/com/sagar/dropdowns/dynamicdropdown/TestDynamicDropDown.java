package com.sagar.dropdowns.dynamicdropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestDynamicDropDown {
    @Test
    public void dropDown() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://spicejet.com");
        driver.findElement(By.xpath("//div[contains(text(), 'From')]/following-sibling::div/input")).sendKeys("ch");
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.xpath("//div[text()='Cities']/parent::div/following-sibling::div/div/div/div/div"));
//        List<WebElement> list = driver.findElements(By.xpath("//div[text()='Cities']/parent::div/following-sibling::div/div/div[2]/div"));
        System.out.println(list.isEmpty());
        for (WebElement e:list){
            if (e.getText().equals("Chennai")){
                System.out.println(e.getText());
                e.click();
                break;
            }
        }
    }


    @Test
    public void dropDownWithoutTraversing() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://spicejet.com");
        driver.findElement(By.xpath("//div[contains(text(), 'From')]/following-sibling::div/input")).sendKeys("ch");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Chennai']")).click();
    }


    @Test
    public void dropDownUsingExplicitWait() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://spicejet.com");

        driver.findElement(By.xpath("//div[contains(text(), 'From')]/following-sibling::div/input")).sendKeys("c");

        // Wait for the dropdown list to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[text()='Cities']/parent::div/following-sibling::div/div/div/div/div")
        ));

        System.out.println(list.isEmpty());
        for (WebElement e : list) {
            if (e.getText().equals("Chennai")) {
                System.out.println(e.getText());
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();  // Ensure it's clickable
                break;
            }
        }
    }
}
