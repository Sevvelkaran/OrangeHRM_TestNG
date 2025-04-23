package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Configpage extends BasePage{
	public Configpage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[1]")
public WebElement config;
@FindBy(xpath="(//a[@class='oxd-topbar-body-nav-tab-link'])[1]")
public WebElement optional;
@FindBy(xpath="(//label/span)[1]")
public WebElement button;
@FindBy(xpath="(//button)[4]")
public WebElement save;

//custom field;
@FindBy(xpath="(//a[@class='oxd-topbar-body-nav-tab-link'])[2]")
public WebElement custom;
@FindBy(xpath="(//button)[4]")
public WebElement add;
@FindBy(xpath="(//div/input)[2]")
public WebElement fieldname;
@FindBy(xpath="(//div/i)[3]")
public WebElement screendropdown;
@FindBy(xpath="(//div/i)[4]")
public WebElement typedropdown;
@FindBy(xpath="//button[2]")
public WebElement savecustomfield;
@FindBy(xpath="(//div[@class='oxd-table-cell oxd-padding-cell'])[2]/div")
public WebElement verifycustomsave;


//Add reporting method
@FindBy(xpath="(//ul)[4]/li[4]")
public WebElement reportingmethod;
@FindBy(xpath="(//div/input)[2]")
public WebElement reportmethodname;
@FindBy(xpath="(//div[@class='oxd-table-cell oxd-padding-cell'])[2]/div")
public WebElement reporttext;
@FindBy(xpath="(//button)[5]/i")
public WebElement delete;
@FindBy(xpath="//div[3]/button[2]")
public WebElement condelete;


//termination reason
@FindBy(xpath="(//ul)[4]/li[5]")
public WebElement termination;
@FindBy(xpath="(//div/input)[2]")
public WebElement terminationreason;
@FindBy(xpath="//button[@type='submit']")
public WebElement submit;
@FindBy(xpath="(//div[@class='oxd-table-cell oxd-padding-cell'])[2]/div")
public WebElement terminationtext;
}