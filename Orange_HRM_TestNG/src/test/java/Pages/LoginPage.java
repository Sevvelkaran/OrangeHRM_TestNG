package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {
	  public LoginPage(WebDriver driver) {
			super(driver);
		}
	  @FindBy(xpath = "//input[@placeholder=\"Username\"]")
	  WebElement UserName;
	  
	  @FindBy(xpath = "//input[@placeholder=\"Password\"]")
	  WebElement Password;
//	 
	  @FindBy(xpath = "//p[text()='Forgot your password? ']")
	  WebElement Forgot;

	public void enterUsername() {
			// TODO Auto-generated method stub
		UserName.sendKeys("Admin");

		}
	public void enterPassword() {
		Password.sendKeys("admin123");
	}
	public void submit() {
		WebElement Sub = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		Sub.click();
	}
	//-------------INVALID-------------------------
	public void enterInvalidUsername() {
		UserName.sendKeys("asdf");
	}
	public void enterInvalidPassword() {
		Password.sendKeys("asdfg");
	}
	public void Login() {
		WebElement login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		login.click();
	}
	//------------EMPTY------------------------------
	public void enterEmptyUsername() {
		UserName.sendKeys("");
	}
	public void enterEmptyPassword() {
		Password.sendKeys("");
	}
	public void Logi() {
		WebElement login1 = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		login1.click();
	}
	//-----------FORGOT--------------------------------

	public void forgotPass() {
		// TODO Auto-generated method stub
		Forgot.click();
	}

}