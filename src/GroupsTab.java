import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by K.Zapanta
 * Updated by M.Manalo
 */

public class GroupsTab extends AppiumSetup {

    globfunc glob = new globfunc();
    String intGroupName = "";

    @Test (priority=1)
    private void createNewGroup() throws Exception {

        glob.login(driver, varFile.validUsernameField, varFile.validPasswordField);
        glob.gotoGroups(driver);

        Thread.sleep(5000);
        driver.findElement(By.id(varFile.env + "id/add_group_button")).click();
        Thread.sleep(5000);

        // search and add specific users
        WebElement searchBox = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/search")));
        searchBox.sendKeys(varFile.grpUser1); Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/addButton")).click(); Thread.sleep(3000);
        searchBox.clear();
        searchBox.sendKeys(varFile.grpUser2); Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/addButton")).click(); Thread.sleep(3000);

        driver.findElement(By.id(varFile.env + "id/save")).click();
        Thread.sleep(3000);

        // Send initial message to see the settings
        WebElement textBox = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/send")));
        textBox.click();
        textBox.sendKeys(varFile.singleLineMsg);
        driver.findElement(By.id(varFile.env+"id/sendButton")).click();
        Thread.sleep(10000);

        // to determine the initial group name
        glob.moreButton(driver); Thread.sleep(3000);
        intGroupName = driver.findElement(By.id(varFile.env+"id/conversation_name")).getText();
        driver.findElement(By.id(varFile.env+"id/save")).click();
        glob.backbutton(driver);
        Thread.sleep(10000);

    }

    @Test (priority=2)
    private void updateGroupName() throws Exception {

        glob.gotoGroups(driver);
        driver.findElement(By.name(intGroupName)).click(); Thread.sleep(3000);

        glob.moreButton(driver); Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/nameButton")).click(); Thread.sleep(3000);
        WebElement conv_name = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/conversation_name")));
        conv_name.clear();
        conv_name.sendKeys(varFile.newGroupName); Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/saveButton")).click(); Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/save")).click(); Thread.sleep(3000);
        glob.backbutton(driver);
        Thread.sleep(10000);
    }

    @Test (priority=3)
    private void sendMsgtoGroup() throws Exception {

        glob.gotoGroups(driver);
        driver.findElement(By.name(varFile.newGroupName)).click(); Thread.sleep(3000);

        WebElement messageField = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/send")));

        WebElement sendButton = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/sendButton")));
        sendButton.click();
        Thread.sleep(3000);

        messageField.click();
        messageField.sendKeys(varFile.singleLineMsg); sendButton.click(); Thread.sleep(3000);
        messageField.sendKeys(varFile.multLineMsg); sendButton.click(); Thread.sleep(3000);
        messageField.sendKeys(varFile.specChars); sendButton.click(); Thread.sleep(10000);
        glob.backbutton(driver);

    }

    @Test (priority=4)
    private void deleteGrpMessage() throws Exception {

        glob.gotoGroups(driver);
        driver.findElement(By.name(varFile.newGroupName)).click(); Thread.sleep(3000);

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

        //glob.backbutton(driver);

    }

    @Test(priority=5)
    private void captureImgSendtoGroup() throws Exception {

        driver.findElement(By.id(varFile.env+"id/captureButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/captureImage")).click();
        Thread.sleep(300);
        driver.findElement(By.id("com.android.gallery3d:id/shutter_button_photo")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.android.gallery3d:id/btn_done")).click();

        Thread.sleep(30000);
    }

    @Test(priority=6)
    private void captureVidLessSixtySecondstoGroup() throws Exception {

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

    @Test(priority=7)
    private void captureVidSixtySecondstoGroup() throws Exception {

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

    @Test(priority=8)
    private void sendSingleImgfromGallerytoGroup() throws Exception {

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


    @Test(priority=9)
    private void sendMultImgfromGallerytoGroup() throws Exception {

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

    @Test(priority=10)
    private void sendAFiletoGroup() throws Exception {

        // Select and send file
        driver.findElement(By.id(varFile.env+"id/attachButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("Select File to upload")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id(varFile.env+"id/action_done")).click();
        Thread.sleep(60000);
        glob.backbutton(driver);

    }

    @Test(priority=11)
    private void recAudiotoGroup() throws Exception {

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
        glob.backbutton(driver);
    }

    @Test(priority=12)
    private void addMemberstoGroup() throws Exception {

        glob.gotoGroups(driver);
        driver.findElement(By.name(intGroupName)).click(); Thread.sleep(3000);

        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/addButton")).click();
        Thread.sleep(5000);

        // search and add specific users
        WebElement searchBox = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/search")));
        searchBox.sendKeys(varFile.addUsertoGroup); Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/addButton")).click(); Thread.sleep(3000);

        driver.findElement(By.id(varFile.env+"id/save")).click(); Thread.sleep(2000);
        glob.backbutton(driver);
        Thread.sleep(10000);

    }


    @Test(priority=13)
    private void changeGroupImagefromGallery() throws Exception {

        glob.gotoGroups(driver);
        driver.findElement(By.name(intGroupName)).click(); Thread.sleep(3000);

        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/coverButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.id(varFile.env+"id/camera")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("android:id/text1")).click();
        Thread.sleep(3000);
        TouchAction tapPhoto = new TouchAction(driver);
        tapPhoto.tap(500,500).perform();
        Thread.sleep(5000);
        tapPhoto.tap(150,500).perform();
        Thread.sleep(5000);
        driver.findElement(By.id(varFile.env+"id/crop")).click();
        Thread.sleep(10000);
        driver.findElement(By.id(varFile.env+"id/save")).click();
        Thread.sleep(5000);
        driver.findElement(By.id(varFile.env+"id/save")).click();
        Thread.sleep(10000);

        glob.backbutton(driver);
        Thread.sleep(5000);

    }

    @Test(priority=14)
    private void changeGroupImagefromCamera() throws Exception {

        glob.gotoGroups(driver);
        driver.findElement(By.name(intGroupName)).click(); Thread.sleep(3000);

        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/coverButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.id(varFile.env+"id/camera")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Camera']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.android.gallery3d:id/shutter_button_photo")).click();
        Thread.sleep(7000);
        driver.findElement(By.id("com.android.gallery3d:id/btn_done")).click();
        Thread.sleep(5000);
        driver.findElement(By.id(varFile.env+"id/crop")).click();
        Thread.sleep(15000);
        driver.findElement(By.id(varFile.env+"id/save")).click();
        Thread.sleep(10000);
        driver.findElement(By.id(varFile.env+"id/save")).click();
        Thread.sleep(5000);

        glob.backbutton(driver);

    }

    @Test(priority=15)
    private void leaveGroup() throws Exception {

        glob.gotoGroups(driver);
        driver.findElement(By.name(intGroupName)).click(); Thread.sleep(3000);

        driver.findElement(By.id(varFile.env+"id/more")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Leave this group']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(10000);
    }

}
