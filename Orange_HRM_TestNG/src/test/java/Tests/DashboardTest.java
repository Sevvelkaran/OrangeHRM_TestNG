package Tests;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.LoginPage;
import Utils.LogManagers;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage Dash;

    @Test(priority = 0)
    public void Login() {
        try {
            loginPage = new LoginPage(driver);
            Dash = new DashboardPage(driver);

            LogManagers.logInfo("Starting Login Test");
            loginPage.enterUsername();
            LogManagers.logInfo("UserName Entered");
            
            loginPage.enterPassword();
            LogManagers.logInfo("Password Entered");
            
            loginPage.submit();
            LogManagers.logInfo("Login Clicked");

            // Perform actions in Dashboard after login
            Dash.clock();
            LogManagers.logInfo("Clock Button Clicked");
            
            Dash.time();
            LogManagers.logInfo("Time Button Clicked");
            
            Dash.arrow();
            LogManagers.logInfo("Arrow Button Clicked");
            
            Dash.out();
            LogManagers.logInfo("Out Button Clicked");
            
            Dash.DashBoard();
            LogManagers.logInfo("Dashboard Loaded Successfully");
        } catch (Exception e) {
            LogManagers.logError("Error during Login Test: " + e.getMessage());
        }
    }

    @Test(priority = 1)
    public void QuickLaunch_Assert() {
        try {
            loginPage = new LoginPage(driver);
            Dash = new DashboardPage(driver);

            LogManagers.logInfo("Starting QuickLaunch Assertion Test");
            loginPage.enterUsername();
            LogManagers.logInfo("UserName Entered");
            
            loginPage.enterPassword();
            LogManagers.logInfo("Password Entered");
            
            loginPage.submit();
            LogManagers.logInfo("Login Clicked");

            // List of quick launch options to assert
            List<String> quickLaunchOptions = Arrays.asList(
                "Assign Leave",
                "Leave List",
                "Timesheets",
                "Apply Leave",
                "My Leave",
                "My Timesheet"
            );

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            for (String option : quickLaunchOptions) {
                String xpath = String.format("//p[text()='%s']", option);

                // Wait for the element to be present
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                String actual = element.getText();

                LogManagers.logInfo(option + " Asserted");
               assertEquals(actual, option, "Quick Launch Assertion Failed for: " + option);
            }

        } catch (Exception e) {
            LogManagers.logError("Error during QuickLaunch Assertion Test: " + e.getMessage());
        }
    }
}
