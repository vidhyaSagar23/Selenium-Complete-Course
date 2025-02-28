package com.sagar.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestIFrame {
    @Test
    public void handleIframe(){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Actions actions = new Actions(driver);

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

        actions.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();

    }
}
