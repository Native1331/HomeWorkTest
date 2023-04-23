import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static java.lang.String.valueOf;
import static org.testng.Assert.assertEquals;

public class MyTestWithEnum {
    private static final String BASE_URL = "https://magento.softwaretestingboard.com/";
    ListOfItems listOfItems;
      

    @Parameters({"ListOfItems"})
    @Test
    public void prametertestFindListOfItem(ListOfItems) {
         ChromeDriver driver = new ChromeDriver();
        driver.get(BASE_URL);
        WebElement textFieldForSearchItems = driver.findElement(By.name("q"));
        String text = textFieldForSearchItems.getText(valueOf(listOfItems));
        {
            
        }


        Thread.sleep(2000);
    }
}



