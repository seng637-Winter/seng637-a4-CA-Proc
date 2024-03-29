// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class ShoppingFunctionalityTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void addProductToCart() {
    driver.get("https://shopsmartcanada.com/smart-choice-1-5-m-5-ft-steam-hose-kit/");
    driver.findElement(By.id("form-action-addToCart")).click();
    assertThat(driver.findElement(By.cssSelector(".cart-item-value")).getText(), is("$35.28"));
  }
  @Test
  public void goToCheckout() {
    driver.get("https://shopsmartcanada.com/");
    driver.findElement(By.cssSelector(".u-hideMobile .\\_single-item")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".u-hideMobile .\\_single-item"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".previewCartAction-checkout > .button")).click();
    assertThat(driver.getTitle(), is("Checkout - Shop Smart Canada"));
  }
  @Test
  public void increaseItemQuantityInCart() {
    driver.get("https://shopsmartcanada.com/");
    driver.findElement(By.cssSelector(".u-hideMobile .\\_single-item")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".u-hideMobile .\\_single-item"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.linkText("Edit Cart")).click();
    driver.findElement(By.cssSelector(".form-increment:nth-child(2) > .button:nth-child(3) svg")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.textToBe(By.cssSelector(".cart-total--subtotal span"), "$70.56"));
    }
    assertThat(driver.findElement(By.cssSelector(".cart-total--subtotal span")).getText(), is("$70.56"));
  }
  @Test
  public void removeProductFromCart() {
    driver.get("https://shopsmartcanada.com/");
    driver.findElement(By.cssSelector(".u-hideMobile .\\_total-price-nav")).click();
    driver.findElement(By.cssSelector(".previewCartItem-remove-icon use")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 1);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".previewCart-emptyBody")));
    }
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".previewCart-emptyBody"));
      assert(elements.size() > 0);
    }
  }
}
