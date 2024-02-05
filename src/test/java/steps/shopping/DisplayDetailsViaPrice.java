package steps.shopping;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShopPage;

public class DisplayDetailsViaPrice {
    WebDriver driver = new ChromeDriver();
    ShopPage sPage = new ShopPage(driver);
    @Given("user open shop page")
    public void userOpenShopPage() {
        sPage.openShopPage();
    }

    @And("user clicks on price of an article")
    public void userClicksOnPriceOfAnArticle() {
        sPage.selectArticleByPrice();
    }

    @Then("details of the article is displayed")
    public void detailsOfTheArticleIsDisplayed() {
        sPage.verifyDisplayDetailsOfArticle();
    }
}
