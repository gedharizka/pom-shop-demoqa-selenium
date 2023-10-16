package com.personal;

import org.openqa.selenium.WebDriver;
import org.personal.drivers.DriverSingelton;
import org.personal.pages.CartPage;
import org.personal.pages.CheckoutPage;
import org.personal.pages.LoginPage;
import org.personal.pages.OrderPage;
import org.personal.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private OrderPage orderPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp(){
        DriverSingelton.getInstance(Constants.Chrome);
        driver = DriverSingelton.getDriver();
        String url =Constants.URL;
        driver.get(url);

        //step
        loginPage = new LoginPage();
        orderPage = new OrderPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();

    }


    @AfterClass
    public void finish(){
        DriverSingelton.delay(3);
        DriverSingelton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testOrder(){
        loginPage.loginForm("gedharizka17", "JuaraCoding@2023");
        orderPage.order();
        cartPage.processCheckout();
        checkoutPage.fillFormCheckout();
        Assert.assertEquals(checkoutPage.getThankyou(),"Thank you. Your order has been received.");

    }
}
