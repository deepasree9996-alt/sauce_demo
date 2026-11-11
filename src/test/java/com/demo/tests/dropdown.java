package com.demo.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.name("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            Select drop = new Select(
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container"))));
            drop.selectByVisibleText("Price (low to high)");
            System.out.println("Sorted by: " + drop.getFirstSelectedOption().getText());
            System.out.println("First price: " +
                    driver.findElement(By.className("inventory_item_price")).getText());

        } finally {
            driver.quit();
        }

    }

}
