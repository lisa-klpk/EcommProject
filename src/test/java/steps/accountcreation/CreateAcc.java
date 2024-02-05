package steps.accountcreation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MyaccountPage;
import steps.Testbase;

public class CreateAcc extends Testbase {

    WebDriver driver = new ChromeDriver();
    MyaccountPage myaccount = new MyaccountPage(driver);

    long l = System.currentTimeMillis() / 1000;
    String timeStamp = Long.toString(l);

    @Given("j'ouvre espace myaccount")
    public void jOuvreEspaceMyaccount() {
        setupMyaccount(driver);
    }

    @When("je saisis mail et mot de passe")
    public void jeSaisisMailEtMotDePasse() {
        myaccount.enterLoginPsswdRegister("pow"+timeStamp+"@gmail.com","Mdpazerty@");

    }

    @And("je clique sur Register")
    public void jeCliqueSurRegister(){
        myaccount.clickRegister();
    }

    @Then("Le compte client est cree")
    public void leCompteClientEstCree() {
      String actualMsg= myaccount.confirmRegistration();
      String expectedMsg= "Hello pow"+timeStamp;
      Assert.assertTrue(actualMsg.startsWith(expectedMsg));

      teardown(driver);

    }


}
