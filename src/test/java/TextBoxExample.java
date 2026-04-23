import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){

        //ChromeOptions chromeOptions = new chromeOptions();
        //chromeOptions.setBrowserVersion("122");
        //chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--incognito");
        //chromeOptions.addArguments("--headless");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.leafground.com/");
        driver.get("https://www.leafground.com/input.xhtml");
        //Thread.sleep(3000); - To Resolve the error click on add exception to method signature
    }

    @Test
    public void textBoxTests(){
        //01)Type your name
        WebElement name= driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Warushika");

        //02)Append country to this city
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("Sri Lanka");

        //03) Verify if text box is disabled
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is text box is enabled: " + enabled);

        //04)Clear the typed test
        WebElement clearText = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        clearText.clear();

        //05) Retrieve the typed text
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);

        //06) Type email and tab. Confirm control moved to next element.
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("warushikarashmi@gmail.com" + Keys.TAB + "Confirm control moved to next element."); //Direct mehema dannath puluwan. Nattam webElement ekaka store karala gannath puluwan.
    }
}
