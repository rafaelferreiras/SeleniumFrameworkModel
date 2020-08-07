package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTestFactory {

	protected WebDriver driverBasePage;
	protected WebDriverWait wait;

	public BasePage() {

		this.driverBasePage = getDriver();
		wait = new WebDriverWait(driverBasePage, 10);
	}

	// text
	public void sendKeys(WebElement element, String text) {

		isElementClickable(element).sendKeys(text);
	}

	// click
	public void click(WebElement element) {

		isElementClickable(element).click();
	}

	// Wait
	public WebDriverWait getDriverWait() {

		return wait;
	}

	// wait ElementClickable
	public WebElement isElementClickable(WebElement element) {

		return getDriverWait().until(ExpectedConditions.elementToBeClickable(element));

	}

	// wait visibilityOf
	public void isElementvisibilityOf(WebElement element) {

		getDriverWait().until(ExpectedConditions.visibilityOf(element));

	}

}
