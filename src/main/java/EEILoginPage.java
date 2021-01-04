import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;


public class EEILoginPage {
    public static WebDriver driver;
    public static String url ="https://172.25.119.62:4826";
    @BeforeClass
    public void eeiLoginPage(){
        System.setProperty("webdriver.chrome.driver", "src/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        WebElement advancedButton = driver.findElement(By.id("details-button"));
        advancedButton.click();
        WebElement ip = driver.findElement(By.cssSelector("#proceed-link"));
        ip.click();
    }

}
