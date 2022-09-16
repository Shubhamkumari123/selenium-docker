package com.facebook.test;

import com.facebook.page.FacebookPage;
import org.testng.annotations.Test;
import tests.BaseTest;

public class FacebookTest extends BaseTest {
    FacebookPage FacebookLoginPage;
    @Test
    public void testFacebookLogin(){
        FacebookLoginPage=new FacebookPage(driver);
        FacebookLoginPage.goToUrl();
        FacebookLoginPage.enterLoginDetails("abc@gmail.com");
        FacebookLoginPage.clickOnLoginButton();
    }

    @Test (dependsOnMethods = "testFacebookLogin")
    public void testNavigateToForgotPasswordPage(){
        FacebookLoginPage.clickOnForgotPasswordLink();
        FacebookLoginPage.enterEmailAndSearch("abc@gmail.com");
    }
}
