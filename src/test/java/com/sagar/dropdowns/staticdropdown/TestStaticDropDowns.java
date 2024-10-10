package com.sagar.dropdowns.staticdropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestStaticDropDowns {

    @Test
    public void staticDropdown() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement dropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select staticDropDown = new Select(dropDown);
        staticDropDown.selectByIndex(3);
        Thread.sleep(1000);
        staticDropDown.selectByVisibleText("INR");
        Thread.sleep(1000);
        staticDropDown.selectByValue("AED");
        Thread.sleep(1000);
        staticDropDown.selectByIndex(0);

   }
}
