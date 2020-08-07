package action_test;

import org.json.simple.JSONObject;

import page_objects.LogInBankPage;

public class LoginAction extends ActionTest {

	private String username;
	private String password;

	LogInBankPage page = new LogInBankPage();

	@Override
	public void dataProviderTest(JSONObject jsonObject) {
		username = (String) jsonObject.get("username");
		password = (String) jsonObject.get("password");

		ActionStepTest();

	}

	@Override
	public void ActionStepTest() {
		page.preencherLogin(username).preencheSenha(password).clicarSumit();

	}

}
