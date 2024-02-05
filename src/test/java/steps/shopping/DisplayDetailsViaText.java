package steps.shopping;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShopPage;

public class DisplayDetailsViaText {
    WebDriver driver = new ChromeDriver();
    ShopPage sPage = new ShopPage(driver);
    @Given("user opens page  shopping")
    public void userOpensPageShopping() {
        sPage.openShopPage();
    }

    @And("user clicks on text link of an article")
    public void userClicksOnTextLinkOfAnArticle() {
        sPage.clickOnLabelArticle();
    }

    @Then("details are displayed")
    public void detailsAreDisplayed() {
        sPage.verifyDisplayDetailsOfArticle();
    }
}
