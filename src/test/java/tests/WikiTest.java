/**
 * 
 */
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomeWikiPage;
import pages.ResultWikiPage;

/**
 * @author User
 *
 */
public class WikiTest  {

	private String PATHDRIVER = "src/test/resources/driver/";
	private String baseURL = "https://www.wikipedia.org/";
	private WebDriver driver;


	//prueba actualización a github

	@BeforeSuite
	public void setup(){
		System.setProperty("webdriver.chrome.driver",PATHDRIVER+"chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
	}

	@Parameters({"busqueda"})
	@Test
	public void testWikiSearch(String busqueda) throws InterruptedException {
		driver.get(baseURL);
		HomeWikiPage home=new HomeWikiPage(driver);
		home.buscar(busqueda);
		ResultWikiPage articlePage=new ResultWikiPage(driver);
		Assert.assertEquals(articlePage.getPageTitle(), "Java");
	}

	@AfterSuite
	public void close(){
		driver.close();
	}
	
}
