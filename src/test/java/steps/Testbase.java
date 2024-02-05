package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testbase {

 public String email;


    public void setupMyaccount(WebDriver driver){

        driver.get("https://practice.automationtesting.in/my-account/");
        WebElement consentButton = driver.findElement(By.xpath("//p[@class='fc-button-label' and text()='Do not consent']"));
        if (consentButton.isDisplayed() && consentButton.isEnabled()){
            consentButton.click();
    }

}

public void teardown(WebDriver driver){
    driver.quit();

}

}
