package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import resources.Base;
import resources.Utilities;

public class NuevoCuentas extends Base {

	WebDriver driver;
    JavascriptExecutor executor;
    WebDriverWait w;
    Utilities ut;
    
	public NuevoCuentas(WebDriver driver) {
		this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);	
		ut =  new Utilities(driver);
	}
	
	@FindBy(xpath="//a[@title='Nuevo']")
	private WebElement nuevoCuentas;
	
	@FindBy (xpath="//h2[starts-with(@id,'month')]")
	private WebElement month;
	
	public WebElement month() {
		return month;
	}

	@FindBy (xpath="//span[@class='slds-day']")
	private List<WebElement> days;
	
	@FindBy (xpath="//h2[starts-with(@id,'month')]/following::button[1]")
	private WebElement nextMonth;
	
	public WebElement nextMonth() {
		return nextMonth;
	}

	public List<WebElement> days(){
		return days;
	}
	@FindBy(xpath="//input[@name='Name']")  
	private WebElement nombre;
	
	@FindBy(xpath="//input[@placeholder='Apellidos']")
	private WebElement apellidos;
	
	private void Campos(String type) {
		String strMyXPath = "//label[text()='" + type + "']/following-sibling::div/lightning-base-combobox/div";
		driver.findElement(By.xpath(strMyXPath)).click();
		}
		
	private void valoracion(String type) {
	String strMyXPath = "//lightning-base-combobox-item[@data-value='" + type + "']";
	driver.findElement(By.xpath(strMyXPath)).click();
	}
		
	private void eleccActive(String type) {
		String strMyXPath = "//label[text()='Active']/following-sibling::div/lightning-base-combobox/div/div/lightning-base-combobox-item[@data-value='" + type + "']";
		driver.findElement(By.xpath(strMyXPath)).click();	
	}
	
	
	@FindBy (xpath="//label[text()='SLA Expiration Date']/following-sibling::div")
	private WebElement date;
	
	@FindBy (xpath="//td[@aria-current='date']")
	private WebElement currentDate;
	
	@FindBy (xpath="//button[@name='SaveAndNew']")
	private WebElement SaveAndNew;
	
	@FindBy (xpath="//span[text()='success']")
	private WebElement success;
	
	@FindBy (xpath="//button[@name='SaveEdit']")
	private WebElement saveEdit;
	
	@FindBy (xpath="//div[@class='panel-header']//div[2]//h2")
	private WebElement error;
	
	@FindBy (xpath="//div[@data-key=\"success\"]/button")
	private WebElement cierre;
	
	public WebElement nuevoCuentas() {
		return nuevoCuentas;
	}

	public WebElement nombre() {
		return nombre;
	}
	


	 public WebElement date() {
		 return date;
	 }
	 
	 public WebElement currentDate() {
		 return currentDate;
	 }
	 
	 public WebElement SaveAndNew() {
		 return SaveAndNew;
	 }
	 
	 public WebElement success() {
		 return success;
	 }
	 
	 public WebElement saveEdit() {
		 return saveEdit;
	 }
	 
	 public WebElement error() {
		 return error;
	 }

	 public WebElement cierre() {
		 return cierre;
	 }
	 
	public void creandoCuenta(String name, String valoracion, String customer, 
			String propiedad, String sector, String priority, String SLA, String opp,
			String bin, String wantedMonth, String wantedDay) {
//		w= new WebDriverWait(driver,7);
//		w.until(ExpectedConditions.visibilityOf(nombre()));
		ut.waitWebElement(nombre(), 7);
		nombre().sendKeys(name);
		Campos("Valoración");
		valoracion(valoracion);
//		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("document.querySelector('.actionBody').scrollTop=200");
		ut.scrollTop("250");
		Campos("Tipo");
		valoracion(customer);
		Campos("Propiedad");
		valoracion(propiedad);
		Campos("Sector");
		valoracion(sector);
//		js.executeScript("document.querySelector('.actionBody').scroll(0,900)");
		ut.scroll("900");
		Campos("Customer Priority");
		valoracion(priority);
		Campos("SLA");
		valoracion(SLA);
		Campos("Upsell Opportunity");
		valoracion(opp);
		Campos("Active");
		eleccActive(bin);
		date().click();
		ut.chooseDate(month, wantedMonth, nextMonth, days, wantedDay);
//		currentDate().click();
		SaveAndNew().click();
		ut.waitWebElementClickable(success(), 7);
//		w.until(ExpectedConditions.visibilityOf(success()));
		cierre().click();
	}
	
	public void creandoFlasaCuenta() throws InterruptedException {
		ut.waitWebElement(nombre(), 7);
		saveEdit().click();
//		w.until(ExpectedConditions.visibilityOf(error()));
		ut.waitWebElement(error(), 7);
		SoftAssert a = new SoftAssert();
		String mensajeError = error().getText();
		a.assertTrue(mensajeError.contains("problema"));
		a.assertAll();

	} 
	
}
