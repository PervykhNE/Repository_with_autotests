import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Task_11 extends CaseBase {

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private String randEmail() {
        String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
        return email;
    }

    private String randPass() {
        String password = RandomStringUtils.randomAlphabetic(5) + "." + RandomStringUtils.randomAlphanumeric(4);
        return password;
    }

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Task_11() {
        driver.get("http://localhost/litecart/en/create_account");
        assertTrue(isElementPresent(By.cssSelector("form")));
        WebElement form = driver.findElement(By.cssSelector("form"));
        form.findElement(By.cssSelector("[name=tax_id]")).sendKeys("520847501");
        form.findElement(By.cssSelector("[name=company]")).sendKeys("The White Rabbit");
        form.findElement(By.cssSelector("[name=firstname]")).sendKeys("John");
        form.findElement(By.cssSelector("[name=lastname]")).sendKeys("Brown");
        form.findElement(By.cssSelector("[name=address1]")).sendKeys("Baker street 221b");
        form.findElement(By.cssSelector("[name=postcode]")).sendKeys("644043");
        form.findElement(By.cssSelector("[name=city]")).sendKeys("Portland");
        form.findElement(By.cssSelector(".select2-selection")).click();
        driver.findElement(By.cssSelector(".select2-search__field")).sendKeys("United States" + Keys.ENTER);
        form.findElement(By.cssSelector("[name=zone_code] [value=OR]")).click();
        String testEmail = randEmail();
        form.findElement(By.cssSelector("[name=email]")).sendKeys(testEmail);
        form.findElement(By.cssSelector("[name=phone]")).sendKeys("+15036789872");
        String testPassword = randPass();
        form.findElement(By.cssSelector("[name=password]")).sendKeys(testPassword);
        form.findElement(By.cssSelector("[name=confirmed_password]")).sendKeys(testPassword);
        form.findElement(By.cssSelector("[name=create_account]")).click();

        assertTrue(isElementPresent(By.cssSelector("#box-account")));
        driver.findElement(By.cssSelector("#box-account [href*=logout]")).click();

        assertTrue(isElementPresent(By.cssSelector("#box-account-login")));
        WebElement login = driver.findElement(By.cssSelector("#box-account-login"));
        login.findElement(By.cssSelector("[name=email]")).sendKeys(testEmail);
        login.findElement(By.cssSelector("[name=password]")).sendKeys(testPassword);
        login.findElement(By.cssSelector("[name=login]")).click();

        assertTrue(isElementPresent(By.cssSelector("#box-account")));
        driver.findElement(By.cssSelector("#box-account [href*=logout]")).click();
        assertTrue(isElementPresent(By.cssSelector("#box-account-login")));

    }
}

