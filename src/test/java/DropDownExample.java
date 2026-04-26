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
        driver.get("https://www.leafground.com/select.xhtml");
    }

    @Test
    public void leafgroundpageDropDownTest(){
        //1.1) Ways of select values in basic dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        select.selectByVisibleText("Playwrite");

        //1.2) Get the number of dropdown option
        List<WebElement> listofOptions = select.getOptions();
        int size = listofOptions.size();
        System.out.println("Number of element in the drop down : " + size);

        for (WebElement element:listofOptions){
            System.out.println(element.getText());
        }

        //1.3) Using sendkeys select dropdown value


        //1.4) Selecting value in a boostrap dropdown
    }


    //2) Google search - pick a value from suggestion
    //3) Handle Hidden Auto Suggestion DropDown and Search using DOM Debugger Track
}
