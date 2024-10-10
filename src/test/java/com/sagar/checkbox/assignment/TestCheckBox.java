package com.sagar.checkbox.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckBox {

    @Test
    public void checkBox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[1]/input")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[1]/input")).isSelected());
        driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[1]/input")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[1]/input")).isSelected());
        Assert.assertEquals(driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input")).size(),3);
        driver.close();
    }
}
