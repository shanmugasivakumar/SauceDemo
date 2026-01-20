package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartProductName() {
        return driver.findElement(By.className("inventory_item_name")).getText();
    }
}
