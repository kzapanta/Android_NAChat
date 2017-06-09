import org.openqa.selenium.By;

/**
 * Created by M.Manalo
 */

public class varFile extends AppiumSetup {

    // Environment variables
    public static final String env = "com.noteabout.app.chat.dev:";

    /* Messages Module - variables
    *
    * Pre-requisites
    * 1. validUsernameField and friend variables are friends
    *
    * */
    public static final String validUsernameField = "devmariane";
    public static final String validPasswordField = "initial01";
    public static final String friend = "kbanj0";

    // Type of messages
    public static String singleLineMsg = "This is a test";
    public static String multLineMsg = "Multiple Lines: Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";
    public static String specChars = "Special Characters: ~!@#$%^&*()_+ `= :';/? < > ,.";
    public static String delimiter = "---------------------";
    public static String deleteMsg = "This will be deleted";

    /*
    * Me Tab - variables
    * */
    public static String origName = "devmariane1";
    public static String editfullName = "Mariane_edit";
    public static String editUsername = "devmariane_edit";
    public static String editPassword = "123456";

    /* Settings Tab - variables
    *
    *  * Pre-requisites
    * 1. addUser - not friends with current user (validUsernameField)
    *
    * */
    public static String addUser = "devmariane5";
    public static String blockUser = "devmariane4";

    public static String termsTitle = "Terms of Service";
    public static String textsTerms = "Statement of Rights and Responsibilities";

    /* Friends Tab - variables
    *
    *  * Pre-requisites
    * 1. addNewUser - not friends with current user (validUsernameField)
    * 2. rejectUser - not friends with current user (validUsernameField)
    *
    * */
    public static String addNewUsername = "devmariane3";
    public static String addNewUser = "devmariane three";

    public static String approvedUsername = "dev001";
    public static String approvedUserfullN = "dev01";
    public static String rejectUser = "dev002";

    /* Groups Tab - variables
    *
    *  * Pre-requisite
    * 1. grpUser1, grpUser2 and addUser - are already friends with current user (validUsernameField)
    *
    * */

    public static String grpUser1 = "drexmod";
    public static String grpUser2 = "johann";
    public static String newGroupName = "test1234";
    public static String addUsertoGroup = "devmariane2";

    /*
    * Registration
    * */

    public static String mobileLoginText1 = "Enter your number with area code to \n" +
            " Sign in or Create a new account.";
    public static String mobileLoginText2 = "Verification code will be sent to you via SMS.";

    public static String validNumber = "639053961400";
    public static String invalidNumber = "09053961000";
    public static String mobileLoginText3 = "A verification \n" +
            " code has been sent to this number \n" +
            " "+validNumber;
    public static String invalidCodeError = "The code you entered is invalid.";
    public static String invalidMobileError = "Please enter a valid phone number.";


}
