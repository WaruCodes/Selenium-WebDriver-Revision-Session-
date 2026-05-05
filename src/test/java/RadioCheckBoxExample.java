import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("Default select radio button is : " + chromeText);
        }else if(firefoxradioOption){
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Default select radio button is : " + firefoxText);
        }else if(safariradioOption){
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Default select radio button is : " + safariText);
        } else if(edgeradioOption){
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Default select radio button is : " + edgeText);
        }

        //standard way
        List<WebElement> radioElements = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
        int radioCount = radioElements.size();
        System.out.println("Radio size : " + radioCount);

        int index = -1;

        for (WebElement radioElement: radioElements){
            index++;
            if (radioElement.isSelected()){
                WebElement defaultSelectedRadioButton = driver.findElement(By.xpath("//label[@for='j_idt87:console2:" + index + "']"));
                String defaultSelectedRadioButtonText = defaultSelectedRadioButton.getText();
                System.out.println("Default selected radio button text : " + defaultSelectedRadioButtonText);
                break;
            }
        }

        //02) Select the age group (only if not selected)
        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0")); // If you are in 1-20 age group
        boolean isChecked = myAgeGroup.isSelected();
        if(!isChecked){
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']"));
        }

        // 2nd Way
        String myAge = "1-21 Years";

        List<WebElement> ageGroups = driver.findElements(By.xpath("//div[@id = 'j_idt87:age']//label"));

        for(WebElement element:ageGroups) {
            String ageGroupText = element.getText();
            if(ageGroupText.equals(myAge)){
                WebElement myAgeRadioOption = driver.findElement(By.xpath("//label[text()='" + ageGroupText + "']/parent::div//input"));
                if(!myAgeRadioOption.isSelected()){
                    element.click();
                }
                break;
            }
        }
    }

    @Test
    public void checkboxTests(){
        //01) Select wanted checkbox and Verifying those check boxes in selected status

        //01.01) Select wanted checkbox first
        //Take all items into a list and call one by one to them n select all check boxes without 'others' checkbox
        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for(WebElement element:checkBoxList){
            if(!(element.getText().equals("Others"))){
                element.click();
            }
        }

        //Verify the checkboxes are in selected status
        for(int i=1; i<= checkBoxList.size(); i++){
            boolean checkBoxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i + "]")).isSelected();
            System.out.println("Checkbox" + i + "selected status is : " + checkBoxStatus );
        }
    }

}
