import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class FirstTest extends CaseBase {

    @Test
    public void firstTest(){
        driver.get("https://www.bing.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }

}
