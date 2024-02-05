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

public class CheckAccount {

    WebDriver driver = new ChromeDriver();
    MyaccountPage myaccount = new MyaccountPage(driver);

    @Given("je vais sur la page “My account”")
    public void jeVaisSurLaPageMyAccount() {
        driver.get("https://practice.automationtesting.in/my-account/");

        // Rechercher le bouton "Consent" en utilisant un xpath relatif
        WebElement consentButton = driver.findElement(By.xpath("//p[@class='fc-button-label' and text()='Do not consent']"));
        // Cliquer sur le bouton "Consent"
        if (consentButton.isDisplayed() && consentButton.isEnabled()){
            consentButton.click();
        }
    }

    @When("je me connecte")
    public void jeMeConnecte() {
        myaccount.loginMdp("nelj@nelj.com","Nelj-2024");
        myaccount.clickLogin();
    }

    @And("je clique sur le lien “Account details”")
    public void jeCliqueSurLeLienAccountDetails() {
        myaccount.clickAccountDetails();
    }


    @Then("le lien affiche les informations de compte \\(nom, prenom, mail)")
    public void leLienAfficheLesInformationsDeCompteNomPrenomMail() {
        String name= myaccount.checkName();
        System.out.println(name);

        String firstname= myaccount.checkFirstName();
        System.out.println(firstname);

        String mail = myaccount.checkMail();
        System.out.println(mail);
    }
}
