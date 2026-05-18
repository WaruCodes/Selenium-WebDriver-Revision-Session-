import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class windowsExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.leafground.com/");
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(3000);
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
            // if any the loop needs to stop on any specific window
            //if (driver.getTitle().equals("xyz"){
            //break;
            //}
            System.out.println("Page title is : " + driver.getTitle());
        }

        driver.close();

        //Check the previous window cameback or not via using an element of the parent window
        driver.switchTo().window(oldWindow);

        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openbuttonVisibility = openButton1.isDisplayed();
        System.out.println("Open button Visibility :" + openbuttonVisibility);

                //Second Method - Using List
       /* List<String> list = new ArrayList<String>(handles); //Converting set to the list
        if (list.size()>1) {
            driver.switchTo().window(list.get(1));
            System.out.println("child tab title is : " + driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);
        }

        WebElement openButton2 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openbuttonVisibility2 = openButton1.isDisplayed();
        System.out.println("Open button Visibility :" + openbuttonVisibility2); */

        //2) Find the number of open tabs
        WebElement multiWindowButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
        multiWindowButton.click();
        Thread.sleep(3000);

        Set<String> multiWindows= driver.getWindowHandles();
        int howmanyWindows = multiWindows.size();
        System.out.println("Number of windows open: " + howmanyWindows);

        //3) Close all the windows except primary window
        WebElement dontclosemeButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt93']/span[2]"));
        dontclosemeButton.click();
        Thread.sleep(3000);

        Set<String> newWindowsHandles = driver.getWindowHandles();
        for(String allwindows:newWindowsHandles){
            if(!allwindows.equals(oldWindow)){
                driver.switchTo().window(allwindows);
                driver.close();
            }

            /*driver.switchTo().window(oldWindow); close single browser window driver which on focus
            driver.close();

            driver.quit(); Close all browser windows */

            //04) Wait for 2 new tabs to open
            WebElement waitforWindows = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']/span"));
            waitforWindows.click();
            WebDriverWait webdriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            webdriverWait.until(ExpectedConditions.numberOfWindowsToBe(3));

            int howmanyWindows123 = driver.getWindowHandles().size();
            if (howmanyWindows123==3){
                System.out.println("Able to see 3 windows");
            }else{
                System.out.println("Can't able to see 3 windows");
            }

            driver.quit();

        }
    }
}



