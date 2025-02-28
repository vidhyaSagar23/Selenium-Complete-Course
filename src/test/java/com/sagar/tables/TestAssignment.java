package com.sagar.tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAssignment {
    @Test
    public void tables(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int rows = driver.findElements(By.xpath("(//table[@id='product']/tbody)[1]/tr")).size();
        int cols = driver.findElements(By.xpath("(//table[@id='product'])[1]/tbody/tr/th")).size();
        System.out.println("Rows :" + rows);
        System.out.println("Columns :" + cols);
        for (WebElement e: driver.findElements(By.xpath("((//table[@id='product'])[1]/tbody/tr)[3]/td"))){
            System.out.println(e.getText());
        }
    }
}
