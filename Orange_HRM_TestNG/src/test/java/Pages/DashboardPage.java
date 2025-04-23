package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//button[@class=\"oxd-icon-button oxd-icon-button--solid-main orangehrm-attendance-card-action\"]")
	public WebElement ClockIcon;
	
	@FindBy(xpath = "//input[@placeholder=\"hh:mm\"]")
	public WebElement TimeInsert;
	
	//Click
	
	
	//click
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
	public WebElement Out;

	//Click Dashboard
	@FindBy(xpath = "//span[text()='Dashboard']")
	public WebElement Dashboard;
	
	@FindBy(xpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[1]/button/svg/g/path")
	public WebElement AssignLeave;
	@FindBy(xpath = "//i[@class=\"oxd-icon bi-chevron-down oxd-icon-button__icon oxd-time-minute-input-down\"]")
	public WebElement Arrow; 
	
	//------------------------------------------------------------------------------------------------\\
	
	public void clock() {
		 ClockIcon.click();
	 }
	
	public void time() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));

	    wait.until(ExpectedConditions.elementToBeClickable(TimeInsert));

	    TimeInsert.click();
	}
	
	 public void arrow() {
		 Arrow.click();
	 }
	 
	 public void out() {
		Out.click();
	 }
	 
	 public void DashBoard() {
		 Dashboard.click();
	 }
  
}
