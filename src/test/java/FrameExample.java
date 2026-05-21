import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void frameTests(){
        //1)Click me (inside frame)

        driver.switchTo().frame(0); // switch to the frame cuz driver can only access to DOM elements
        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String afterClickButtonText = button1.getText();
        System.out.println("After click inside frame button text : " + afterClickButtonText);

        //2)Click me (inside nested frame)

        //nested frame - need to switch two times
        driver.switchTo().defaultContent(); // Come back to the html page after perform 1st action in the frame one

        driver.switchTo().frame(2); // switch to the frame 2
        driver.switchTo().frame("frame2"); // switch to child frame

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedFrameButtonClick = button3.getText();
        System.out.println("After click inside nested frame button text : " + afterClickNestedFrameButtonClick);

        //3)How many frames in this page

        driver.switchTo().defaultContent();
        List<WebElement> getIFrameTagCount = driver.findElements(By.tagName("iframe"));
        int size = getIFrameTagCount.size();
        System.out.println("Iframe tag count : " + size);

        for(WebElement iframeElement :getIFrameTagCount){
            String frameSRCattributeValue = iframeElement.getAttribute("src");
            System.out.println("Frame SRC attribute value : " + frameSRCattributeValue);
        }

    }
}
