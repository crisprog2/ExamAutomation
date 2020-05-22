package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightReturn {

    private WebDriver driver;
    private WebDriverWait wait;

    public FlightReturn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, 10);
    }

    /**
     * Localizadores para la página Flights de https://www.travelocity.com/
     */
    @FindBy(id = "titleBar")
    private WebElement titleBar;

    @FindBy(id = "flightModuleList")
    private WebElement listaResultadoElementos;

    public void selectResult() {
        wait.until(ExpectedConditions.visibilityOfAllElements(listaResultadoElementos));
        List<WebElement> allElementsInList=listaResultadoElementos.findElements(By.tagName("li"));
        List<WebElement> allButttonsInLi=allElementsInList.get(2).findElements(By.tagName("button"));
        allButttonsInLi.get(0).click();
        /*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html//ul[@id='flightModuleList']/li[3]/div[@class='basic-economy-tray uitk-grid']/div//button[@type='button']")));
        WebElement boton2=driver.findElement(By.xpath("/html//ul[@id='flightModuleList']/li[3]/div[@class='basic-economy-tray uitk-grid']/div//button[@type='button']"));
        boton2.click();*/
        driver.findElement(By.linkText("No thanks Opens in a new tab.")).click();


    }


}
