package com.sagar.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestECommerceVeg {

    @Test
    public void e2e() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String ar[] = { "Beans", "Cucumber", "Tomato"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        Thread.sleep(3000);

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
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

//                used sleep method for added button to turn into add to cart
                Thread.sleep(5000);
                System.out.println(veg);

//                if all products were selected then it will break the loops
                count--;
                if (count == 0){
                    break;
                }
            }
        }
        driver.close();
    }
}
