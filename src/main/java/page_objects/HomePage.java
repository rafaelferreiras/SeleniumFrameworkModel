package page_objects;


import org.openqa.selenium.support.PageFactory;

import managers.BasePage;

public class HomePage extends BasePage {

	public HomePage() {

		PageFactory.initElements(driverBasePage, this);
	}

	public void GoHomePage() {

		driverBasePage.get("http://dbankdemo.com/login");

	}

}
