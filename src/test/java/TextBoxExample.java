import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.leafground.com/");
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void textBoxTests(){
        //01)Type your name
        driver.findElement(By.id("j_idt88:name")).sendKeys("Warushika");

        //02)Append country to this city
        driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("Sri Lanka");

        //03) Verify if text box is disabled
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is text box is enabled: " + enabled);

        //04)Clear the typed test


    }
}
