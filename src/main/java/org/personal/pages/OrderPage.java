package org.personal.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.personal.drivers.DriverSingelton;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(){
        this.driver = DriverSingelton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator;

    @FindBy(xpath = "//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']")
    private WebElement btnShopQA;

    @FindBy(xpath = "//a[normalize-space()='pink drop shoulder oversized t shirt']")
    private WebElement product1;
    @FindBy(xpath = "//select[@id='pa_color']")
    private WebElement selectColor;
    @FindBy(xpath = "//select[@id='pa_size']")
    private WebElement selectSize;
    @FindBy(xpath = "//i[@class='icon_plus']")
    private WebElement iconPlus;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//span[@class='cart-name-and-total']")
    private WebElement cartItem;

    public void order(){
        btnShopQA.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)");
        product1.click();
        selectColor.sendKeys("pink");
        selectSize.sendKeys("37");
        iconPlus.click();
        btnAddToCart.click();
    }

    public String getCart(){
        return cartItem.getText();
    }


}
