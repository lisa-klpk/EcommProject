package steps.shopping;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShopPage;

public class DisplayProducts {
    WebDriver driver = new ChromeDriver();
    ShopPage sPage = new ShopPage(driver);

    @Given("I open the shop page")
    public void iOpenTheShopPage() {
        sPage.openShopPage();
    }

    @Then("page display contains articles")
    public void pageDisplayContainsArticles() {
        sPage.verifyShopItemsDisplay();
    }
}
