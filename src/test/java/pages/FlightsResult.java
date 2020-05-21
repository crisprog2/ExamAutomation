package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightsResult {

    private WebDriver driver;
    private WebDriverWait wait;

    public FlightsResult(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, 10);
    }

    /**
     * Localizadores para la página Flights de https://www.travelocity.com/
     */
    @FindBy(id = "titleBar")
    private WebElement titleBar;

    @FindBy(xpath = "/html//div[@id='sortBar']")
    private WebElement buttonDropdown;

    @FindBy(id = "flightModuleList")
    private WebElement listaResultadoElementos;

    public String getPageTitle() {
        return titleBar.getText();
    }

    public String getbuttonDropdown() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//div[@id='sortBar']")));
        return buttonDropdown.getText();
    }

    public List<WebElement> getListButtons(){

        List<WebElement> buttonsSelect=new ArrayList<WebElement>();
        List<WebElement> allButtonsInList=listaResultadoElementos.findElements(By.className("btn-label"));

        for (int i = 0; i < allButtonsInList.size() ; i++) {
            if (allButtonsInList.get(i).getText().contains("Select")){
                buttonsSelect.add(allButtonsInList.get(i));
            }
        }

        return buttonsSelect;
    }

    public List<WebElement> getListFlightDuration(){
        List<WebElement> allSpanInList=listaResultadoElementos.findElements(By.className("duration-emphasis"));
        return allSpanInList;
    }

    public List<WebElement> getListLinkFlightBagageDetail(){
        List<WebElement> allLinks=listaResultadoElementos.findElements(By.tagName("a"));
        List<WebElement> textLink=new ArrayList<WebElement>();
        for (int i = 0; i < allLinks.size() ; i++) {
            if (allLinks.get(i).getText().contains("Details")){
                textLink.add(allLinks.get(i));
            }
        }
        return textLink;
    }

    public void sortByDuration() {
        WebElement dropDownButton=driver.findElement(By.id("sortDropdown"));
        wait.until(ExpectedConditions.elementToBeClickable(dropDownButton));
        dropDownButton.click();
        Select sortDropdown=new Select(driver.findElement(By.id("sortDropdown")));
        sortDropdown.selectByVisibleText("Duration (Shortest)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
