package steps.shopping;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.ShopPage;

public class VerifyIconAddToCart {
    WebDriver driver = new ChromeDriver();
    CartPage cPage;
    ShopPage sPage = new ShopPage(driver);
    @Given("I open the shopping page")
    public void iOpenTheShoppingPage() {
        sPage.openShopPage();
    }

    @When("I click on cart icon")
    public void iClickOnCartIcon() {
        cPage = sPage.openCart();
    }

    @Then("cart page opens")
    public void cartPageOpens() {
        cPage.verifyCartContent();
    }
}
