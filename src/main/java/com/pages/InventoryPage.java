package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String addHighestPriceProductToCart() {

        List<WebElement> products = driver.findElements(By.className("inventory_item"));

        double highestPrice = 0.0;
        WebElement highestProduct = null;

        for (WebElement product : products) {

            String priceText = product
                    .findElement(By.className("inventory_item_price"))
                    .getText()
                    .replace("$", "");

            double price = Double.parseDouble(priceText);

            if (price > highestPrice) {
                highestPrice = price;
                highestProduct = product;
            }
        }

        String productName = highestProduct
                .findElement(By.className("inventory_item_name"))
                .getText();

        highestProduct.findElement(By.tagName("button")).click();

        return productName;
    }

    public void openCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    public int getCartItemCount() {
        List<WebElement> badge = driver.findElements(By.className("shopping_cart_badge"));
        return badge.isEmpty() ? 0 : Integer.parseInt(badge.get(0).getText());
    }
}
