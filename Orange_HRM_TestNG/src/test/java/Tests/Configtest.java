package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import Pages.Configpage;
import Pages.PIMPage;

public class Configtest extends BaseTest {
    Configpage con;
    PIMtest pim;
    PIMPage page;
    WebDriverWait wait;
    
    @Test
    public void optionalfields() {
        con = new Configpage(driver);
        pim = new PIMtest();
        page = new PIMPage(driver);
        login();
        clickMethod(page.pim);
        clickMethod(con.config);
        clickMethod(con.optional);
        clickMethod(con.button);
        clickMethod(con.save);

        if (con.button.isEnabled()) {
            System.out.println("Show Deprecated Fields is enabled");
        } else {
            System.out.println("Show Deprecated Fields is disabled");
        }
    }

    @Test
    public void customfields() {
        con = new Configpage(driver);
        pim = new PIMtest();
        page = new PIMPage(driver);

        login();
        clickMethod(page.pim);
        clickMethod(con.config);
        clickMethod(con.custom);
        clickMethod(con.add);
        sendKey(con.fieldname, "Address");

        clickMethod(con.screendropdown);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        clickMethod(con.typedropdown);
        act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        clickMethod(con.savecustomfield);

        String expected = "Address";
        String actual = con.verifycustomsave.getText();
        Assert.assertEquals(expected, actual);
        System.out.println("Asserted Custom field");

        clickMethod(con.delete);
        clickMethod(con.condelete);
    }

    @Test
    public void addTermination() {
        con = new Configpage(driver);
        pim = new PIMtest();
        page = new PIMPage(driver);

        login();
        clickMethod(page.pim);
        clickMethod(con.config);
        clickMethod(con.termination);
        clickMethod(con.add);
        sendKey(con.terminationreason, "Attitude");
        clickMethod(con.submit);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-loading-spinner")));
        String expected = "Attitude";
        String actual = con.terminationtext.getText();
        Assert.assertEquals(expected, actual);
        clickMethod(con.delete);
        clickMethod(con.condelete);
    }

    @Test
    public void Addreportingmethod() {
        con = new Configpage(driver);
        pim = new PIMtest();
        page = new PIMPage(driver);
        login();
        clickMethod(page.pim);
        clickMethod(con.config);
        clickMethod(con.reportingmethod);
        clickMethod(con.add);
        sendKey(con.reportmethodname, "Administrative");
        clickMethod(con.submit);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-loading-spinner")));
        String expected = "Administrative";
        String actual = con.reporttext.getText();
        Assert.assertEquals(expected, actual);
        clickMethod(con.delete);
        clickMethod(con.condelete);
    }

    public void clickMethod(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKey(WebElement element, String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
    public void login() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']"))).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
