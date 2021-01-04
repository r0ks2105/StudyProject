import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlockHash {
    @Test
    @Parameters({"SHA1"})
    public void blockHash(String SHA1) throws InterruptedException {
        EEIConsoleLogin login = new EEIConsoleLogin();
        login.consoleLogin();
       WebElement admin = EEILoginPage.driver.findElement(By.cssSelector("#console\\.admin\\.rules"));
       admin.click();
       WebElement blockedHashes = EEILoginPage.driver.findElement(By.cssSelector("#root > div.Content__content--RXvNGF27wD.sc-jlyJG.gOhEnT > div > div.sc-kfGgVZ.fAQzhC.PageContent__main--W3uPkbUo1l.ei-panel-content-non-standard-style.PageContent__fullHeight--I6kMK50ErQ > div > div.sc-exAgwC.llBFgY > div > div:nth-child(5)"));
       blockedHashes.click();
       WebElement addHashes = EEILoginPage.driver.findElement(By.cssSelector("#commanding-toolbar-left-button-0"));
       addHashes.click();
       WebElement hashesType = EEILoginPage.driver.findElement(By.cssSelector("#eid-list-item-sha1-hashes-header textarea"));
       hashesType.sendKeys(SHA1);
        Thread.sleep(2000);
       try {
           WebElement blockButton = EEILoginPage.driver.findElement(By.cssSelector("#commanding-toolbar-left-button-0"));
           blockButton.click();
           WebElement confirmButton = EEILoginPage.driver.findElement(By.cssSelector("#eid-ei-block-hash__button-blockUntrustedButton"));
           confirmButton.click();
           WebElement doneButton = EEILoginPage.driver.findElement(By.cssSelector("#eid-ei-block-hash__button-doneButton"));
           doneButton.click();
       }
       catch (NoSuchElementException elementException){
            WebElement cancel1 = EEILoginPage.driver.findElement(By.cssSelector("div #btn-grp-modal-button-group-left-undefined-0-0 button"));
            cancel1.click();
            WebElement cancel2 = EEILoginPage.driver.findElement(By.cssSelector("#commanding-toolbar-left-button-1"));
            cancel2.click();
       }

        WebElement blocked = EEILoginPage.driver.findElement(By.cssSelector("#r\\:0\\,\\ c\\:1 > div > div > span > span"));
        String hash = blocked.getText();
        Assert.assertEquals(hash, SHA1);
        System.out.println(hash);
        EEILoginPage.driver.quit();


    }
}
