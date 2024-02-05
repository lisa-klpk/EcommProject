package steps.shopping;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShopPage;

public class VerifyNumOfItemsField {
    WebDriver driver = new ChromeDriver();
    String xpathHtmlForm = "//h3[contains(text(),'HTML5 Forms')]";
    ShopPage sPage = new ShopPage(driver);
    @Given("i open shop page")
    public void iOpenShopPage() {
        sPage.openShopPage();
    }

    @When("i select a product")
    public void iSelectAProduct() {
        sPage.addArticleToCart(xpathHtmlForm);
    }

    @And("i do add to basket")
    public void iDoAddToBasket() {
        driver.getCurrentUrl();
    }

    @Then("the page contains a field to specify number of items needed")
    public void thePageContainsAFieldToSpecifyNumberOfItemsNeeded() {
        System.out.println("test");
        sPage.verifyQuantityField();
    }
}
