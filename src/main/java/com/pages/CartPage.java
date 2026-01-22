package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartProductName() {
        return driver.findElement(By.xpath("//div[@class=\"inventory_list\"]//div[4]//div[@class=\"inventory_item_name \"]")).getText();
    }
}
