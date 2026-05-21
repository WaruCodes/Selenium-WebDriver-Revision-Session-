package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {
    WebDriver driver;

    @BeforeMethod
    public void OpenTablePage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void fluentWaitTests(){
        //define Fluent wait with WebDriver instance and maximum timeout
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30)) //Maximum wait time
                .pollingEvery(Duration.ofSeconds(2)) //polling interval frequency to check the condition
                        .ignoring(NoSuchElementException.class); // exception to ignore (optional)

        driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']")).click();

        WebElement fluentWaitElement = wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//*[@id='j_idt87:j_idt90']/span"));
            }
            });

        String newBtnText = fluentWaitElement.getText();
        System.out.println("New btn text is : " + newBtnText);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
