package steps.shopping;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShopPage;

public class FilterByPrice {
    WebDriver driver = new ChromeDriver();
    ShopPage sPage = new ShopPage(driver);
    @Given("I am opening the shop page")
    public void iAmOpeningTheShopPage() {
        sPage.openShopPage();
    }

    @When("I choose a value in FILTER BY PRICE")
    public void iChooseAValueInFILTERBYPRICE() {
        sPage.setFilterValues();
    }

    @And("I click on the button FILTER")
    public void iClickOnTheButtonFILTER() {
        sPage.clickFilterButton();
    }

    @Then("the filtered list appears")
    public void theFilteredListAppears() {
        sPage.verifyFilteredList();
    }
}
