package com.linkdin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Base64;

public class LinkdinPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="username")
    private WebElement emailField;
    @FindBy(xpath="//button[text()='Sign in']")
    private WebElement signinButton;

    @FindBy(linkText="Forgot password?")
    private WebElement forgotPasswordLink;

    @FindBy(id="reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;


    public LinkdinPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goToUrl(){
        this.driver.get("https://www.linkedin.com/login");
        this.wait.until(ExpectedConditions.visibilityOf(this.emailField));
    }


    public void enterLoginDetails(String emailText){
        this.emailField.sendKeys(emailText);
    }

    public void clickOnLoginButton(){
        this.signinButton.click();
    }

    public void clickOnForgotPasswordLink(){
        this.forgotPasswordLink.click();
    }

    public void clickOnResetPassword(){
        this.resetPasswordSubmitButton.click();

    }
}
