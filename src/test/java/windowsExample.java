import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class windowsExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.leafground.com/");
        driver.get("https://www.leafground.com/window.xhtml");
    }

    @Test
    public void windowTests() throws InterruptedException {
        //1) Click and confirm new window opens

        String oldWindow = driver.getWindowHandle(); // Store parent window
        System.out.println("Parent window : " + oldWindow);

        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("Handles size : " + handles.size());


                //First Method - Using forEach loop
        for(String newWindow:handles){
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("Page title is : " + driver.getTitle());
        }

        driver.close();

        //Check the previous window cameback or not via using an element of the parent window
        driver.switchTo().window(oldWindow);

        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openbuttonVisibility = openButton1.isDisplayed();
        System.out.println("Open button Visibility :" + openbuttonVisibility);

                //Second Method - Using List
        //2) Find the number of open tabs
        //3) Close all the windows except primary window
    }
}



