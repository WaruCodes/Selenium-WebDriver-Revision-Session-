import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();
        Dimension size = new Dimension(800, 600);
        driver.manage().window().setSize(size);
        //driver.manage().window().maximize();
        //driver.get("https://www.leafground.com/");
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTests() {
        //1) Click and Confirm the title
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)) {
            System.out.println("Actual title is same as expected");
        }else{
            System.out.println("Actual title is not same as expected");
        }

        //Using TestNG
        //Assert.assertEquals("actualTitle", "expectedTitle", "Title miss matched");

        //2) Find the position of the submit button
        driver.navigate().back(); // again come back to the testing page after completing 01st test case
        WebElement getPosition = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt94']"));
        Point xyPoint = getPosition.getLocation(); // click the ctrl + webelement to find where need to store
        int x = xyPoint.getX(); // hover cursor on the () to find the return type
        int y = xyPoint.getY();
        System.out.println("X position is : " + x + "Y position is : " + y);

        //3) Find the save button colour
        WebElement buttonColour = driver.findElement(By.id("j_idt88:j_idt96"));
        String colour = buttonColour.getCssValue("background-color");
        System.out.println("Button colour is : " + colour);

        //04) Find the height and Width of this button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight(); // method chaining = chaining methods using dots
        int width = size.getSize().getWidth();
        System.out.println("Height : " + height + "Width : " + width);

    }

}
