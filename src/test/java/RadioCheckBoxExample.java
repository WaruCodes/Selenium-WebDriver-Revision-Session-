import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioCheckBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void RadioCheckBoxBeforeTests(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.leafground.com/");
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void radioTests(){
        //01) Find the default selected radio button
        //02) Select the age group (only if not selected)
    }

    @Test
    public void checkboxTests(){
        //01) Select wanted checkbox and Verifying those check boxes in selected status
    }

}
