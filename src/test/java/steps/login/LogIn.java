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
import pages.PersonalSpace;
import steps.Testbase;

public class LogIn extends Testbase {
    WebDriver driver = new ChromeDriver();
    MyaccountPage myaccount = new MyaccountPage(driver);
    PersonalSpace myspace = new PersonalSpace(driver);

    @Given("jouvre l'espace My Account")
    public void jOuvreLEspaceMyAccount() {
        setupMyaccount(driver);

    }

    @When("je saisis Login et mot de passe")
    public void jeSaisisLoginEtMotDePasse() {
        myaccount.loginMdp("nelj@nelj.com","Nelj2024@@");
    }

    @And("je clique sur bouton Login")
    public void jeCliqueSurBoutonLogin() {
        myaccount.clickLogIn();
    }


    @Then("lécran Dashboard doit s'afficher")
    public void lécranDashboardDoitSAfficher() {
        String actualMsg= myaccount.confirmRegistration();
        String expectedMsg= "Hello nelj";
        Assert.assertTrue(actualMsg.startsWith(expectedMsg));
        System.out.println("L'écran dashboard saffiche ");
    }

    @And("Les liens renvoyant aux pages Dashboard, Orders, Download, Adresses, Account details, Logout doivent s'afficher")
    public void lesLiensRenvoyantAuxPagesDashboardOrdersDownloadAdressesAccountDetailsLogoutDoiventSAfficher() {
       myspace.isElementExisting("dashboard",myspace.dashboard);
       myspace.isElementExisting("orders",myspace.orders);
       myspace.isElementExisting("downloads",myspace.downloads);
       myspace.isElementExisting("accountDetails",myspace.accountDetails);
       myspace.isElementExisting("logOut",myspace.logOut);
       teardown(driver);

    }


}
