
package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.BasePage;

public class LogInBankPage extends BasePage {

	public LogInBankPage() {

		PageFactory.initElements(driverBasePage, this);

	}

	@FindBy(how = How.ID, using = "username")

	public WebElement txt_UserName;

	@FindBy(how = How.ID, using = "password")

	public WebElement txt_Password;

	@FindBy(how = How.ID, using = "submit")

	public WebElement btn_Submit;

	@FindBy(how = How.CSS, using = ".sufee-alert.alert.with-close.alert-danger.alert-dismissible.fade.show")

	public WebElement error_login;

	@FindBy(how = How.XPATH, using = "//li[contains(.,'Welcome RAFAEL')]")

	public WebElement sucess_login;

	// Set dados
	public LogInBankPage preencherLogin(String login) {

		sendKeys(txt_UserName, login);
		return this;
	}

	public LogInBankPage preencheSenha(String senha) {

		sendKeys(txt_Password, senha);
		return this;
	}

	public LogInBankPage clicarSumit() {

		click(btn_Submit);
		return this;
	}

	public String verifySucessLogin() {

		return isElementClickable(sucess_login).getText();

	}

	public String verifyErrorLogin() {

		return isElementClickable(error_login).getAttribute("innerText");
	}

}
