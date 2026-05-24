import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionKeyBoardExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void keyBoardActionsTest1() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement googleSearchTextBox = driver.findElement(By.name("q"));
        googleSearchTextBox.sendKeys("WelCome");

        //For the Action class create a method
        Actions actions = new Actions(driver);
        Action storeBuildOperation = actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();
        storeBuildOperation.perform(); // if not we can use perform directly without store the build operation in the action

        Thread.sleep(5000);

        actions.keyDown(Keys.SHIFT)
                .sendKeys("writing capital sentences")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .build().perform();

        //To write in capital in the text box using JAVA method overloading concept
    }

    @Test
    public void keyBoardActionsTest2(){
        driver.get("https://www.leafground.com/link.xhtml");
    }
}
