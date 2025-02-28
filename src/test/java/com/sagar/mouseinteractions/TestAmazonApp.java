package com.sagar.mouseinteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAmazonApp {
    @Test
    public void interactions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://www.amazon.com/");

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()='Account & Lists']")));
        WebElement move = driver.findElement(By.xpath("//span[text()='Account & Lists']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(move).build().perform();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        Thread.sleep(5000);

        actions.moveToElement(searchBox).doubleClick().keyDown(Keys.SHIFT).sendKeys("laptop").build().perform();
    }
}
