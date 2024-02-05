package steps.shopping;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.ShopPage;

public class AddToCartAndVerify {
    WebDriver driver = new ChromeDriver();
    String xpathSeleniumRuby = "//a[@data-product_id=\'160\']";
    ShopPage shop = new ShopPage(driver);
    CartPage cPage;

    @Given("J’ouvre le page ‘Shop’")
    public void jOuvreLePageShop() {
       shop.openShopPage();
    }

    @When("je clique ‘ADD TO BASKET’ de l'article Selenium Ruby")
    public void jeCliqueADDTOBASKETDeLArticleSeleniumRuby() {
        shop.addArticleToCart(xpathSeleniumRuby);
    }

    @And("Je clique sur l'icône panier")
    public void jeCliqueSurLIcônePanier()  {

        cPage = shop.openCart();
    }

    @Then("l'article est ajouté au panier")
    public void lArticleEstAjoutéAuPanier() {
        String productName = "Selenium Ruby";
        cPage.verifyCartContent(productName);
    }
}
