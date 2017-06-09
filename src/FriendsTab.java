import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by M.Manalo
 */

public class FriendsTab extends AppiumSetup {

    globfunc glob = new globfunc();

    @Test (priority=1)
    private void searchAddNoter() throws  Exception {

        glob.login(driver, varFile.validUsernameField, varFile.validPasswordField);
        glob.gotoFriends(driver);

        driver.findElement(By.id(varFile.env+"id/search_user")).click();
        Thread.sleep(5000);

        WebElement searchNoter = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/search")));

        searchNoter.sendKeys(varFile.addNewUsername); Thread.sleep(5000);
        driver.findElement(By.id(varFile.env+"id/searchButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(varFile.env+"id/contentContainer")).click();

        // Add Friend
        WebElement addFriend = (new WebDriverWait(driver, 120))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/addButton")));
        addFriend.click();
        Thread.sleep(3000);
        glob.backbutton(driver);
        driver.navigate().back();
        Thread.sleep(5000);

    }

    @Test (priority=2)
    private void acceptFriendRequest() throws Exception {

        glob.gotoSettings(driver);
        driver.findElement(By.name("Friend Request Notifications")).click();

        System.out.println("Assumption: "+varFile.validUsernameField + " is NOT YET friends with " + varFile.approvedUsername);
        System.out.println("-----------------");
        System.out.println("Waiting for friend request from " + varFile.approvedUsername + "... -- (20 seconds)"); Thread.sleep(20000);
        glob.backbutton(driver);
        driver.findElement(By.name("Friend Request Notifications")).click();
        Thread.sleep(3000);

        driver.findElement(By.id(varFile.env+"id/moreButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.id(varFile.env+"id/acceptButton")).click();
        Thread.sleep(8000);
        glob.backbutton(driver);
        Thread.sleep(3000);
    }

    @Test (priority=3)
    private void rejectFriendRequest() throws Exception {

        glob.gotoSettings(driver);
        driver.findElement(By.name("Friend Request Notifications")).click();

        System.out.println("Assumption: "+varFile.validUsernameField + " is NOT YET friends with " + varFile.rejectUser);
        System.out.println("-----------------");
        System.out.println("Waiting for friend request from " + varFile.rejectUser + "... -- (20 seconds)"); Thread.sleep(20000);
        glob.backbutton(driver);
        driver.findElement(By.name("Friend Request Notifications")).click();
        Thread.sleep(3000);

        driver.findElement(By.id(varFile.env+"id/moreButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.id(varFile.env+"id/layout_reject")).click();
        Thread.sleep(8000);
        glob.backbutton(driver);
        Thread.sleep(3000);
    }

    @Test (priority=4)
    private void searchFriends() throws Exception {

        glob.searchFriends(driver, varFile.approvedUsername);
        Thread.sleep(3000);

        /*
        boolean ret = glob.friendExist(driver);
        System.out.println("Return -- "+ret);

        // Check if "id/contentContainer" is present, if YES = user is on the list, NO = doesn't exist on the list
        if( ret == true) {

            System.out.println(varFile.approvedUsername+ " -- is on the list");
        } else {
            System.out.println(varFile.env+ " -- NOT on the list");
        }
        */

        Thread.sleep(5000);

    }

    @Test (priority=5)
    private void voiceCall () throws Exception {

        glob.searchFriends(driver, varFile.approvedUsername);
        Thread.sleep(5000);

        WebElement voiceCallButton = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/callButton")));
        voiceCallButton.click();
        System.out.println("--- answer the call ");
        Thread.sleep(30000);
        driver.findElement(By.id(varFile.env+"id/layoutProfile")).click();
        driver.findElement(By.id(varFile.env+"id/callDecline")).click();
        Thread.sleep(5000);

    }

    @Test (priority=6)
    private void videoCall () throws Exception {

        glob.gotoMessages(driver);
        glob.searchFriends(driver, varFile.approvedUsername);
        Thread.sleep(5000);

        WebElement voiceCallButton = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/videoButton")));
        voiceCallButton.click();
        System.out.println("--- answer the video call ");
        Thread.sleep(30000);
        driver.findElement(By.id(varFile.env+"id/participantTrigger")).click();
        driver.findElement(By.id(varFile.env+"id/callDecline")).click();
        Thread.sleep(5000);

    }

    @Test (priority=7)
    private void unfriendUser () throws Exception {

        glob.searchFriends(driver, varFile.approvedUsername);
        Thread.sleep(5000);
        driver.findElement(By.name(varFile.approvedUserfullN)).click();
        Thread.sleep(5000);
        glob.moreButton(driver);
        driver.findElement(By.id(varFile.env+"id/text_view_profile")).click();
        Thread.sleep(3000);
        glob.moreButton(driver);
        driver.findElement(By.id(varFile.env+"id/popup_unfried")).click();

        Thread.sleep(5000);

    }

}
