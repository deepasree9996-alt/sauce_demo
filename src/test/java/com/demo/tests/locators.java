package com.demo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            // login page
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.name("password")).sendKeys("secret_sauce");
            driver.findElement(By.cssSelector("[data-test='login-button']")).click();
            // verify we are in right page
            String heading = driver.findElement(By.className("title")).getText();
            System.out.println("Page heading" + heading);
            System.out.println("Current url :" + driver.getCurrentUrl());

            // findElement returns a list
            List<WebElement> names = driver.findElements(By.className("inventory_item_name"));
            System.out.println("Products found: " + names.size());
            for (WebElement n : names) {
                System.out.println(" - " + n.getText());
            }
            // add a product and open cart
            driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            String inCart = driver.findElement(
                    By.xpath("//div[@class='inventory_item_name']")).getText();
            System.out.println("In cart: " + inCart);

            Thread.sleep(2000); // only so you can see the result; we remove this in Lesson 3
        } finally {
            driver.quit();
        }

    }
}
