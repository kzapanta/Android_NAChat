import com.sun.xml.internal.xsom.impl.scd.Iterators;
import io.appium.java_client.AppiumDriver;
import jdk.nashorn.internal.runtime.ECMAException;
import org.apache.commons.io.IOExceptionWithCause;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;

/**
 * Created by M.Manalo
 */

public class globfunc {

    public void login(AppiumDriver driver, String u, String p) throws Exception{

        WebElement loginFields = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/username")));
        loginFields.sendKeys(u);

        loginFields = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/password")));
        loginFields.sendKeys(p);

        WebElement loginButton = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/login")));
        loginButton.click();

        Thread.sleep(10000);

    }

    public void logout(AppiumDriver driver) throws Exception {

        gotoSettings(driver);
        driver.findElement(By.id(varFile.env+"id/logout")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(10000);

    }

    public void recipient(AppiumDriver driver) throws Exception{

        WebElement searchFriend = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/search")));
        searchFriend.sendKeys(varFile.friend);

        WebElement select = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/name")));
        select.click();

        Thread.sleep(10000);

    }

    public void backbutton(AppiumDriver driver) throws Exception {

        driver.findElement(By.id(varFile.env+"id/back")).click();
        Thread.sleep(5000);

    }

    public void gotoFriends (AppiumDriver driver) throws Exception {

        WebElement msgTab = (new WebDriverWait(driver, 120))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("Friends")));
        Thread.sleep(3000);
        msgTab.click();
        Thread.sleep(5000);
    }


    public void gotoMessages (AppiumDriver driver) throws Exception {

        WebElement msgTab = (new WebDriverWait(driver, 120))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("Messages")));
        Thread.sleep(5000);
        msgTab.click();
        Thread.sleep(5000);
    }

    public void gotoGroups (AppiumDriver driver) throws Exception {

        WebElement msgTab = (new WebDriverWait(driver, 120))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("Groups")));
        Thread.sleep(5000);
        msgTab.click();
        Thread.sleep(5000);
    }

    public void gotoMe (AppiumDriver driver) throws Exception {

        driver.findElement(By.name("Me")).click();
        Thread.sleep(3000);
    }

    public void gotoSettings (AppiumDriver driver) throws Exception {

        driver.findElement(By.name("Settings")).click();
        Thread.sleep(5000);
    }

    public void scrollBottomtoTop(AppiumDriver driver) throws Exception {
        try {
            Dimension dimensions = driver.manage().window().getSize();

            System.out.println("----------------");
            System.out.println("Size of screen= " +dimensions);
            int starty = (int) (dimensions.getHeight() * 0.80);
            int endy = (int) (dimensions.getHeight() * 0.20);
            int startx = (int) (dimensions.getWidth() / 2);
            driver.swipe(10, endy, startx, starty, 3000);
            //driver.swipe(startx, endy, startx, starty, 5000);

        } catch (Exception e) {

        }
    }

    public void scrollDown(AppiumDriver driver) throws Exception {
        try {
            Dimension dimensions = driver.manage().window().getSize();
            System.out.println("----------------");
            System.out.println("Size of screen= " +dimensions);
            int Startpoint = (int) (dimensions.getHeight() * 0.5);
            System.out.println("Size of scrollStart= " +Startpoint );
            int scrollEnd = (int) (dimensions.getHeight() * 0.2);
            System.out.println("Size of cscrollEnd= " + scrollEnd);
            driver.swipe(0, Startpoint,0,scrollEnd,1000);

        } catch (Exception e) {

        }
    }

/*    public boolean friendExist(AppiumDriver driver) throws Exception {

        boolean isElement = false;

        try
        {
            if (driver.findElement(By.id(varFile.env+"id/contentContainer")).isDisplayed())
            {
                isElement = true;
                return isElement;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Element not found");
            isElement = false;
            return isElement;
        }
        return isElement;
    }
*/

    public void searchFriends(AppiumDriver driver, String user) throws Exception {

        gotoFriends(driver);

        WebElement str = (new WebDriverWait(driver, 120))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/search")));
        Thread.sleep(3000);
        str.click();
        str.clear();
        str.sendKeys(user);
        Thread.sleep(4000);
    }

    public void moreButton (AppiumDriver driver) throws Exception {

        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(5000);
    }

    public void mobileLogin(AppiumDriver driver) throws Exception {

        WebElement mobileLoginButton = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/mobileLogin")));
        Thread.sleep(5000);

        mobileLoginButton.click();
        Thread.sleep(5000);
    }

}
