package stepDefinitions;

import com.browsers.DriverFactory;
import com.pages.CartPage;
import com.pages.InventoryPage;
import com.pages.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class InventorySteps {

    WebDriver driver;

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;

    String expectedProductName;

    @Given("user is logged in")
    public void user_is_logged_in() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        loginPage.do_login("standard_user", "secret_sauce");
    }

    @When("user adds the highest priced product to the cart")
    public void add_highest_price_product() {
        inventoryPage = new InventoryPage(driver);
        expectedProductName = inventoryPage.addHighestPriceProductToCart();
    }

    @Then("cart should show 1 item")
    public void verify_cart_count() throws InterruptedException {
        Assert.assertEquals(inventoryPage.getCartItemCount(), 1);
    }

    @Then("highest priced product should be present in the cart")
    public void verify_product_in_cart() {
        inventoryPage.openCart();
        cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartProductName(), expectedProductName);
    }
}
