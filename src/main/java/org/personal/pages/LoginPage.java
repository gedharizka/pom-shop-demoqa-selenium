package org.personal.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.personal.drivers.DriverSingelton;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingelton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator;
    @FindBy(xpath = "//a[@class='woocommerce-store-notice__dismiss-link']")
    private WebElement btnDismiss;
    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private WebElement btnMyAccount;
    @FindBy(xpath = "//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']")
    private WebElement btnShopQA;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement profileBtn;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//p[contains(@class, 'oxd-alert-content-text')]")
    private WebElement errorMesage;
    @FindBy(xpath = "//span[contains(@class, 'oxd-input-field-error-message')]")
    private WebElement fieldRequire;

    //strong[1]
    @FindBy(xpath = "//strong[1]")
    private WebElement txtValidLogin;

    public void login(){
        btnDismiss.click();
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        btnLogin.click();
    }

    public void loginForm(String usernameValue, String passwordValue){
        btnDismiss.click();
        btnMyAccount.click();
        this.username.sendKeys(usernameValue);
        this.password.sendKeys(passwordValue);
        btnLogin.click();

    }

    public void logout(){
        profileBtn.click();
        logoutBtn.click();
    }

    public void clearUsername(){
        username.sendKeys(Keys.CONTROL+"a");
        username.sendKeys(Keys.DELETE);
    }

    public void clearPassword(){
        password.sendKeys(Keys.CONTROL+"a");
        password.sendKeys(Keys.DELETE);
    }

    public String getTxtDashboard(){
        return dashboardTitle.getText();
    }

    public  String getErrorMessage(){
        return  errorMesage.getText();
    }

    public String getRequiredField(){
        return fieldRequire.getText();
    }

    public String getValidLogin(){return  txtValidLogin.getText();}

}
