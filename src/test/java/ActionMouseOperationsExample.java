import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMouseOperationsExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void mouseOperationsExample1() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");

        System.out.println("01) Move to an element operation");

        //Initialize the Action class
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform(); // method chaining

        System.out.println("02) Drag and Drop Operation");

        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        //action.clickAndHold(from).moveToElement(to).release(to).perform(); // 1st way
        action.dragAndDrop(from, to).perform(); // 2nd way

        System.out.println("03) Slider operation");

        WebElement sliderPoint1 = driver.findElement(By.xpath("//div[@id='form:j_idt125']/span[1]"));
        System.out.println( "Location of Sliderpoint1 before move" + sliderPoint1.getLocation());
        action.dragAndDropBy(sliderPoint1, 30, 0).perform(); // move
        System.out.println("Location of Sliderpoint1 after move: " + sliderPoint1.getLocation());

    }

    @Test
    public void mouseOperationsTest2(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        System.out.println("04) Right Click ");

        WebElement rightClickButtonElement = driver.findElement(By.xpath(" //span[@class='context-menu-one btn btn-neutral']"));
        Actions action1 = new Actions(driver);
        action1.contextClick(rightClickButtonElement).perform(); // if u need double click write doubleclick and remove the contextclick

        //after right click, click on edit and then alert is showing
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alertpop = driver.switchTo().alert();
        System.out.println("Alert shows the text as : " + alertpop.getText()); // print the text on the alert
        alertpop.accept(); // accept the alert
    }
}
