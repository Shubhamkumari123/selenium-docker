package com.facebook.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="email")
    private WebElement emailField;
    @FindBy(name="login")
    private WebElement loginButton;

    @FindBy(linkText="Forgotten password?")
    private WebElement forgotPasswordLink;

    @FindBy(id="identify_email")
    private WebElement emailFieldForForgotPassword;

    @FindBy(id="did_submit")
    private WebElement searchButton;


    public FacebookPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goToUrl(){
        this.driver.get("https://www.facebook.com/");
        this.wait.until(ExpectedConditions.visibilityOf(this.emailField));
    }


    public void enterLoginDetails(String emailText){
        this.emailField.sendKeys(emailText);

    }

    public void clickOnLoginButton(){
        this.loginButton.click();
    }

    public void clickOnForgotPasswordLink(){
        this.forgotPasswordLink.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.emailFieldForForgotPassword));
    }

    public void enterEmailAndSearch(String emailText){
        this.emailFieldForForgotPassword.sendKeys(emailText);
        this.searchButton.click();
    }
}
