package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utils.LogManagers;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setupPage() {
        loginPage = new LoginPage(driver); // 'driver' comes from BaseTest
    }

    @Test(priority = 0)
    public void Ltest() {
        loginPage.enterUsername();
        LogManagers.logInfo("UserName Entred");
        loginPage.enterPassword();
        LogManagers.logInfo("Password Entred");
        loginPage.submit();
        LogManagers.logInfo("Login Clicked");

        
        String str = "OrangeHRM";
        String Org = driver.getTitle();
        
        AssertJUnit.assertEquals(Org, str);
        
    }
    
    @Test(priority = 1)
    public void Invalid() {
    	 loginPage.enterInvalidUsername();
         LogManagers.logInfo("Invalid UserName Entred");

         loginPage.enterInvalidPassword();
         LogManagers.logInfo("Invalid Password Entred");

         loginPage.Login();
         LogManagers.logInfo("Login Clicked");

         
         
         String str = "OrangeHRM";
         String Org = driver.getTitle();
         
         AssertJUnit.assertEquals(Org, str);
    }
    @Test(priority = 2)
    public void empty() {
    	loginPage.enterEmptyUsername();
        LogManagers.logInfo("Empty UserName Entred");

        loginPage.enterEmptyPassword();
        LogManagers.logInfo("Empty Password Entred");

        loginPage.Logi();
        LogManagers.logInfo("Login Clicked");

        
        String str = "Required";
         WebElement Empty = driver.findElement(By.xpath("//span[text()='Required']"));
         String Org = Empty.getText();
        AssertJUnit.assertEquals(Org, str);
    }
    @Test(priority = 3)
    public void ForgotPass() {
    	loginPage.forgotPass();
        LogManagers.logInfo("Forgot Password Clicked");

    	String Exp = "Reset Password";
    	WebElement ResetPass = driver.findElement(By.xpath("//h6[text()='Reset Password']"));
    	String Org =ResetPass.getText();
    	
    	AssertJUnit.assertEquals(Org, Exp);
    }
}