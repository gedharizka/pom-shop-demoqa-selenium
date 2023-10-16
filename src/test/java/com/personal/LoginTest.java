package com.personal;

import org.openqa.selenium.WebDriver;
import org.personal.drivers.DriverSingelton;
import org.personal.pages.LoginPage;
import org.personal.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingelton.getInstance(Constants.Chrome);
        driver = DriverSingelton.getDriver();
        String url =Constants.URL;
        driver.get(url);

        //step
        loginPage = new LoginPage();
    }


    @AfterClass
    public void finish(){
        DriverSingelton.delay(3);
        DriverSingelton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void validLogin(){
        loginPage.loginForm("gedharizka17", "JuaraCoding@2023");
        Assert.assertEquals(loginPage.getValidLogin(),"gedharizka17");
        System.out.println("test valid login");
    }


}
