package steps.accountcreation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MyaccountPage;
import steps.Testbase;

import java.util.concurrent.TimeUnit;

public class InvalidPassword extends Testbase {

    WebDriver driver = new ChromeDriver();
    MyaccountPage myaccount = new MyaccountPage(driver);

   @Given("j'ouvre un espace myaccount")
    public void jOuvreUnEspaceMyaccount() {
       setupMyaccount(driver);
    }

    @When("je saisis un mail valide et un mot de passe invalide")
    public void jeSaisisUnMailValideEtUnMotDePasseInvalide() {
        myaccount.enterLoginPsswdRegister("pow@gmail.com","lmlml");

    }

    @And("Je clique sur le bouton register")
    public void jeCliqueSurLeBoutonRegister(){
       myaccount.clickRegister();
    }

    @Then("Le compte client n'est pas cree")
    public void leCompteClientNEstPasCree() {
        String actualMsg = myaccount.messageInvalidPswd();
        String expectedMsg = "Very weak - Please enter a stronger password.";
        Assert.assertEquals(expectedMsg,actualMsg);
        teardown(driver);

    }


}
