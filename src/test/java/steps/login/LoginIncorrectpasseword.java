package steps.login;

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

public class LoginIncorrectpasseword extends Testbase {

    WebDriver driver = new ChromeDriver();
    MyaccountPage myaccount = new MyaccountPage(driver);


    @Given("j'accède à la page Myaccount")
    public void jAccèdeÀLaPageMyaccount() {
       setupMyaccount(driver);
    }

    @When("je saisis un login valide et mot de passe invalide")
    public void jeSaisisUnLoginValide() {
        myaccount.loginMdp("nelj@nelj.com","Nelj2024");
    }

    @And("je clique sur login")
    public void jeCliqueSurLogin() {
        myaccount.clickLogIn();
    }

    @Then("un message d'erreur s'affiche")
    public void unMessageSAffiche() {
        String errorMsg = myaccount.messageErrorWrongPswd();
        Assert.assertTrue(errorMsg.startsWith("Error: The password you entered"));
        System.out.println(errorMsg);
        teardown(driver);
    }

}
