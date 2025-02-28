package com.sagar.childwindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Dynamic {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open parent page
        driver.get("https://the-internet.herokuapp.com/windows");

        // Store the initial window handle (parent)
        String parentWindow = driver.getWindowHandle();

        // Click to open the first child window
        driver.findElement(By.xpath("//a[contains(text(), 'Click Here')]")).click();

        // Switch to the first child window dynamically
        String firstChildWindow = switchToNewWindow(driver, parentWindow);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        System.out.println("First Child Window Text: " + driver.findElement(By.tagName("h3")).getText());

        // Switch back to the parent window
        driver.switchTo().window(parentWindow);
        System.out.println("Parent Window Text: " + driver.findElement(By.tagName("h3")).getText());

        // Click again to open a new child window dynamically
        driver.findElement(By.xpath("//a[contains(text(), 'Click Here')]")).click();

        // Switch to the second child window dynamically
        String secondChildWindow = switchToNewWindow(driver, parentWindow);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        System.out.println("Second Child Window Text: " + driver.findElement(By.tagName("h3")).getText());

        // Close all child windows and switch back to the parent
        driver.close(); // Close the second child
        driver.switchTo().window(firstChildWindow);
        driver.close(); // Close the first child
        driver.switchTo().window(parentWindow);

        // Continue with the parent window
        driver.quit(); // Quit the browser if done
    }

    public static String switchToNewWindow(WebDriver driver, String currentWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                return window;
            }
        }
        throw new RuntimeException("No new window found to switch to!");
    }
}
