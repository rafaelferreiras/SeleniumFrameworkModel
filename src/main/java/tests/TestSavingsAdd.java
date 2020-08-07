package tests;

import org.json.simple.JSONObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action_test.LoginAction;
import managers.BaseTestFactory;
import page_objects.LogInBankPage;
import page_objects.MenuPage;
import utilities.JsonHandler;

public class TestSavingsAdd extends BaseTestFactory {

	LoginAction loginBankAction;
	MenuPage menuPage;
	JsonHandler jsonHandler;
	LogInBankPage page;
	JSONObject jsonObject = null;

	@BeforeMethod
	@Parameters({ "Menu" })
	public void init(String menu) {

		jsonHandler = new JsonHandler();
		loginBankAction = new LoginAction();
		menuPage = new MenuPage();
		loginBankAction.dataProviderTest(jsonHandler.getDataFile("UsersData.json", "LoginValid"));
		menuPage.setMenu(menu);
		

	}

	@Test
	public void Abc() {
		
		System.out.println("A implementar!");

	}

	
}
