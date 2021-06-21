package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import resources.Utilities;

public class ServicePage {

	private WebDriver driver;
	private Utilities ut;

	public ServicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		ut =  new Utilities(driver);
	}
	
	@FindBy(xpath="//a[@title='Nuevo']")
	private WebElement nuevoCuentas;
	
	private WebElement ingresarCuenta(String nameCuenta) {
		String strMyXPath = "//a[@title='" + nameCuenta + "']";
		WebElement account = driver.findElement(By.xpath(strMyXPath));
		return account;
		}
	
	
	
	@FindBy (xpath="//button[@name='Global.NewContact']")
	private WebElement nuevocontacto;
	@FindBy(how = How.XPATH, using="//div/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root")
	private List<WebElement> Ventanas;
	@FindBy (xpath="//a[contains(@title,'Nuevo')]")
	private WebElement nuevo;
	@FindBy (xpath="//button[@name='CancelEdit']")
	private WebElement cancel;
	@FindBy (how = How.XPATH, using="//div/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root/a[@title='Chatter']")
	private WebElement chatter;
	@FindBy (xpath="//button[@title='Cancelar']")
	private WebElement cancelar;
	@FindBy (xpath = "//a[@title='Nuevo informe']")
	private WebElement nuevoInforme;
	@FindBy (xpath="//iframe[@class='isEdit reportsReportBuilder']")
	private WebElement informeFrame;
	@FindBy (xpath="//button[text()='Cancelar']")
	private WebElement textCancelar;
	@FindBy (xpath="//a[@title='Nuevo panel']")
	private WebElement nuevoPanel;
	@FindBy (xpath="//iframe[@title='dashboard']")
	private WebElement panelesFrame;
	@FindBy (xpath="//button[@id='cancelBtn']")
	private WebElement cancelButton;
	@FindBy (xpath="//div[@class='inlineFooter']/div/div/div[3]/button")
	private WebElement cancel1;
	
	
	public WebElement cancel1() {
		return cancel1;
	}
	
	
	
	public WebElement cancelButton() {
		return cancelButton;
	}
	
	
	
	public WebElement panelesFrame() {
		return panelesFrame;
	}
	
	
	
	public WebElement nuevoPanel() {
		return nuevoPanel;
	}
	public WebElement textCancelar() {
		return textCancelar;
	}
	public WebElement informeFrame() {
		return informeFrame;
	}
	
	public WebElement nuevoInforme() {
		return nuevoInforme;
	}
	
	public WebElement cancelar() {
		return cancelar;
	}
	
	
	public WebElement cancel() {
		return cancel;
	}
	
	
	public WebElement nuevoContacto() {
		return nuevocontacto;
	}
	

	
	public WebElement nuevoCuentas() {
		return nuevoCuentas;
	}

	public List<WebElement> Ventanas() {
	return Ventanas;
	}
	
	public WebElement nuevo() {
		return nuevo;
	}
	public WebElement chatter() {
		return chatter;
	}
	
	public void nuevoYcierro() throws InterruptedException {
		ut.waitURL("Recent", 7);
		nuevo().click();
		ut.waitWebElement(cancel(), 7);
		cancel().click();
	}
	public void nuevoYcancelo() throws InterruptedException {
		ut.waitURL("Recent", 7);		
		nuevoCuentas().click();
		ut.waitWebElement(cancelar(), 7);
		cancelar().click();
	}
	
	public WebDriver switchTo(WebElement element) {
		return driver.switchTo().frame(element);
	}
	
	public WebDriver switchBack() {
		return 	driver.switchTo().defaultContent();

	}
	
	
	
	
	public void nuevoYcanceloInforme() throws InterruptedException {
		nuevoInforme().click();
		ut.waitAndSwitchFrame(informeFrame(), 7);		
		textCancelar().click();
		switchBack();
			}
	
	public void nuevoYcanceloPanel() throws InterruptedException {
		
		nuevoPanel().click();
		ut.waitAndSwitchFrame(panelesFrame(), 7);
		cancelButton().click();
		switchBack();

	}
	
	public void navegaVentanas (int i) {
		Ventanas().get(i).click();
	}
	public void quit() {
		driver.quit();
	}
	
	public NuevoContaco LoginNuevoContacto(String nameAccount) {
		navegaVentanas(2);
		ingresarCuenta(nameAccount).click();
		ut.waitWebElement(nuevoContacto(), 10);
		nuevoContacto().click();
		NuevoContaco nc = new NuevoContaco(driver);
		return nc;
		
	}
	

}
