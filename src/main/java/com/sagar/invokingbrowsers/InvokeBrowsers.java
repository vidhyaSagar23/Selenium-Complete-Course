package com.sagar.invokingbrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeBrowsers {
    public static void Main(String[] args) {
       invokeUsingDriverManager();
       manuallyInvoke();
       System.out.println("Executed Successfully");
    }

    public static void invokeUsingDriverManager(){
        WebDriver driver = new ChromeDriver();
        driver.close();
        System.out.println("Invoked using Driver Manager");
    }

    public static void manuallyInvoke(){
        System.setProperty("webdriver.chrome.driver", "C:\\SAGAR WORK\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.findElement(By.id("")).sendKeys("");
        driver.close();
        System.out.println("Manually Invoked");
    }
}
