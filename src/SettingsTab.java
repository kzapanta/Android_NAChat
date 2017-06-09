import com.sun.jna.platform.win32.WinDef;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by K.Zapanta
 * Updated by M.Manalo
 */

public class SettingsTab extends AppiumSetup {

    globfunc glob = new globfunc();

    @Test(priority=1)
    private void friendRequestNotif() throws Exception{

        // login first
        glob.login(driver, varFile.validUsernameField, varFile.validPasswordField);

        glob.gotoSettings(driver);
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/request")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Received")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Sent")).click();
        Thread.sleep(3000);
        glob.backbutton(driver);
        Thread.sleep(3000);

    }

    @Test(priority=2)
    private void addFriend() throws Exception{

        driver.findElement(By.id(varFile.env+"id/request")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Received")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/button_add_friend")).click();
        Thread.sleep(3000);
        WebElement searchFields = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/search")));
        searchFields.sendKeys(varFile.addUser);
        driver.findElement(By.id(varFile.env+"id/searchButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/contentContainer")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/addButton")).click();
        Thread.sleep(10000);
        glob.backbutton(driver);
        driver.navigate().back();
        Thread.sleep(3000);
        glob.gotoSettings(driver);
        Thread.sleep(5000);
        driver.findElement(By.id(varFile.env+"id/request")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Sent")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/moreButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/layout_cancel")).click();
        Thread.sleep(3000);
        glob.backbutton(driver);

    }

    @Test(priority=3)
    private void messageSettings() throws Exception{

        System.out.println("Message Settings: -- This is just to test Message Settings ON/OFF and NOT functionality...");
        Thread.sleep(2000);
        driver.findElement(By.id(varFile.env+"id/switch_privacy")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/switch_privacy")).click();
        Thread.sleep(3000);
    }

    @Test(priority=4)
    private void blockUser() throws Exception{

        driver.findElement(By.id(varFile.env+"id/block")).click();
        Thread.sleep(3000);

        /*
        WebElement searchFields = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/edit_block"))); */

        /*
        char[] block = varFile.blockUser.toCharArray();
        String blockUser1 = "";
        for(int i=0; i < block.length; i++)
        {
            blockUser1 += block[i];

            System.out.println(blockUser1);
            searchFields.sendKeys(""+blockUser1);
            Thread.sleep(2000);
        } */

        /*
        for(int i=0;i<ch.length;i++){
            System.out.print(ch[i]);
        } */

        driver.findElement(By.id(varFile.env+"id/edit_block")).sendKeys(varFile.blockUser);
        Thread.sleep(15000);
        driver.findElement(By.id(varFile.env+"id/imageAvatar")).click();
        Thread.sleep(5000);
        driver.findElement(By.id(varFile.env+"id/button_block")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(5000);

        String blockedTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        assertEquals("Blocked User",blockedTitle);

        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(5000);
        glob.backbutton(driver);
        Thread.sleep(5000);
    }


    @Test (priority=5)
    private void viewTermsOfService() throws Exception{

        driver.findElement(By.id(varFile.env+"id/terms")).click();
        Thread.sleep(5000);

        String gettermsTitle = driver.findElement(By.id(varFile.env+"id/title")).getText();

        System.out.println("Assert terms of service title ...");
        assertEquals(gettermsTitle, varFile.termsTitle);

        glob.scrollDown(driver);
        glob.scrollDown(driver);
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/back")).click();
        Thread.sleep(5000);

    }

    @Test (priority=6)
    private void viewAboutNAChat() throws Exception {

        driver.findElement(By.id(varFile.env+"id/about")).click();
        Thread.sleep(3000);

        String getVersion = driver.findElement(By.id(varFile.env+"id/text_version")).getText();
        System.out.println("Current version: "+getVersion);

        System.out.println("Check FB link ...");
        driver.findElement(By.id(varFile.env+"id/button_facebook")).click();
        Thread.sleep(10000);
        driver.navigate().back();
        //***TAB only: open fb using chrome
        //driver.findElement(By.id("android:id/icon")).click();
        //Thread.sleep(9000);
        Thread.sleep(2000);
        System.out.println("Check Twitter link ...");
        driver.findElement(By.id(varFile.env+"id/button_twitter")).click();
        Thread.sleep(10000);
        driver.navigate().back();
        //***TAB only: open twitter using chrome
        //driver.findElement(By.id("android:id/icon")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(5000);
    }

    @Test (priority=8)
    private void logout() throws Exception {

        glob.logout(driver);
    }

}
