package steps.shopping;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShopPage;

public class DisplayDetailsViaIcon {
    WebDriver driver = new ChromeDriver();
    ShopPage sPage = new ShopPage(driver);

    @Given("user opens shopping page")
    public void userOpensShoppingPage() {
        sPage.openShopPage();
    }

    @And("user clicks on the image of the article")
    public void userClicksOnTheImageOfTheArticle() {
        sPage.selectArticleViaImage();
    }

    @Then("article details displayed")
    public void articleDetailsDisplayed() {
        sPage.verifyDisplayDetailsOfArticle();
    }
}
