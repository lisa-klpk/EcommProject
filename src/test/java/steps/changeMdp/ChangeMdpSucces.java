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

public class ChangeMdpSucces {

    WebDriver driver = new ChromeDriver();
    MyaccountPage myaccount = new MyaccountPage(driver);

    @Given("je me dirige sur la page My Account")
    public void jeMeDirigeSurLaPageMyAccount() {
        driver.get("https://practice.automationtesting.in/my-account/");

        // Rechercher le bouton "Consent" en utilisant un xpath relatif
        WebElement consentButton = driver.findElement(By.xpath("//p[@class='fc-button-label' and text()='Do not consent']"));
        // Cliquer sur le bouton "Consent"
        if (consentButton.isDisplayed() && consentButton.isEnabled()){
            consentButton.click();
        }
    }

    @When("je me connect")
    public void jeMeConnect() {
        myaccount.loginMdp("nelj@nelj.com","Nelj2024@@");
        myaccount.clickLogin();
    }

    @And("je clique sur Account details")
    public void jeCliqueSurAccountDetails() {
        myaccount.clickAccountDetails();
    }

    @And("je saisie mon mot de passe actuel dans l’espace dedie")
    public void jeSaisieMonMotDePasseActuelDansLEspaceDedie() {
        myaccount.currentMdp("Nelj2024@@");
    }

    @And("je saisie un nouveau mot de passe")
    public void jeSaisieUnNouveauMotDePasse() {
        myaccount.newMdp("Nelj2024@@@");
    }

    @And("je confirme le nouveau mot de passe")
    public void jeConfirmeLeNouveauMotDePasse() {
        myaccount.confirmNewMdp("Nelj2024@@@");
    }

    @And("je clique sur le bouton Save Changes")
    public void jeCliqueSurLeBoutonSaveChanges() {
        myaccount.clickSaveChanges();
    }

    @Then("un message de succès {string} s'affiche")
    public void unMessageDeSuccèsSAffiche(String arg0) {
        String msg= myaccount.confirmChanges();
        System.out.println(msg);
    }


}
