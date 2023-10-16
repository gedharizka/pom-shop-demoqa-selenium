package org.personal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.personal.drivers.DriverSingelton;

public class CartPage {

    private WebDriver driver;
    public  CartPage(){
        this.driver = DriverSingelton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    private WebElement btnCheckout;
    @FindBy(xpath = "//i[@class='icon_bag_alt']")
    private WebElement btnCart;

    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement txtCheckout;

    public void processCheckout(){
        btnCart.click();
        btnCheckout.click();
    }

    public String getTxtCheckout (){
        return  txtCheckout.getText();
    }
}
