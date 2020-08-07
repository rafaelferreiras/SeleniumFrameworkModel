package tests;

import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import action_test.LoginAction;
import managers.BasePage;
import managers.BaseTestFactory;
import page_objects.LogInBankPage;
import utilities.JsonHandler;

public class TestLoginBank extends BaseTestFactory {

	LoginAction loginBankAction;
	JsonHandler jsonHandler;
	LogInBankPage page;
	JSONObject jsonObject = null;

	@BeforeMethod
	public void init() {

		jsonHandler = new JsonHandler();
		loginBankAction = new LoginAction();
		page = new LogInBankPage();
		

	}

	@Test
	public void verifyAcessSuccessfully() {

		loginBankAction.dataProviderTest(jsonObject = jsonHandler.getDataFile("UsersData.json", "LoginValid"));
		Assert.assertEquals(page.verifySucessLogin(), (String) jsonObject.get("message"));
	}

	@Test
	public void verifyAcessInvalid() {

		loginBankAction.dataProviderTest(jsonObject = jsonHandler.getDataFile("UsersData.json", "LoginInvalid"));
		Assert.assertTrue(page.verifyErrorLogin().contains((String) jsonObject.get("message")));
	}

	@Test
	public void verifyAcessEmpty() {

		loginBankAction.dataProviderTest(jsonObject = jsonHandler.getDataFile("UsersData.json", "LoginAllEmpty"));
		Assert.assertTrue(page.verifyErrorLogin().contains((String) jsonObject.get("message")));

	}

}
