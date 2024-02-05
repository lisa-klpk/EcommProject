package steps.logout;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MyaccountPage;

public class Logout {

    WebDriver driver = new ChromeDriver();
    MyaccountPage myaccount = new MyaccountPage(driver);

    @Given("je me dirige sur la page “My account”")
    public void jeMeDirigeSurLaPageMyAccount() {
        driver.get("https://practice.automationtesting.in/my-account/");

        // Rechercher le bouton "Consent" en utilisant un xpath relatif
        WebElement consentButton = driver.findElement(By.xpath("//p[@class='fc-button-label' and text()='Do not consent']"));
        // Cliquer sur le bouton "Consent"
        if (consentButton.isDisplayed() && consentButton.isEnabled()){
            consentButton.click();
        }
    }

    @When("je saisis Login et mot de passe")
    public void jeSaisisLoginEtMotDePasse() {
        myaccount.loginMdp("nelj@nelj.com","Nelj-2024");
    }

    @And("je clique sur bouton Login")
    public void jeCliqueSurBoutonLogin() {
        myaccount.clickLogin();
    }

    @And("je clique sur le lien “Logout”")
    public void jeCliqueSurLeLienLogout() {
        myaccount.clickLogout();
    }

    @Then("je suis déconnecté de mon espace")
    public void jeSuisDéconnectéDeMonEspace() {
    }


}
