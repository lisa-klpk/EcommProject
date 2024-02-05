package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalSpace {

    WebDriver driver;
    public PersonalSpace(WebDriver driver){this.driver = driver;}

    public By dashboard = By.xpath("//a[contains(text(),\"Dashboard\")]");
    WebElement dashbboardWE;
    public By orders = By.xpath("//a[contains(text(),\"Orders\")]");
    WebElement ordersWE;

    public By downloads = By.xpath("//a[contains(text(),\"Downloads\")]");
    WebElement downloadsWE;
    public By accountDetails = By.xpath("//a[contains(text(),\"Account Details\")]");
    WebElement accountDetailsWE;

    public By logIn = By.xpath("//a[contains(text(),\"Logout\")]");

    public By logOut = By.xpath("//a[contains(text(),\"Sign out\")]");

    public void isElementExisting(String elementName, By locator) {
        WebElement element = driver.findElement(locator);
        if (element.isDisplayed()) {
            System.out.println(elementName + " est visible sur la page.");
        } else {
            System.out.println(elementName + " n'est pas visible sur la page.");
        }
    }

    public void logOutPersonalSpace(){
        driver.findElement(logOut).click();
    }



}
