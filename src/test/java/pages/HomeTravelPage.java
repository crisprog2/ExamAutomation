package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeTravelPage {

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Localizadores para la página Home de https://www.travelocity.com/
     */
    @FindBy(id = "tab-flight-tab-hp")
    private WebElement flightButton;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement flyingFrom;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement flyingTo;

    @FindBy(id = "flight-departing-hp-flight")
    private WebElement departingDate;

    @FindBy(xpath = "/html//div[@id='flight-departing-wrapper-hp-flight']//div[@class='datepicker-cal']/button[2]")
    private WebElement buttonNextDateCalendarDeparting;

    @FindBy(xpath = "/html//div[@id='flight-departing-wrapper-hp-flight']//div[@class='datepicker-cal']/div[3]")
    private WebElement monthRightDeparting;

    @FindBy(xpath = "/html//div[@id='flight-returning-wrapper-hp-flight']//div[@class='datepicker-cal show-second-month']/div[3]")
    private WebElement monthRightReturning;

    @FindBy(id = "flight-returning-hp-flight")
    private WebElement returningDate;

    @FindBy(xpath = "/html//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']")
    private WebElement buttonSearch;

    /**
     * Constructor para HomeTravelPage
     * @param driver
     */
    public HomeTravelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, 10);
    }

    public void buscarVuelo(String aeropuertoSalida, String aeropuertoLLegada, String fechaSalida, String fechaLLegada) {
        wait.until(ExpectedConditions.elementToBeClickable(flightButton));
        flightButton.click();

        flyingFrom.sendKeys(aeropuertoSalida);
        flyingTo.sendKeys(aeropuertoLLegada);

        departingDate.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        buttonNextDateCalendarDeparting.click();
        buttonNextDateCalendarDeparting.click();
        List<WebElement> calendarMonthDeparting=monthRightDeparting.findElements(By.tagName("button"));
        WebElement dayMonthDeparting=calendarMonthDeparting.get(3);
        dayMonthDeparting.click();

        returningDate.click();
        List<WebElement> calendarMonthReturning=monthRightReturning.findElements(By.tagName("button"));
        WebElement dayMonthReturning=calendarMonthReturning.get(5);
        dayMonthReturning.click();

        wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
        buttonSearch.click();

    }

}
