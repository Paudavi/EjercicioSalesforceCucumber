package resources;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
	private WebDriver driver;
    JavascriptExecutor executor;

	
	public Utilities(WebDriver driver) {
		this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;

	}
	
	public void waitURL(String string, int num) {
		WebDriverWait w= new WebDriverWait(driver,num);
		w.until(ExpectedConditions.urlContains(string));
		}
	
	public WebElement waitWebElement(WebElement a, int num) {
		WebDriverWait w= new WebDriverWait(driver,num);
		return w.until(ExpectedConditions.visibilityOf(a));
	}
	
	public WebElement waitWebElementClickable(WebElement a, int num) {
		WebDriverWait w= new WebDriverWait(driver, num);
		return w.until(ExpectedConditions.elementToBeClickable(a));
	}
	
	
	public void waitAndSwitchFrame(WebElement frame, int num) {
		WebDriverWait w= new WebDriverWait(driver,num);
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	}
	
	public void chooseDate(WebElement month, String wantedMonth, WebElement nextMonth, List<WebElement> days, String wantedDay) {
		while (!month.getText().contains(wantedMonth)) {
			nextMonth.click();
				}		
		int totalDates = days.size();
		for (int i=0;i<totalDates;i++) {
			String text = days.get(i).getText();
			if (text.equalsIgnoreCase(wantedDay)) {
				days.get(i).click();
				break;
			}
			
		}
	}	
	
	public void scroll(String num) {
		String argument = "document.querySelector('.actionBody').scroll(0," + num + ")";
		executor.executeScript(argument);

	}
	public void scrollTop(String num) {
		String argument = "document.querySelector('.actionBody').scrollTop=" + num;
		executor.executeScript(argument);

	}
}
	
	
	

	