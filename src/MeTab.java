import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * Created by K.Zapanta
 * Updated by M.Manalo
 */

public class MeTab extends AppiumSetup{

    globfunc glob = new globfunc();

    @Test(priority=1)
    private void testViewProfile() throws Exception{

        glob.login(driver, varFile.validUsernameField, varFile.validPasswordField);
        glob.gotoMe(driver);

    }

    @Test(priority=2)
    private void testEditProfile() throws Exception{

        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/profileContainer")).click();
        Thread.sleep(3000);

        // Get Full Name text
        WebElement fullNameField = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/fullname")));
        String origfullName = fullNameField.getText();

        // Get Username
        WebElement userNameField = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/username")));
        String origUsername = userNameField.getText();

        // Print old field values
        System.out.println("Old Full Name: "+origfullName);
        System.out.println("Old Username: "+origUsername);
        System.out.println("Old Password: "+varFile.validPasswordField);
        Thread.sleep(3000);

        // Update fields
        fullNameField.clear();
        fullNameField.sendKeys(varFile.editfullName);
        userNameField.clear();
        userNameField.sendKeys(varFile.editUsername);
        driver.findElement(By.id(varFile.env+"id/password")).sendKeys(varFile.editPassword);
        driver.findElement(By.id(varFile.env+"id/confirm_password")).sendKeys(varFile.editPassword);
        Thread.sleep(3000);

        // Print edited fields
        System.out.println("------------------");
        System.out.println("New Full Name: "+varFile.editfullName);
        System.out.println("New Username: "+varFile.editUsername);
        System.out.println("New Password: "+varFile.editPassword);
        Thread.sleep(3000);

        WebElement updateButton = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/update")));
        updateButton.click(); Thread.sleep(3000);
        driver.findElement(By.id("android:id/button1")).click(); Thread.sleep(10000);

        glob.logout(driver);

        // login using updated username and password
        System.out.println("------------------");
        System.out.println("Test new username and password to see if working ...");
        glob.login(driver, varFile.editUsername, varFile.editPassword);
        glob.gotoMe(driver);

        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/profileContainer")).click();
        Thread.sleep(3000);

        // Update fields to original
        System.out.println("------------------");
        System.out.println("Update the fields to original values ...");
        fullNameField.clear();
        fullNameField.sendKeys(varFile.origName);
        userNameField.clear();
        userNameField.sendKeys(varFile.validUsernameField);
        driver.findElement(By.id(varFile.env+"id/password")).sendKeys(varFile.validPasswordField);
        driver.findElement(By.id(varFile.env+"id/confirm_password")).sendKeys(varFile.validPasswordField);

        updateButton.click(); Thread.sleep(3000);
        driver.findElement(By.id("android:id/button1")).click(); Thread.sleep(10000);

        glob.logout(driver);
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    private void uploadProfilePictureGallery() throws Exception {

        glob.login(driver, varFile.validUsernameField, varFile.validPasswordField);
        glob.gotoMe(driver);

        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/avatarContainer")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/camera")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("android:id/text1")).click();
        Thread.sleep(3000);
        TouchAction tapPhoto = new TouchAction(driver);
        //Lenovo
        tapPhoto.tap(500,500).perform();
        //tapPhoto.tap(1500,500).perform();
        Thread.sleep(3000);
        //Lenovo
        tapPhoto.tap(150,500).perform(); Thread.sleep(3000);
        TouchAction tapPhoto1 = new TouchAction(driver);
        //tapPhoto1.tap(1700,400).perform();
        Thread.sleep(5000);
        driver.findElement(By.name("Crop")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("Done")).click();
        Thread.sleep(10000);

    }

    @Test (priority = 4)
    private void uploadProfilePictureCamera() throws Exception{

        //driver.findElement(By.xpath("//android.widget.TextView[@text='Me']")).click();
        //Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/avatarContainer")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/camera")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Camera")).click();
        Thread.sleep(3000);
        //((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
        driver.findElement(By.id("com.android.gallery3d:id/shutter_button_photo")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.android.gallery3d:id/btn_done")).click();
        Thread.sleep(6000);
        driver.findElement(By.id(varFile.env+"id/crop")).click();
        Thread.sleep(18000);
        driver.findElement(By.name("Done")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 5)
    private void uploadCoverPhotoGallery() throws Exception{

        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/coverContainer")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/camera")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("android:id/text1")).click();
        Thread.sleep(3000);

        TouchAction tapPhoto = new TouchAction(driver);
        //Lenovo
        tapPhoto.tap(500,500).perform();
        //tapPhoto.tap(1500,500).perform();
        Thread.sleep(3000);
        //Lenovo
        tapPhoto.tap(150,500).perform(); Thread.sleep(3000);
        TouchAction tapPhoto1 = new TouchAction(driver);
        //tapPhoto1.tap(1700,400).perform();
        driver.findElement(By.name("Done")).click();
        Thread.sleep(15000);
    }

    @Test (priority = 6)
    private void uploadCoverPhotoCamera() throws Exception{

        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/coverContainer")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/camera")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Camera")).click();
        Thread.sleep(3000);
        //((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
        driver.findElement(By.id("com.android.gallery3d:id/shutter_button_photo")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.android.gallery3d:id/btn_done")).click();
        Thread.sleep(6000);
        driver.findElement(By.name("Done")).click();
        Thread.sleep(10000);

        glob.gotoSettings(driver);
        glob.logout(driver);
    }


}