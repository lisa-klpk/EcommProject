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

public class ChangeMdpFail2 {

    WebDriver driver = new ChromeDriver();
    MyaccountPage myaccount = new MyaccountPage(driver);

    @Given("le user va sur la page “My account”")
    public void leUserVaSurLaPageMyAccount() {
        driver.get("https://practice.automationtesting.in/my-account/");

        // Rechercher le bouton "Consent" en utilisant un xpath relatif
        WebElement consentButton = driver.findElement(By.xpath("//p[@class='fc-button-label' and text()='Do not consent']"));
        // Cliquer sur le bouton "Consent"
        if (consentButton.isDisplayed() && consentButton.isEnabled()){
            consentButton.click();
        }
    }

    @When("le user se connecte")
    public void leUserSeConnecte() {
        myaccount.loginMdp("nelj@nelj.com","Nelj2024@@");
        myaccount.clickLogin();
    }

    @And("le user clique sur le lien “Account details”")
    public void leUserCliqueSurLeLienAccountDetails() {
        myaccount.clickAccountDetails();
    }

    @And("le user saisi mon mot de passe actuel dans l’espace dédié")
    public void leUserSaisiMonMotDePasseActuelDansLEspaceDédié() {
        myaccount.currentMdp("Nelj2024@@");
    }

    @And("le user saisi un nouveau mot de passe")
    public void leUserSaisiUnNouveauMotDePasse() {
        myaccount.newMdp("Nelj2024@@@");
    }

    @And("le user confirme avec un mot de passe erroné")
    public void leUserConfirmeAvecUnMotDePasseErroné()  {
        myaccount.confirmNewMdp("Nelj2024555");
    }

    @And("le user clique sur Save Changes")
    public void leUserCliqueSurSaveChanges() {
        myaccount.clickSaveChanges();
    }

    @Then("un message d’erreur {string} s’affiche")
    public void unMessageDErreurSAffiche(String arg0) {
        String msg= myaccount.confirmError2();
        System.out.println(msg);
    }



}
