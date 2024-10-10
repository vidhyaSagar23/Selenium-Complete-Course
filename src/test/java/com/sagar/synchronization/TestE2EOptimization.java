package com.sagar.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class TestE2EOptimization {


    @Test
    public void e2e() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String ar[] = { "Beans", "Cucumber", "Tomato"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

//        Thread.sleep(3000);

        addProducts(driver, ar);

        proceedToCheckout(driver);

//        Thread.sleep(3000);

        applyPromocode(driver, wait);

        driver.close();
    }

    public void addProducts(WebDriver driver, String []ar) throws InterruptedException {

//        Returns number of products webelements

        List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));

//        Converting array into arraylist
        List<String> veggies = Arrays.asList(ar);

        int count = veggies.size();

        for (int i=0; i < products.size(); i++){

//            Extracting the vegetable name separately
            String veg = products.get(i).getText().split("-")[0].trim();

            if (veggies.contains(veg)){

//                Clicking add to cart button based on the index
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

//                used sleep method for added button to turn into add to cart
                System.out.println(veg);

//                if all products were selected then it will break the loops
                count--;
                if (count == 0){
                    break;
                }
            }
        }
    }

    public void proceedToCheckout(WebDriver driver){
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
    }

    public void applyPromocode(WebDriver driver, WebDriverWait wait) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("promocode")));
        driver.findElement(By.className("promocode")).sendKeys("rahulshettyacademy");

        driver.findElement(By.className("promoBtn")).click();
        System.out.println("clicked");

//        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("promoInfo")));
        System.out.println(driver.findElement(By.className("promoInfo")).getText());

    }
}
