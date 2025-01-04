package PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class openMap {
    WebDriver driver;
    WebDriverWait wait;

    public openMap(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='searchboxinput']")
    WebElement searchboxinput;
    @FindBy(id = "searchbox-searchbutton")
    WebElement searchboxbutton;
    @FindBy(xpath = "//h1[normalize-space()='Kempegowda International Airport Bengaluru']")
    WebElement searchOutput;

    @FindBy(xpath = "//button[@id='hArJGc']")
    WebElement directionBtn;
    @FindBy(xpath = "//input[@placeholder='Choose starting point, or click on the map...']")
    WebElement startingPoint;
    @FindBy(xpath = "//input[@placeholder='Choose destination, or click on the map...']")
    WebElement destinationPoint;
    @FindBy(xpath = "//button[@data-tooltip='Driving']")
    WebElement drivingBtn;
    @FindBy(xpath = "//div[@class='Fl2iee']//span[not(@style='display:none')]")
    WebElement estimateTime;
    @FindBy(xpath = "//div[@id='section-directions-trip-0']")
    WebElement route;

    public void clickDirectionBtn(){
        directionBtn.click();
    }

    public void enterStartingPoint(String text){
        startingPoint.sendKeys(text);
    }
    public void enterDestinationPoint(String text){
        destinationPoint.sendKeys(text);
    }
    public void clickDrivingBtn(){
        drivingBtn.click();
        System.out.println("Enter method");
    }

    public boolean showRoute(){
        return route.isDisplayed();
    }

    public String getEstimateTime(){
        return estimateTime.getText();
    }
    public void searchDestination(String text){
        System.out.printf("Enter text :- "+text);
        searchboxinput.sendKeys(text);
        searchboxbutton.click();
    }

    public String searchOutput(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Method Call Search Output :- "+searchOutput.getText());
        return searchOutput.getText();
    }

}

