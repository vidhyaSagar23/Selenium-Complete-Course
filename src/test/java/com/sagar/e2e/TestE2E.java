package com.sagar.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestE2E {

    @Test
    public void e2e() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://spicejet.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).click();

        driver.findElement(By.xpath("//div[text()='Chennai']")).click();

        driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();

        WebElement date = driver.findElement(By.xpath("//div[text()='Departure Date']"));

        Actions actions = new Actions(driver);

        actions.contextClick(date);
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-156aje7 r-y47klf r-1phboty r-1d6rzhh r-1pi2tsx r-1777fci r-13qz1uu']")).click();

        if(driver.findElement(By.xpath("//div[contains(text(), 'Return Date')]")).getCssValue("opacity").contains("1")){
            Assert.assertTrue(false);
        }
        else{
            Assert.assertTrue(true);
        }

        driver.findElement(By.xpath("//div[text()='Passengers']/parent::div")).click();
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.xpath("//div[text()='Adult']/parent::div/following-sibling::div/div[3]")).click();
        }

        driver.close();
    }
}
