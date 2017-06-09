import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by M.Manalo
 */

public class SignWithMobileNo extends AppiumSetup {

    globfunc glob = new globfunc();
/*
    @Test(priority=1)
    private void validNumber() throws Exception {

        glob.mobileLogin(driver);

        String verificationText1 = driver.findElement(By.id(varFile.env+"id/verificationTexts")).getText();
        String verificationText2 = driver.findElement(By.id(varFile.env+"id/verificationText")).getText();

        System.out.println("---- Assert verification Text1: " +verificationText1); Thread.sleep(5000);
        Assert.assertEquals(varFile.mobileLoginText1, verificationText1); Thread.sleep(5000);
        System.out.println("---- Assert verification Text2: " +verificationText2); Thread.sleep(5000);
        Assert.assertEquals(varFile.mobileLoginText2, verificationText2); Thread.sleep(5000);

        driver.findElement(By.id(varFile.env+"id/mobile")).sendKeys(varFile.validNumber); Thread.sleep(2000);
        driver.findElement(By.id(varFile.env+"id/login")).click(); Thread.sleep(15000);

        String verificationText3 = driver.findElement(By.id(varFile.env+"id/verificationTexts")).getText();
        System.out.println("---- Assert verification Text3: " +verificationText3); Thread.sleep(5000);
        Assert.assertEquals(varFile.mobileLoginText3, verificationText3); Thread.sleep(5000);

        System.out.println("\n Enter verification code ... (within 30 seconds)"); Thread.sleep(30000);
        driver.findElement(By.id(varFile.env+"id/login")).click(); Thread.sleep(15000);

    }

    @Test(priority=2)
    private void logout() throws Exception {

       glob.gotoSettings(driver);
       glob.logout(driver);

    }

    @Test(priority=3)
    private void invalidNumber() throws Exception {

        glob.mobileLogin(driver);

        driver.findElement(By.id(varFile.env+"id/mobile")).sendKeys(varFile.invalidNumber); Thread.sleep(2000);
        driver.findElement(By.id(varFile.env+"id/login")).click(); Thread.sleep(15000);

        String invalidNumberErrorMsg = driver.findElement(By.id(varFile.env+"id/mobile_invalid")).getText(); Thread.sleep(3000);
        System.out.println("Assert if there's error message ---- ");
        Assert.assertEquals(invalidNumberErrorMsg, varFile.invalidMobileError);
        System.out.println(invalidNumberErrorMsg);
        Thread.sleep(20000);

        Thread.sleep(10000);

    }

    @Test(priority=4)
    private void resendVerCode() throws Exception {

        glob.mobileLogin(driver);

        driver.findElement(By.id(varFile.env+"id/mobile")).sendKeys(varFile.validNumber); Thread.sleep(2000);
        driver.findElement(By.id(varFile.env+"id/login")).click(); Thread.sleep(30000);

        System.out.println("Resend verification code ... (30 seconds)"); Thread.sleep(40000);
        driver.findElement(By.id(varFile.env+"id/resendButton")).click();
        System.out.println("\n Enter verification code ... (within 30 seconds)"); Thread.sleep(30000);
        driver.findElement(By.id(varFile.env+"id/login")).click(); Thread.sleep(15000);

    }
**/
    @Test(priority=5)
    private void invalidCode() throws Exception {

        glob.mobileLogin(driver);

        driver.findElement(By.id(varFile.env+"id/mobile")).sendKeys(varFile.validNumber); Thread.sleep(5000);
        driver.findElement(By.id(varFile.env+"id/login")).click(); Thread.sleep(15000);

        WebElement code = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(varFile.env+"id/verification_c")));

        code.click(); code.sendKeys("1234");Thread.sleep(3000);
        driver.hideKeyboard(); Thread.sleep(2000);
        driver.findElement(By.id(varFile.env+"id/login")).click(); Thread.sleep(5000);

        String invalidCodeErrorMsg = driver.findElement(By.id(varFile.env+"id/verification_invalid")).getText(); Thread.sleep(3000);
        System.out.println("Assert if there's error message ---- ");
        Assert.assertEquals(invalidCodeErrorMsg, varFile.invalidCodeError);
        System.out.println(invalidCodeErrorMsg);
        Thread.sleep(20000);

    }


}
