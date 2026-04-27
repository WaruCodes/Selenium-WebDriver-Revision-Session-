import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void dropDownTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.leafground.com/");
    }

    @Test
    public void leafgroundpageDropDownTest(){
        //1.1) Ways of select values in basic dropdown
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        select.selectByVisibleText("Playwright");

        //1.2) Get the number of dropdown option
        List<WebElement> listofOptions = select.getOptions();
        int size = listofOptions.size();
        System.out.println("Number of element in the drop down : " + size);

        for (WebElement element:listofOptions){
            System.out.println(element.getText());
        }

        //1.3) Using sendkeys select dropdown value
        dropDown.sendKeys("Puppeteer");

        //1.4) Selecting value in a boostrap dropdown
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listofdropdown2values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']//li"));
        for(WebElement element:listofdropdown2values){
            String dropDownvalue = element.getText();
            if(dropDownvalue.equals("USA")){
                element.click();
                break;
            }
        }
    }

    //2) Google search - pick a value from suggestion
    @Test
    public void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> googlesearchList = driver.findElements(By.xpath("//ul[@role = 'listbox']//li//div[@class =  'wM6W7d']"));
        System.out.println(googlesearchList.size());
        for(WebElement element:googlesearchList){
            System.out.println(element.getText());
        }

    }

    //3) Handle Hidden Auto Suggestion DropDown and Search using DOM Debugger Trick

}
