package steps.changeMdp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MyaccountPage;

public class ChangeMdpFail1 {

    WebDriver driver = new ChromeDriver();
    MyaccountPage myaccount = new MyaccountPage(driver);

    @Given("je clique sur la page My Account")
    public void jeCliqueSurLaPageMyAccount() {
        driver.get("https://practice.automationtesting.in/my-account/");

        // Rechercher le bouton "Consent" en utilisant un xpath relatif
        WebElement consentButton = driver.findElement(By.xpath("//p[@class='fc-button-label' and text()='Do not consent']"));
        // Cliquer sur le bouton "Consent"
        if (consentButton.isDisplayed() && consentButton.isEnabled()){
            consentButton.click();
        }
    }

    @When("je me log")
    public void jeMeConnecte() {
        myaccount.loginMdp("nelj@nelj.com","Nelj2024@@");
        myaccount.clickLogin();
    }

    @And("je me dirige sur Account details")
    public void jeMeDirigeSurAccountDetails() {
        myaccount.clickAccountDetails();
    }

    @And("je saisie un mot de passe errone dans l’espace dedie")
    public void jeSaisieUnMotDePasseErroneDansLEspaceDedie() {
        myaccount.currentMdp("Nelj202444");
    }

    @And("je saisis un nouveau mot de passe")
    public void jeSaisisUnNouveauMotDePasse() {
        myaccount.newMdp("Nelj2024555");
    }

    @And("je saisis la confirmation du mot de passe")
    public void jeSaisisLaConfirmationDuMotDePasse() {
        myaccount.confirmNewMdp("Nelj2024555");
    }

    @And("je clique sur Save Changes")
    public void jeCliqueSurSaveChanges() {
        myaccount.clickSaveChanges();
    }

    @Then("un message d’erreur s’affiche {string}")
    public void unMessageDErreurSAffiche(String arg0) {
        String msg= myaccount.confirmError();
        System.out.println(msg);
    }



}
