package pageObjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class signInPage extends Base {
	
	private WebDriver driver;

	public signInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username") 
	WebElement username;
	@FindBy (id="password")
	WebElement password;
	@FindBy (id="Login")
	WebElement login;
	
	public WebElement username() {
		return username;
	}
	public WebElement password() {
		return password;
	}
	public WebElement login() {
	return login;
		
	}
	public  ServicePage LoginServicePage(String username, String password) throws IOException {
		properties();		
		signInPage sg = new signInPage(driver);
		sg.username().sendKeys(username);
		sg.password().sendKeys(password);
		sg.login().click();
		principalPage pp= new principalPage(driver);
		pp.iniciador().click();
		pp.buscador().sendKeys(prop.getProperty("buscador"));
		pp.servicio().click();
		ServicePage sp = new ServicePage(driver);
		return sp;
		
	}
	
		}
	
	
	
	

