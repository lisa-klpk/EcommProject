package steps.shopping;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShopPage;

public class FilterByTheme {
    WebDriver driver = new ChromeDriver();
    ShopPage sPage = new ShopPage(driver);
    @Given("user opens SHOP page")
    public void userOpensSHOPPage() {
        sPage.openShopPage();
    }

    @When("user chooses a PRODUCTS CATEGORIE")
    public void userChoosesAPRODUCTSCATEGORIE() {
        sPage.chooseProductCategorie();
    }

    @Then("Filtered list of articles appears")
    public void filteredListOfArticlesAppears() {
    }
}

