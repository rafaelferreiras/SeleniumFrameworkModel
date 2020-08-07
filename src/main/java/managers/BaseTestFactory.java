package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import enums.BrowserType;
import page_objects.HomePage;

public class BaseTestFactory {

	private HomePage homePage;

	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {

		return threadDriver.get();

	}

	public static final WebDriver setWebDriver(String driversType) {

		BrowserType type = BrowserType.driversTypeForName(driversType);

		switch (type) {
		case CHROME:

			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
			threadDriver.set(new ChromeDriver());
			break;

		case FIREFOX:

			System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
			threadDriver.set(new FirefoxDriver());
			break;

		case INTERNETEXPLORE:

			System.setProperty("webdriver.ie.driver", "./src/test/resources/IEDriverServer.exe");
			threadDriver.set(new InternetExplorerDriver());
		case EDGE:
			break;

		/*
		 * ERRO: Saída no Eclipse: WebDriver Open IE Vá para Ferramentas -> Opções da
		 * Internet -> Segurança Defina todas as zonas para o mesmo modo protegido,
		 * ativado ou desativado não deve importar. Por fim, defina o nível de zoom para
		 * 100%
		 */
		}
		getDriver().manage().window().maximize();
		return threadDriver.get();
	}

	public static void RemoveWebDriver() {

		threadDriver.get().quit();
		threadDriver.remove();
	}

	@BeforeTest
	@Parameters({ "DriverType" })
	public void before(String driverType) {

		setWebDriver(driverType);
		getHome();
	}

	@AfterTest
	public void after() {

		RemoveWebDriver();

	}

	public void getHome() {

		homePage = new HomePage();
		homePage.GoHomePage();

	}

}
