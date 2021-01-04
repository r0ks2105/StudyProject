import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddComment {
    @Test
    public void addComment() throws InterruptedException {
        EEIConsoleLogin login = new EEIConsoleLogin();
        login.consoleLogin();
        WebElement computers = EEILoginPage.driver.findElement(By.xpath("//a[@id='console.machines']"));
        computers.click();
        WebElement comp1 = EEILoginPage.driver.findElement(By.xpath("//*[@id='r:0, c:0']/div/div/span"));
        comp1.click();
        WebElement addComment = EEILoginPage.driver.findElement(By.xpath("//*[@id=\"eid-list-item-header\"]/div/span/a/span"));
        addComment.click();
        WebElement textField = EEILoginPage.driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div[16]/div[2]/div[2]/textarea"));
        textField.sendKeys("My test comment!!!");
        Thread.sleep(1000);
        WebElement saveButton = EEILoginPage.driver.findElement(By.xpath("//button[@id='eid-comment-button-save']"));
        saveButton.click();
        JavascriptExecutor js = (JavascriptExecutor) EEILoginPage.driver;
        js.executeScript("arguments[0].scrollIntoView()", addComment);
        Thread.sleep(1000);
        WebElement testComment = EEILoginPage.driver.findElement(By.xpath("//*[@id=\"eid-list-item-header\"]/div/span"));
        String comment = testComment.getText();
        Assert.assertEquals(comment,"My test comment!!!");
        System.out.println(comment);
        login.closeChrome();
    }
}
