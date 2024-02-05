package steps.shopping;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShopPage;

public class TextDisplayOnAddToCart {
    WebDriver driver = new ChromeDriver();
    String xpathHtmlForm = "//h3[contains(text(),'HTML5 Forms')]";
    ShopPage sPage = new ShopPage(driver);
    @Given("I open application shop page")
    public void iOpenApplicationShopPage() {
        sPage.openShopPage();
    }

    @When("I select an item")
    public void iSelectAnItem() {
        sPage.addArticleToCart(xpathHtmlForm);
    }

    @And("i add the item to basket")
    public void iAddTheItemToBasket() {
        driver.getCurrentUrl();
    }

    @Then("a text display appears indicating addition to the cart")
    public void aTextDisplayAppearsIndicatingAdditionToTheCart() {
        sPage.findTextDisplayForAddToCart();
    }
}
