import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class FirstTest extends TestBase {

        @Test
        public void firstTest(){
            driver.get("https://www.bing.com/");
            driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
        }

}
