package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWikiPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //localizadores
    @FindBy(id = "searchInput")
    private WebElement searchinput;

    @FindBy(xpath = "//form[@id='search-form']//button[@class='pure-button pure-button-primary-progressive']")
    private WebElement searchbutton;

    public HomeWikiPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, 10);
    }

    public void buscar(String busqueda){
        searchinput.sendKeys(busqueda);
        wait.until(ExpectedConditions.elementToBeClickable(searchbutton));
        searchbutton.click();
    }

}
