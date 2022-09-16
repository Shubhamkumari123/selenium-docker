package com.linkdin.test;

import com.facebook.page.FacebookPage;
import com.linkdin.page.LinkdinPage;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LinkdinTest extends BaseTest {
    LinkdinPage linkdinLoginPage;
    @Test
    public void testLinkdinLogin(){
        linkdinLoginPage=new LinkdinPage(driver);
        linkdinLoginPage.goToUrl();
        linkdinLoginPage.enterLoginDetails("abc@gmail.com");
        linkdinLoginPage.clickOnLoginButton();
    }

    @Test (dependsOnMethods = "testLinkdinLogin")
    public void testNavigateToForgotPasswordPage(){
        linkdinLoginPage.clickOnForgotPasswordLink();
        linkdinLoginPage.clickOnResetPassword();
    }
}
