package steps.shopping;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShopPage;
import java.util.concurrent.TimeUnit;

public class DisplayViewBasket {
    WebDriver driver = new ChromeDriver();

    String xpathFunctionalProg = "//a[@data-product_id='170']";
    String xpathViewFunctionalProg = "//a[@data-product_id='170']/following-sibling::a[contains(text(),'View Basket')]";
    ShopPage sPage = new ShopPage(driver);
    @Given("I open shop page")
    public void iOpenShopPage() {
        sPage.openShopPage();
    }

    @When("I click ADD To BASKET button below an article")
    public void iClickADDToBASKETButtonBelowAnArticle() {
        sPage.addArticleToCart(xpathFunctionalProg);
    }

    @Then("VIEW BASKET link appears below the article")
    public void viewBASKETLinkAppearsBelowTheArticle() {
        sPage.verifyViewBasketLink(xpathViewFunctionalProg);

    }
}
