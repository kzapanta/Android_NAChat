import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by M.Manalo
 */

public class MessagesTab extends AppiumSetup {

    globfunc glob = new globfunc();

    @Test(priority=1)
    private void testNewMessage() throws Exception {

        glob.login(driver, varFile.validUsernameField, varFile.validPasswordField);
        glob.gotoMessages(driver);

        WebElement newMsgButton = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("fabMessage")));
        Thread.sleep(3000);
        newMsgButton.click();

        driver.findElement(By.id(varFile.env+"id/search")).sendKeys(varFile.friend);
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.ListView[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]")).click();

        WebElement messageField = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/send")));
        messageField.click();
        messageField.sendKeys(varFile.singleLineMsg);
        Thread.sleep(2000);

        driver.findElement(By.id(varFile.env+"id/sendButton")).click();
        Thread.sleep(10000);
    }

    @Test(priority=2)
    private void testSendMessage() throws Exception{

        glob.backbutton(driver);
        driver.findElement(By.name("Friends")).click();
        Thread.sleep(10000);

        glob.recipient(driver);

        WebElement messageField = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/send")));
        messageField.click();
        messageField.sendKeys(varFile.singleLineMsg);
        Thread.sleep(3000);

        WebElement sendButton = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/sendButton")));
        sendButton.click();
        Thread.sleep(3000);

        messageField.sendKeys(varFile.multLineMsg);
        Thread.sleep(3000);
        sendButton.click();
        Thread.sleep(3000);

        messageField.sendKeys(varFile.specChars);
        Thread.sleep(3000);
        sendButton.click();
        System.out.println("-- message with special characters");
        Thread.sleep(10000);

    }

    @Test(priority=3)
    private void deleteMessage() throws Exception{

        WebElement messageField = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/send")));
        messageField.click();
        messageField.sendKeys(varFile.delimiter);

        WebElement sendButton = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/sendButton")));
        sendButton.click();
        Thread.sleep(3000);

        messageField.sendKeys(varFile.deleteMsg);
        sendButton.click();
        Thread.sleep(3000);

        messageField.sendKeys(varFile.delimiter);
        sendButton.click();
        Thread.sleep(3000);

        WebElement del = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.name(varFile.deleteMsg)));

        TouchAction action = new TouchAction(driver);
        action.longPress(del).perform();
        Thread.sleep(3000);

        driver.findElement(By.id(varFile.env+"id/delete")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(10000);
    }

    @Test(priority=4)
    private void captureImgSend() throws Exception {

        driver.findElement(By.id(varFile.env+"id/captureButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/captureImage")).click();
        Thread.sleep(300);
        driver.findElement(By.id("com.android.gallery3d:id/shutter_button_photo")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.android.gallery3d:id/btn_done")).click();

        Thread.sleep(30000);
    }

    @Test(priority=5)
    private void captureVidLessSixtySeconds() throws Exception {

        driver.findElement(By.id(varFile.env+"id/captureButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/captureVideo")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.android.gallery3d:id/shutter_button_video")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("com.android.gallery3d:id/camera_shutter")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("com.android.gallery3d:id/btn_done")).click();
        Thread.sleep(80000);

    }

    @Test(priority=6)
    private void captureVidSixtySeconds() throws Exception {

        driver.findElement(By.id(varFile.env+"id/captureButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/captureVideo")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.android.gallery3d:id/shutter_button_video")).click();
        Thread.sleep(60000);
        driver.findElement(By.id("com.android.gallery3d:id/camera_shutter")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("com.android.gallery3d:id/btn_done")).click();
        Thread.sleep(150000);
    }

    @Test(priority=7)
    private void sendSingleImgfromGallery() throws Exception {

        driver.findElement(By.id(varFile.env+"id/galleryButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Select Image(s) from gallery")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Done")).click();
        Thread.sleep(70000);

    }

    @Test(priority=8)
    private void sendMultImgfromGallery() throws Exception {

        driver.findElement(By.id(varFile.env+"id/galleryButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Select Image(s) from gallery")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]")).click();
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[2]/android.widget.ImageView[1]")).click();
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[3]/android.widget.ImageView[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Done")).click();
        Thread.sleep(120000);
    }

    @Test(priority=9)
    private void sendAFile() throws Exception {

        // Select and send file
        driver.findElement(By.id(varFile.env+"id/attachButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Select File to upload")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id(varFile.env+"id/action_done")).click();
        Thread.sleep(60000);

    }

    @Test(priority=10)
    private void recAudio() throws Exception {

        // click audio button
        driver.findElement(By.id(varFile.env+"id/audioButton")).click();
        Thread.sleep(5000);

        // record audio
        WebElement audioRec = driver.findElement(By.id(varFile.env+"id/button_record"));
        Thread.sleep(5000);
        TouchAction action = new TouchAction(driver);
        //action.longPress(320,1100, 20).perform();
        //action.press(320, 1100).wait(2000);
        action.longPress(320, 1110, 15000).perform();
        Thread.sleep(5000);

        //press send
        driver.findElement(By.id(varFile.env+"id/sendButton")).click();
        Thread.sleep(30000);
    }

    @Test(priority=11)
    private void viewProfile() throws Exception {

        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/text_view_profile")).click();
        Thread.sleep(3000);

        String username = driver.findElement(By.id(varFile.env+"id/username")).getText();
        String name = driver.findElement(By.id(varFile.env+"id/name")).getText();
        String bio = driver.findElement(By.id(varFile.env+"id/bio")).getText();

        assertEquals(username,"@"+varFile.friend);
        assertNotNull(name);
        assertNotNull(bio);
        System.out.println ("Username:" + username);
        System.out.println ("Name:" + name);
        System.out.println ("Shoutout:" + bio);
        Thread.sleep(10000);

        glob.backbutton(driver);
        glob.backbutton(driver);
        glob.logout(driver);

    }



}
