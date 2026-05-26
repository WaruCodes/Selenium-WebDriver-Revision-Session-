import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFileExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(4000);
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement downloadBtn = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadBtn.click();
        Thread.sleep(3000);

        //Use Java to check the downloaded file are there or not
        File file = new File("F:\\Downloads");
        File[] totalFiles = file.listFiles(); // store all files in download folder in a array
        for (File findFile:totalFiles){ // get the file by file from array
            if(findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded");
                break;
            }
        }

    }

    @Test
    public void fileDownloadTest2() throws InterruptedException, AWTException {
        driver.get("https://www.leafground.com/file.xhtml");

        //1st Way using Robot Class
        WebElement uploadBtn = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadBtn.click();

        //Windows control begins here
        String data = "F:\\Downloads\\download.jpg";
        StringSelection selection = new StringSelection(data);
        //Coping the path to the clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null); // default toolkit eke thiyena clipboard eka gattha

        Thread.sleep(4000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent. VK_CONTROL);
        robot.keyPress(KeyEvent. VK_V);
        robot.keyRelease(KeyEvent. VK_V);
        robot.keyRelease(KeyEvent. VK_CONTROL);

        Thread.sleep(3000);
        robot.keyPress(KeyEvent. VK_ENTER);
        robot.keyRelease(KeyEvent. VK_ENTER);

        //2nd way - Using sendkeys (Applicable only element type is file) - input type - file
        /*String data = "F:\\Downloads\\download.jpg";
        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys(data);*/



    }
}
