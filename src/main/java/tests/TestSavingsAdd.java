package tests;

import org.json.simple.JSONObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import action_test.LoginAction;
import managers.BasePage;
import managers.BaseTestFactory;
import page_objects.LogInBankPage;
import utilities.JsonHandler;

public class TestSavingsAdd extends BaseTestFactory {

	LoginAction loginBankAction;
	JsonHandler jsonHandler;
	LogInBankPage page;
	JSONObject jsonObject = null;

	@BeforeMethod
	public void init() {

		jsonHandler = new JsonHandler();
		loginBankAction = new LoginAction();
		loginBankAction.dataProviderTest(jsonHandler.getDataFile("UsersData.json", "LoginValid"));

	}

	@Test
	public void Abc() {
		
		System.out.println("A implementar!");

	}

	
}
