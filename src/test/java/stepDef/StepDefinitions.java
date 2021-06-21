package stepDef;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.NuevoContaco;
import pageObjects.NuevoCuentas;
import pageObjects.ServicePage;
import pageObjects.signInPage;
import resources.Base;
import resources.Utilities;

@RunWith(Cucumber.class)


public class StepDefinitions extends Base {
	public WebDriver driver;
	Utilities ut;
	NuevoContaco nc;
	 
	@Given("^Initilize browser with chorme and going to Salesforce$")
    public void initilize_browser_with_chorme_and_going_to_salesforce() throws Throwable {
		 driver = initializeDriver();
		 
	    }
	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
    public void user_enters_something_and_something_and_logs_in(String username, String password) throws Throwable {
		signInPage sg = new signInPage(driver);
		ServicePage sp = sg.LoginServicePage(username, password); 
	}
		
	 
		
	@Then("^Navigates windows of service page$")
    public void navigates_windows_of_service_page() throws Throwable {
		  ServicePage sp = new ServicePage(driver);
		  sp.navegaVentanas(1);
		  sp.navegaVentanas(2);
			sp.nuevoYcierro();
			sp.navegaVentanas(3);
			sp.nuevoYcierro();
			sp.navegaVentanas(4);
			sp.nuevoYcierro();
			sp.navegaVentanas(5);
			sp.nuevoYcanceloInforme();
			sp.navegaVentanas(6);
			sp.nuevoYcanceloPanel();
	    }
	
	@Given("^entering service page$")
    public void entering_service_page() throws Throwable {
		ServicePage sp = new ServicePage(driver);
		 sp.navegaVentanas(2);
		}
	
	@Then("^user creates (.+) with (.+),(.+),(.+),(.+), (.+),(.+),(.+), (.+), (.+), (.+)$")
    public void user_creates_with_(String account, String valoracion, String customer, String propiedad, 
    		String sector, String priority, String sla, String opp, String bin,String wantedMonth, String wantedDay ) throws Throwable {
		ut = new Utilities(driver);
		NuevoCuentas c = new NuevoCuentas (driver);
		c.nuevoCuentas().click();
		c.creandoCuenta(account, valoracion,customer, propiedad, sector, priority, sla, opp, bin, wantedMonth, wantedDay);
		ut.waitURL("count=", 7);

	}
	 @Then("^user creates an empty account$")
	    public void user_creates_an_empty_account() throws Throwable {
		NuevoCuentas c = new NuevoCuentas (driver);
		c.nuevoCuentas().click();
		c.creandoFlasaCuenta();
		
	 }
	 
	 @And("^going to (.+), creating a new contact with (.+) and (.+)$")
	    public void going_to(String account, String name, String surname) throws Throwable {
		ServicePage sp = new ServicePage(driver);
		nc = sp.LoginNuevoContacto(account);
		nc.getURLnewWindow();
		nc.creandoCuenta(name, surname);
		nc.defaultWindow();
	    }
	 
	 @Then("^modifying existing contact \"([^\"]*)\" to (.+)$")
	    public void modifying_existing_contact_something_to(String value1, String strArg1) throws Throwable {
		nc.navegaVentanas(2);
		nc.modificarBien(value1, strArg1);
		nc.confirmModificarBien();
	    }
	 
	 @And("^modifying other contact with this number \"([^\"]*)\" of employees$")
	    public void modifying_other_contact_with_this_number_something_of_employees(String strArg1) throws Throwable {
		 nc.modificarMal(strArg1);
		 nc.confirmModificarMal();
	    }

	   
	 @After
	 public void finish() {
		 driver.quit();		 
	 }
	
	}
