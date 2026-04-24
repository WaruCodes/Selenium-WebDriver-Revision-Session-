import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.leafground.com/");
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTests() {
        //1) Click and Confirm the title
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)); {
            System.out.println("Actual title is same as expected");
        }else{
            System.out.println("Actual title is not same as expected");
        }

        //Using TestNG
        Assert.assertEquals("actualTitle", "expectedTitle", "Title miss matched");

        //2) Find the position of the submit button
        driver.navigate().back(); // again come back to the testing page after completing 01st test case

        //3) Find the save button colour
    }

}
