package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FlightsResult;
import pages.HomeTravelPage;
import pages.HomeWikiPage;
import pages.ResultWikiPage;

import java.util.concurrent.TimeUnit;

public class Exam1Test {

    private String PATHDRIVER = "src/test/resources/driver/";
    private String baseURL = "https://www.travelocity.com/";
    private WebDriver driver;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver",PATHDRIVER+"chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testFlightsSearch() {
        driver.get(baseURL);

        HomeTravelPage home=new HomeTravelPage(driver);
        home.buscarVuelo("Las Vegas (LAS-All Airports)", "Los Angeles, CA (LAX-Los Angeles Intl.)", "07/18/2020", "07/25/2020");
        FlightsResult flightsResult=new FlightsResult(driver);
        Assert.assertEquals(flightsResult.getbuttonDropdown(), "Sort by\n" +
                "Price (Lowest)\n" +
                "Price (Highest)\n" +
                "Duration (Shortest)\n" +
                "Duration (Longest)\n" +
                "Departure (Earliest)\n" +
                "Departure (Latest)\n" +
                "Arrival (Earliest)\n" +
                "Arrival (Latest)");

        flightsResult.getListButtons();
    }

    @AfterSuite
    public void close(){
        driver.close();
        driver.quit();
    }

}
