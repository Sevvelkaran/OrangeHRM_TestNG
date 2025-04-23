package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.PIMPage;

import java.time.Duration;

public class PIMtest extends BaseTest {
	PIMPage pim;
	WebDriverWait wait;

	@Test
    public void Addemployee()throws InterruptedException {
		 addemployee();
    }
	@Test()
	public void Addsupervisor() {
		addemployee();
		clickMethod(pim.reportto);
		clickMethod(pim.addsupervisor);
		Actions act=new Actions(driver);
		sendKey(pim.supervisorname,"Thoushi F");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	    clickMethod(pim.reportingmethod);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
	    act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	    clickMethod(pim.savesupervisor);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-loading-spinner")));
	}
	@Test()
	public void search() {
		login();
        pim=new PIMPage(driver);
        clickMethod(pim.pim);
        sendKey(pim.searchname,"Thoushi F");
        Actions act=new Actions(driver);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		clickMethod(pim.search);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-loading-spinner")));
//		//assertion
//		Assert.assertEquals(pim.text.getText(),pim.firstname.getText());
//		System.out.println("successfully add the employee");
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
    public void addemployee() {
    	login();
        pim=new PIMPage(driver);
        clickMethod(pim.pim);
        clickMethod(pim.addemp);
        sendKey(pim.firstname,"Thoushi");
        sendKey(pim.lastname,"F");
        sendKey(pim.id,"1234");
        clickMethod(pim.save);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner")));
    }
}