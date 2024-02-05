package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;

    By productSeleBy =By.xpath("//td[@class=\"product-name\"]");
    WebElement productSeleWE;
    By productLabelBy = By.xpath("//th[contains(text(),'Product')]");
    WebElement productLabelWE;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCartContent(String prodName){
        System.out.println("page is :"+driver.getCurrentUrl());
        productSeleWE = driver.findElement(productSeleBy);
        System.out.println("prod name is :"+productSeleWE.getText());
        Assert.assertEquals(prodName,productSeleWE.getText());

    }

    public void verifyCartPageByLabel() {
        productLabelWE = driver.findElement(productLabelBy);
        Assert.assertNotNull(productLabelWE);

    }
}
