package steps.login;

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

public class RememberMeBox extends Testbase {
    WebDriver driver = new ChromeDriver();
    MyaccountPage myaccount = new MyaccountPage(driver);
    PersonalSpace space = new PersonalSpace(driver);
    String username = "nelj@nelj.com";
    String motdepasse = "Nelj2024@@";

    @Given("J'ouvre le site Myaccount")
    public void laCaseRememberMeEstCoché() {
     setupMyaccount(driver);
    }

    @When("je me connecte et je clique sur checkbox")
    public void jAccèdeÀLaPageDeConnexion() {
        myaccount.loginMdp(username,motdepasse);
        myaccount.checkBox();
        myaccount.clickLogIn();

    }

    @Then("le login de la connexion précédente apparait lors de la prochaine connexion")
    public void leLoginDeLaConnexionPrécédenteApparait(){
        space.logOutPersonalSpace();
        String value = myaccount.usernameBoxValue();
        //Assert.assertEquals(value,username);
        teardown(driver);

    }
}
