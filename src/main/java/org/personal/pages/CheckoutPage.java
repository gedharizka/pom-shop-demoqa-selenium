package org.personal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.personal.drivers.DriverSingelton;

import java.util.concurrent.TimeUnit;

public class CheckoutPage {

    private WebDriver driver;
    public CheckoutPage(){
        this.driver = DriverSingelton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='billing_first_name']")
    private WebElement inputFirstName;
    @FindBy(xpath = "//input[@id='billing_last_name']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@id='billing_company']")
    private WebElement inputCompany;
    @FindBy(xpath = "//span[@id='select2-billing_country-container']")
    private WebElement selectRegion;
    @FindBy(xpath = "//input[@id='billing_address_1']")
    private WebElement inputAddress1;

    @FindBy(xpath = "//input[@id='billing_address_2']")
    private WebElement inputAddress2;
    @FindBy(xpath = "//input[@id='billing_city']")
    private WebElement inputCity;
    @FindBy(xpath = "//span[@id='select2-billing_state-container']")
    private WebElement selectProvince;
    @FindBy(xpath = "//input[@id='billing_postcode']")
    private WebElement inputZipCode;
    @FindBy(xpath = "//input[@id='billing_postcode']")
    private WebElement inputPhoneNumber;
    @FindBy(xpath = "//input[@id='billing_email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='terms']")
    private WebElement checkboxConfrim;
    @FindBy(xpath = "//button[@id='place_order']")
    private WebElement btnPlaceOrder;
    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
    private WebElement txtThankYou;

    public void fillFormCheckout(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        js.executeScript("window.scrollBy(0,1100)");

        js.executeScript("arguments[0].click();", checkboxConfrim);
        js.executeScript("arguments[0].click();", btnPlaceOrder);

    }

    public String getThankyou(){
        return  txtThankYou.getText();
    }

}
