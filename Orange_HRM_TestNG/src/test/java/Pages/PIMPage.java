package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage extends BasePage {
    
    public PIMPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="(//a/child::span)[2]")
    public WebElement pim;
    @FindBy(xpath="(//nav/descendant::a)[15]")
    public WebElement addemp;
    @FindBy(xpath="(//div[@class='oxd-input-group__label-wrapper']/following-sibling::div)[3]/input")
    public WebElement firstname;
    @FindBy(xpath="(//div[@class='oxd-input-group__label-wrapper']/following-sibling::div)[5]/input")
    public WebElement lastname;
    @FindBy(xpath="(//div[@class='oxd-input-group__label-wrapper']/following-sibling::div)[6]/input")
    public WebElement id;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement save;
    
    //Add supervisor
    @FindBy(xpath="(//div[@class='orangehrm-tabs-wrapper'])[8]/child::a")
    public WebElement reportto;
    @FindBy(xpath="(//h6/following::button)[3]")
    public WebElement addsupervisor;
    @FindBy(xpath="(//div[@class='oxd-autocomplete-text-input--before']/following::input)[1]")
    public WebElement supervisorname;
    @FindBy(xpath="(//div[@class='oxd-select-wrapper'][1]/descendant::div[1]/div)[1]")
    public WebElement reportingmethod;
    @FindBy(xpath="//button[@type='submit'][1]")
    public WebElement savesupervisor;
    
    
    //search
    @FindBy(xpath="(//div[@class='oxd-autocomplete-text-input--before'])[1]/following::input[1]")
    public WebElement searchname;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement search;
    @FindBy(xpath="//div[@class='oxd-table-cell oxd-padding-cell'][3]/div[1]")
    public WebElement text;
}