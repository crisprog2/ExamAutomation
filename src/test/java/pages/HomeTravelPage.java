package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void buscarVuelo(String aeropuertoSalida, String aeropuertoLLegada, String fechaSalida, String fechaLLegada){
        wait.until(ExpectedConditions.elementToBeClickable(flightButton));
        flightButton.click();
        flyingFrom.clear();
        flyingFrom.sendKeys(aeropuertoSalida);
        flyingTo.clear();
        flyingTo.sendKeys(aeropuertoLLegada);
        departingDate.clear();
        departingDate.sendKeys(fechaSalida);
        returningDate.clear();
        returningDate.sendKeys(fechaLLegada);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
        buttonSearch.click();
    }

}
