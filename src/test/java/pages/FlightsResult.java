package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FlightsResult {

    private WebDriver driver;
    private WebDriverWait wait;

    public FlightsResult(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, 20);
    }

    /**
     * Localizadores para la página Flights de https://www.travelocity.com/
     */
    @FindBy(id = "titleBar")
    private WebElement titleBar;

    @FindBy(xpath = "/html//div[@id='sortBar']")
    private WebElement buttonDropdown;

    @FindBy(xpath = "/html//ul[@id='flightModuleList']/li[1]/div[1]/div[1]//button[@type='button']")
    private WebElement buttonSelect;

    @FindBy(id = "flightModuleList")
    private WebElement listaResultadoElementos;


    public String getPageTitle() {
        return titleBar.getText();
    }

    public String getbuttonDropdown() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//div[@id='sortBar']")));
        return buttonDropdown.getText();
    }

    public void getbuttonsListResult(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonSelect));
        //return buttonSelect.getText();
    }

    public void getListButtons(){

        List<WebElement> allLi=listaResultadoElementos.findElements(By.className("btn-label"));
        List<WebElement> specifiedListLi=new ArrayList<WebElement>();
        System.out.println(allLi.size());
        for (int i = 0; i < allLi.size(); i++) {
            System.out.println(allLi.get(i).getText());
            System.out.println();
        }
    }

}
