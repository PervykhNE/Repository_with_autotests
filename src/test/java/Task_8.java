import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Task_8 extends CaseBase{
    @Test
    public void Task_8 () throws Exception {
        driver.get("http://localhost/litecart");
        List<WebElement> good = driver.findElements(By.cssSelector("li.product"));
        for (int a = 0; a < good.size(); a++){
            WebElement Sticker = good.get(a);
            if(Sticker.findElements(By.cssSelector(".sticker")).size() != 1){
                throw new Exception ("Не у каждого товара имеется ровно один стикер");
            }
        }
    }
}
