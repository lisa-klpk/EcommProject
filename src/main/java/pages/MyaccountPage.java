package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyaccountPage {

    WebDriver driver;
    String  confirmationMsg;
    String  invalidMsg;

    By email = By.xpath("//input[@id='reg_email']");
    By password = By.xpath("//input[@id='reg_password']");

    public By login = By.xpath("//input[@id='username']");
    By mdp = By.xpath("//input[@name='password']");

    By registerButton = By.xpath("//input[@name='register']");
    WebElement RegisterWE;

    By elementClick = By.xpath("//h2[contains(text(),\"Register\")]");


    By confirmRegister = By.xpath("//p[contains(text(),\"Hello\")]");


    //By login = By.xpath("//input[@id='username']");
    //By mdp = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//input[@name='login']");

    By logOutLink = By.xpath("//a[contains(text(),'Logout')]");
    By accountDetailsLink = By.xpath("//a[contains(text(),'Account Details')]");

    By checkName = By.xpath("//input[@value='Nelj']");
    By checkFirstName = By.xpath("//input[@value='Test']");
    By checkMail = By.xpath("//input[@value='nelj@nelj.com']");

    By currentMdp = By.xpath("//input[@name='password_current']");
    By newmdp = By.xpath("//input[@id='password_1']");
    By confirmNewMdp = By.xpath("//input[@id='password_2']");
    By saveChangesButton = By.xpath("//input[@name='save_account_details']");
    By confirmChanges = By.xpath("//div[@class='woocommerce-message']");

    By errorMsg = By.xpath("//li[contains(text(),'Your current password is incorrect.')]");
    By errorMsg2 = By.xpath("//li[contains(text(),'New passwords do not match.')]");

    By invalidPswdMsg = By.xpath("//div[contains(text(),\"Very weak\")]");

    WebElement LoginWE;

    By checkBox = By.xpath("//input[@value=\"forever\"]");
    WebElement CheckBoxWE;

    By messageErreurLogin = By.xpath("(//ul[@class=\"woocommerce-error\"]//following::li)[1]");
    WebElement msgErreurWE;


    public MyaccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterLoginPsswdRegister(String emailadress, String psswd){
        driver.findElement(email).sendKeys(emailadress);
        driver.findElement(password).sendKeys(psswd);
    }

    public String usernameBoxValue(){
        return driver.findElement(email).getCssValue("value");
    }

    public void loginMdp(String mail, String motdepasse){
        driver.findElement(login).sendKeys(mail);
        driver.findElement(mdp).sendKeys(motdepasse);

    }
    public void clickRegister(){
        RegisterWE= driver.findElement(registerButton);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.elementToBeClickable(registerButton));
        RegisterWE.click();
        //driver.findElement(registerButton).click();
    }

    public void clickLogIn(){
        driver.findElement(loginButton).click();
        //WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        // wait1.until(ExpectedConditions.elementToBeClickable(RegisterWE));
        // LoginWE.click();
    }

    public void checkBox(){
        driver.findElement(checkBox).click();

    }


    public String confirmRegistration1(){
        String message =  driver.findElement(confirmRegister).getText();
        return message;

    }


    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void clickLogout(){
        driver.findElement(logOutLink).click();
    }

    public void clickAccountDetails(){driver.findElement(accountDetailsLink).click();}

    public String checkName(){
        String name = driver.findElement(checkName).getText();
        return name;
    }

    public String checkFirstName(){
        String firstname = driver.findElement(checkFirstName).getText();
        return firstname;
    }

    public String checkMail(){
        String mail = driver.findElement(checkMail).getText();
        return mail;
    }

    public void currentMdp(String current){
        driver.findElement(currentMdp).sendKeys(current);
    }

    public void newMdp (String pswd){
        driver.findElement(newmdp).sendKeys(pswd);
    }

    public void confirmNewMdp (String pswdconfirm){
        driver.findElement(confirmNewMdp).sendKeys(pswdconfirm);
    }

    public void clickSaveChanges(){
        driver.findElement(saveChangesButton).click();
    }

    public String confirmChanges(){
        String msg = driver.findElement(confirmChanges).getText();
        return msg;
    }

    public String confirmError(){
        String error = driver.findElement(errorMsg).getText();
        return error;
    }

    public String confirmError2(){
        String erreur = driver.findElement(errorMsg2).getText();
        return erreur;
    }



    public String confirmRegistration(){
        confirmationMsg = driver.findElement(confirmRegister).getText();
        return confirmationMsg;
    }

    public String messageInvalidPswd(){
        invalidMsg = driver.findElement(invalidPswdMsg).getText();
        return invalidMsg;
    }

    public String messageErrorWrongPswd(){
        return driver.findElement(messageErreurLogin).getText();

    }

}
