package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShopPage {
    WebDriver driver;
    //By cartIconBy = By.xpath("//i[@class='wpmenucart-icon-shopping-cart-0']");
    By cartIconBy = By.xpath("//a[@href=\'https://practice.automationtesting.in/basket/\']");
    WebElement cartIconWE;
    By shopItemsBy = By.xpath("//ul[@class='products masonry-done']");
    WebElement shopItemsWE;
    By adjustFilter1By = By.xpath("//div[@class=\'ui-slider-range ui-corner-all ui-widget-header\']/following-sibling::span[1]");
    WebElement adjustFilter1WE;
    By filterButtonBy = By.xpath("//button[@type=\"submit\" and contains(text(),'Filter')]");
    WebElement filterButtonWE;
    List<WebElement> allChildElements;
    By minPriceBy = By.xpath("//input[@id=\'min_price\']");
    WebElement minPriceWE;
    By maxPriceBy = By.xpath("//input[@id=\'max_price\']");
    WebElement maxPriceWE;
    By textDispBy = By.xpath("//div[@class=\'woocommerce-message\']");
    WebElement textDispWE;

    int minVal,maxVal;

    By productCategorieBy = By.xpath("//div[@id=\'woocommerce_product_categories-2\']/ul/li[1]");
    WebElement productCategorieWE;

    By javaScriptImageBy = By.xpath("//img[@title=\'Mastering JavaScript\']");
    WebElement javaScriptImageWE;

    By detailsJavaScriptBy = By.xpath("//h1[@itemprop=\'name\']");
    WebElement detailsJavaScriptWE;

    By javaPriceBy = By.xpath("//a[@href=\'https://practice.automationtesting.in/product/mastering-javascript/\']/span/span");
    WebElement javaPriceWE;

    By javaScriptLabelBy = By.xpath("//h3[contains(text(),'Mastering JavaScript')]");
    WebElement javaScriptLabelWE;

    By quantityBy = By.xpath("//input[@title='Qty']");
    WebElement quantityWE;
    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setup(){
        driver.get("https://practice.automationtesting.in/shop/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    public void openShopPage(){
        setup();
        closeConsentPopup();

    }

    private void closeConsentPopup() {

        // Rechercher le bouton "Consent" en utilisant un xpath relatif
        WebElement consentButton = driver.findElement(By.xpath("//button[@aria-label=\'Do not consent\']"));
        // Cliquer sur le bouton "Consent"
        if (consentButton.isDisplayed() && consentButton.isEnabled()){
            consentButton.click();
        }

    }

    public void addArticleToCart(String xpathStr){
        WebElement anyWE = driver.findElement(By.xpath(xpathStr));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.elementToBeClickable(anyWE));
        anyWE.click();
    }

    public CartPage openCart()  {
        cartIconWE = driver.findElement(cartIconBy);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.elementToBeClickable(cartIconWE));
        cartIconWE.click();
        // closeAd();
        return new CartPage(driver);

    }

    public void closeAd(){
        By popUpBy = By.xpath("//div[@id='dismiss-button']");
       // driver.switchTo().frame("Fancybox-frame");
        driver.findElement(popUpBy).click();
       // driver.switchTo().defaultContent();

    }
    public void verifyShopItemsDisplay(){
        shopItemsWE = driver.findElement(shopItemsBy);
        allChildElements = shopItemsWE.findElements(By.xpath("*"));
        int n = allChildElements.size();
        Assert.assertNotEquals("Page doesn't contain articles",0,n);
    }

    public void verifyViewBasketLink(String xpathStr){
        WebElement viewBasketWE = driver.findElement(By.xpath(xpathStr));
        Assert.assertNotNull(viewBasketWE);

    }

    public void setFilterValues() {
        adjustFilter1WE = driver.findElement(adjustFilter1By);
        for(int i=0;i<40;i++) {
            adjustFilter1WE.sendKeys(Keys.ARROW_RIGHT);
        }
        calculateMaxMin();
    }

    private void calculateMaxMin() {
        minPriceWE = driver.findElement(minPriceBy);
        minVal = Integer.parseInt(minPriceWE.getAttribute("data-min"));

        maxPriceWE = driver.findElement(maxPriceBy);
        maxVal = Integer.parseInt(maxPriceWE.getAttribute("data-max"));
     }

    public void clickFilterButton() {
        filterButtonWE = driver.findElement(filterButtonBy);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.elementToBeClickable(filterButtonWE));
        filterButtonWE.click();

    }

    public void verifyFilteredList() {
        WebElement ele;
        driver.getCurrentUrl();
        allChildElements = driver.findElements(By.xpath("//span[@class='woocommerce-Price-amount amount']"));
        for(int i=0;i<allChildElements.size();i++){
            ele = allChildElements.get(i);
            //identify parent from child element
            WebElement t= ele.findElement(By.xpath("parent::*"));
            if(t.getTagName().equalsIgnoreCase("del"))
                continue;
            String price= ele.getText();
            String priceFinal =price.substring(1,price.length()-3);
            int priceValue = Integer.valueOf(priceFinal);
            if(priceValue > maxVal || priceValue < minVal) {
                Assert.fail("Article price exceeds limit values");
            }

        }
    }

    public void chooseProductCategorie() {
        productCategorieWE = driver.findElement(productCategorieBy);
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait3.until(ExpectedConditions.elementToBeClickable(productCategorieWE));
        productCategorieWE.click();
        closeAd();

    }

    public void selectArticleViaImage() {
        javaScriptImageWE = driver.findElement(javaScriptImageBy);
        javaScriptImageWE.click();
    }

    public void verifyDisplayDetailsOfArticle() {
        detailsJavaScriptWE = driver.findElement(detailsJavaScriptBy);
        detailsJavaScriptWE.getText();
        Assert.assertEquals("Mastering JavaScript",detailsJavaScriptWE.getText());

    }

    public void selectArticleByPrice() {
        javaPriceWE = driver.findElement(javaPriceBy);
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait4.until(ExpectedConditions.elementToBeClickable(javaPriceWE));
        javaPriceWE.click();
    }

    public void clickOnLabelArticle() {
        javaScriptLabelWE = driver.findElement(javaScriptLabelBy);
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait4.until(ExpectedConditions.elementToBeClickable(javaScriptLabelWE));
        javaScriptLabelWE.click();


    }
    public void verifyQuantityField() {
        quantityWE = driver.findElement(quantityBy);
        Assert.assertNotNull(quantityWE);


    }
    public void findTextDisplayForAddToCart() {
        textDispWE = driver.findElement(textDispBy);
        System.out.println("text "+textDispWE.getText());
        Assert.assertNotNull(textDispWE);
    }
}
