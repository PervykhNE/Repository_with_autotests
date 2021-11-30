import org.junit.Test;
import static org.openqa.selenium.By.cssSelector;

public class Task_7 extends CaseBase {
    @Test
    public void Task_7 (){
        driver.get("http://localhost/litecart/admin");
        driver.findElement(cssSelector("#box-login [name = username]")).sendKeys("admin");
        driver.findElement(cssSelector("#box-login [name = password]")).sendKeys("admin");
        driver.findElement(cssSelector(".footer [name = login]")).click();
        for (int a = 0; a < driver.findElements(cssSelector("#box-apps-menu #app-")).size(); a++){
            driver.findElements(cssSelector("#box-apps-menu #app-")).get(a).click();
            driver.findElement(cssSelector("h1"));
            if(driver.findElements(cssSelector("#box-apps-menu #app-.docs")).size()!=0){
                for(int b = 0; b < driver.findElements(cssSelector("#box-apps-menu #app-.docs li")).size(); b++){
                    driver.findElements(cssSelector("#box-apps-menu #app-.docs li")).get(b).click();
                    driver.findElement(cssSelector("h1"));
                }
            }
        }
    }
}
