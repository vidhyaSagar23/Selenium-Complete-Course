package com.sagar.HttpProxies;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class TestHandleChromeOptionsProxies {
// TODO Auto-generated method stub
    @Test
    public void handleChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy", proxy);
        Map<String, Object> prefs = new HashMap<String, Object>();
        options.setExperimentalOption("prefs", prefs);
// FirefoxOptions options1 = new FirefoxOptions();
// options1.setAcceptInsecureCerts(true);
// EdgeOptions options2 = new EdgeOptions();
        options.setAcceptInsecureCerts(true);
        System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
