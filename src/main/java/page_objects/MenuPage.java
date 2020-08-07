package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.BasePage;

public class MenuPage extends BasePage {

	public MenuPage() {

		PageFactory.initElements(driverBasePage, this);

	}

	public void setMenu(String menu) {

		switch (menu) {

		case "SavingsAdd":
			ClickMenuSavings();
			ClickMenuSavingsAdd();

			break;

		}
	}

	@FindBy(how = How.ID, using = "savings-menu")

	public WebElement menu_Savings;

	public MenuPage ClickMenuSavings() {

		click(menu_Savings);
		return this;
	}

	@FindBy(how = How.ID, using = "new-savings-menu-option")
	public WebElement menu_SavingsAdd;

	public MenuPage ClickMenuSavingsAdd() {

		click(menu_SavingsAdd);
		return this;
	}

}
