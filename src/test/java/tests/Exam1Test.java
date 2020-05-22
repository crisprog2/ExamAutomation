package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.FlightDeparture;
import pages.FlightReturn;
import pages.HomeTravelPage;

//Esta clase define el escenario a probar
public class Exam1Test  {

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

    @Test //define un caso de prueba
    public void testFlightsSearch() {
        driver.get(baseURL);
        HomeTravelPage home=new HomeTravelPage(driver);

        //Ejecuta la busqueda del vuelo en la pagina home
        home.buscarVuelo("Las Vegas (LAS-All Airports)", "Los Angeles, CA (LAX-Los Angeles Intl.)");
        FlightDeparture flightDeparture =new FlightDeparture(driver);


        //Realiza la validación de que hay un dropdown en la página de vuelos
        Assert.assertEquals(flightDeparture.getbuttonDropdown(), "Sort by\n" +
                "Price (Lowest)\n" +
                "Price (Highest)\n" +
                "Duration (Shortest)\n" +
                "Duration (Longest)\n" +
                "Departure (Earliest)\n" +
                "Departure (Latest)\n" +
                "Arrival (Earliest)\n" +
                "Arrival (Latest)");

        /*
        //Realiza la validación de que están los botones "Select" en todos los resultados en la página de vuelos
        for (int i = 0; i < flightDeparture.getListButtons().size(); i++) {
            System.out.println(flightDeparture.getListButtons().get(i).getText());
            Assert.assertTrue(flightDeparture.getListButtons().get(i).getText().contains("Select"));
        }
        //Realiza la validación de que la duración del vuelo está presente en todos resultados en la página de vuelos
        for (int i = 0; i < flightDeparture.getListFlightDuration().size(); i++) {
            System.out.println(flightDeparture.getListFlightDuration().get(i).getText());
            Assert.assertTrue(!flightDeparture.getListFlightDuration().get(i).getText().isEmpty());
        }

        //Realiza la validación de que los links de flight details están presente en todos resultados en la página de vuelos
        for (int i = 0; i < flightDeparture.getListLinkFlightBagageDetail().size(); i++) {
            System.out.println(flightDeparture.getListLinkFlightBagageDetail().get(i).getText());
            Assert.assertTrue(flightDeparture.getListLinkFlightBagageDetail().get(i).getText().contains("Details & baggage fees"));
        }*/

        //Realiza la acción de filtrar por duración
        flightDeparture.sortByDuration();

        //Realiza la acción de seleccionar el primer resultado después de que se filtra por la duración
        flightDeparture.selectResult();


        FlightReturn flightReturn =new FlightReturn(driver);

        flightReturn.selectResult();

    }




    @AfterSuite
    public void close(){
        driver.close();
        driver.quit();
    }

}
