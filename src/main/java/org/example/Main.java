package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();

        String userName = "performance_glitch_user";
        String pass = "secret_sauce";
        login(driver, userName, pass);
    }

    public static void login(ChromeDriver driver, String userName, String pass) throws InterruptedException
    {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(pass);
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
//        String next = "//*[@class='']"
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"about_sidebar_link\"]"))).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        WebElement sort = driver.findElement((By.className("product_sort_container")));
        Select selectSort = new Select(sort);
        selectSort.selectByValue("hilo");
        Thread.sleep(1000);
        driver.findElement(By.id("item_4_title_link")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("back-to-products")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("shopping_cart_container")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("first-name")).sendKeys("Rifat");
        driver.findElement(By.id("last-name")).sendKeys("alam");
        driver.findElement(By.id("postal-code")).sendKeys("1209");
        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("finish")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("back-to-products")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(1000);
        driver.close();
    }
}