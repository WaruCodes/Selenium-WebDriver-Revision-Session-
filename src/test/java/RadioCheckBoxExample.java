import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioCheckBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void RadioCheckBoxBeforeTests(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.leafground.com/");
        //driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void radioTests(){
        //01) Find the default selected radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeradioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxradioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariradioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeradioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        //basic way

        if(chromeradioOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0'")).getText();
            System.out.println("Default select radio button is : " + chromeText);
        }else if(firefoxradioOption){
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1'")).getText();
            System.out.println("Default select radio button is : " + firefoxText);
        }else if(safariradioOption){
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2'")).getText();
            System.out.println("Default select radio button is : " + safariText);
        } else if(edgeradioOption){
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3'")).getText();
            System.out.println("Default select radio button is : " + edgeText);
        }

        //standard way

        //02) Select the age group (only if not selected)
    }

    @Test
    public void checkboxTests(){
        //01) Select wanted checkbox and Verifying those check boxes in selected status
    }

}
