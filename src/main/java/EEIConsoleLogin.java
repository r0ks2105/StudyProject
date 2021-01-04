import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class EEIConsoleLogin {
    protected EEILoginPage eeiLoginPage;
    private String userName = "Administrator";
    private String password = "Passw0rd";


    @Test
    public void consoleLogin() throws InterruptedException {
        EEILoginPage eeiLoginPage =new EEILoginPage();
        eeiLoginPage.eeiLoginPage();
        WebElement loginInput = eeiLoginPage.driver.findElement(By.cssSelector(".FormGroup__inputGroup--JEHjdgNtNv #eei-username"));
        loginInput.sendKeys(userName);
        WebElement passwordInput = eeiLoginPage.driver.findElement(By.xpath("//div/input[@placeholder='Password']"));
        passwordInput.sendKeys(password);
        passwordInput.submit();
        Assert.assertEquals(eeiLoginPage.driver.getTitle(), "Login - ESET Enterprise Inspector");
        System.out.println(eeiLoginPage.driver.getTitle());
        Thread.sleep(1000);
    }
    @AfterMethod
    public static void closeChrome(){
        EEILoginPage.driver.quit();
    }
}

