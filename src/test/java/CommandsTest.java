import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new SafariDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's enabled!"));
        System.out.println("Input field enabled and text visible");

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//button[@onclick='swapInput()']"), "Disable"));
        System.out.println("Button text changed successfully");

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bootcamp");


        driver.findElement(By.xpath("//input[@type='text']")).clear();

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-a")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-b")));


        int columnAY = driver.findElement(By.id("column-a")).getLocation().getY();
        int columnBY = driver.findElement(By.id("column-b")).getLocation().getY();

        if (columnAY == columnBY) {
            System.out.println("Columns A and B aligned successfully");
        } else {
            System.out.println("Columns A and B are not aligned");
        }



        driver.close();


    }
}
