package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import resources.Base;
import resources.Utilities;

public class NuevoContaco extends Base {
	
	WebDriver driver;
	Properties prop;
	JavascriptExecutor js;
	Utilities ut;

	public NuevoContaco(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
		ut =  new Utilities(driver);
	
	}
	
	public void getURLnewWindow() {
		ut.waitURL("NewContact", 7);
		String urlNuevoCuentas = driver.getCurrentUrl();
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(urlNuevoCuentas);
	}
	
	
	private WebElement campo(String campo) {
		String strMyXPath = "//input[@placeholder='" + campo + "']";
		WebElement element = driver.findElement(By.xpath(strMyXPath));
		return element;
		}
	
	
	@FindBy (xpath="//div[@class='modal-footer slds-modal__footer']/button[2]")
	private WebElement guardar;
	
	public WebElement guardar() {
		return guardar;
	}
	

	@FindBy (xpath="//footer[@class='slds-modal__footer']/button[2]")
	private WebElement guardar1;
	
	public WebElement guardar1() {
		return guardar1;
	}
	
	
	@FindBy (xpath="//footer[@class='slds-modal__footer']/button[1]")
	private WebElement cancelar;
	
	public WebElement cancelar() {
		return cancelar;
	}
	
	@FindBy (xpath="//tbody/tr/td[6]/span/div") 
	private WebElement flecha;
	
	
	private By flecha1 = By.xpath("//tbody/tr[1]/td[6]/span[1]/div[1]/a[1]/span[1]/span[1]");
	
	public WebElement flecha1() {
		return driver.findElement(flecha1);
	}
	
	
	public WebElement flecha() {
		return flecha;
	}
	
	@FindBy (xpath="//a[@title='Modificar']")
	private WebElement modificar1;
	
	public WebElement modificar1() {
		return modificar1;
	}
	
	private WebElement campos(String campo) {
		String strMyXPath = "//label[text()='" + campo + "']/following-sibling::div/lightning-base-combobox/div";
		WebElement element = driver.findElement(By.xpath(strMyXPath));
		return element;
		}
	
	private WebElement select(String campo) {
		String strMyXPath = "//lightning-base-combobox-item[@data-value='" + campo + "']";
		WebElement element = driver.findElement(By.xpath(strMyXPath));
		return element;
		}

	 @FindBy (xpath="//label[text()='Tipo']/following-sibling::div/lightning-base-combobox/div")
	 private WebElement tipo;
	 
	 public WebElement tipo() {
		 return tipo;
	 }
	 
	 @FindBy (xpath="//lightning-base-combobox-item[@data-value='Customer - Direct']")
	 private WebElement tipoDirect;
	 
	 public WebElement tipoDirect() {
		 return tipoDirect;
	 }
	 
	 @FindBy (xpath="//button[@name='SaveEdit']")
	 private WebElement save;
	 
	 public WebElement save() {
		 return save;
	 }
	 
	 @FindBy (xpath="//div[@data-key= 'success']")
	 private WebElement messageSuccess;
	 
	 public WebElement messageSuccess() {
		 return messageSuccess;
	 }
	 
	@FindBy (xpath="//input[@name='NumberOfEmployees']")
	private WebElement numbEmployees;
	
	public WebElement numbEmployees() {
		return numbEmployees;
	}
	
	
	@FindBy (xpath="//input[@name='Sic']")
	private WebElement sic;
	
	public WebElement sic() {
	return  sic;
	}
	
	public void sic1() {
		 js.executeScript("arguments[0].click();", sic);
	}
	
	
	
	@FindBy (xpath="//div[contains(text(),'fuera del rango')]")
	private WebElement errorMessage;
	
	public WebElement errorMessage() {
		return errorMessage;
	}
	
	public void creandoCuenta(String name, String surname) {
		campo("Nombre").sendKeys(name);
		campo("Apellidos").sendKeys(surname);
		guardar1().click();
	}
	 
	 public void defaultWindow() {
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(0));
		 cancelar().click();
	 }
	 
	 @FindBy(how = How.XPATH, using="//div/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root")
		private List<WebElement> Ventanas;
	 
	 public List<WebElement> Ventanas() {
			return Ventanas;
			}
	 
	 public void navegaVentanas (int i) {
			Ventanas().get(i).click();
		}
	 @FindBy (xpath="//div[@data-key='success']/button")
		private WebElement cierre;
		
	 public WebElement cierre() {
		 return cierre;
	 }
		@FindBy (xpath="//span[text()='success']")
		private WebElement success;
		
	 
	 public WebElement success() {
		 return success;
	 }
	 
	 public void modificarBien(String campo, String valor) {
		 ut.waitURL("Recent", 7);
		 flecha().click();		 
		 modificar1().click();
		 campos(campo).click();
		 select(valor).click();
//		 ut.scrollTop("200");
//		 campos(campo1).click();
//		 select(valor1).click();
		 save().click();
		 ut.waitWebElement(success(), 7);
		 
	 }
	 
	 public void confirmModificarBien() {
			SoftAssert a = new SoftAssert();
			a.assertFalse(messageSuccess().isDisplayed());
			cierre().click();
	 }
	 
	 public void modificarMal(String number) throws InterruptedException {
		 ut.waitWebElementClickable(flecha, 7);
		 flecha().click();
		 modificar1().click();
		 ut.scrollTop("200");
		 numbEmployees().sendKeys(number);
		 sic1();
		 numbEmployees().click();
		 save().click();
	 }
	 
	 public void confirmModificarMal() {
			SoftAssert a = new SoftAssert();
			a.assertFalse(errorMessage().isDisplayed());
	 }
	 
	 
}

