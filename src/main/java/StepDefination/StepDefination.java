package StepDefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class StepDefination {

    @Given("You are on the login screen")
    public void you_are_on_the_login_screen() {

    }

    @Then("Enter username as {string}")
    public void enter_username_as(String string) {
        DriverAction.typeText(By.xpath("//input[@placeholder='Username']"), "raghavsuneja123");

    }

    @Then("Enter Password")
    public void enter_password() {
        DriverAction.typeText(By.xpath("//input[@placeholder='Password']"), "Abc123@@");

        try {
            DriverAction.click(By.xpath("//button[text()='Login']"), "Login Button", "Clicked Successfully on the Login Button");
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("Verify Logout button is visible or not")
    public void verify_logout_button_is_visible_or_not() {
        try {

            DriverAction.waitSec(2);
            DriverAction.click(By.xpath("//div[text()='Home']"), "Click on Home Button", " Clicked successfully on the Home Button");
            DriverAction.waitSec(2);
            DriverAction.click(By.xpath(" //div[@class='d-flex']"), "Click on Profile button", "Clicked on the Profile Button");

            GemTestReporter.addTestStep("Status of logout button", "Logout button is  visible", STATUS.PASS, DriverAction.takeSnapShot());
            Boolean b = DriverAction.getElement(By.xpath("//span[text()='Logout']")).isDisplayed();
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Status of logout button", "Logout button is not visible", STATUS.FAIL);

        }


    }


    @Then("Verify the text of the Home screen")
    public void verify_the_text_of_the_home_screen() {
        try {

            DriverAction.waitSec(2);
            DriverAction.click(By.xpath(" //div[text()='Home']"), "Home Button", "Clicked Successfully on the Home Button");
            String s = DriverAction.getElement(By.xpath("//div[text()='Jewel Applications']")).getText();
            GemTestReporter.addTestStep("Text of Home Screen", s, STATUS.INFO);

            System.out.println(s);
            if (s.equals("Jewel Applications")) {
                GemTestReporter.addTestStep("Text of Home screen", "Expected :Jewel Applications", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Text of Home screen", "Expected :Jewel Applications", STATUS.FAIL, DriverAction.takeSnapShot());
            }


        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("ERROR!", "Something wrong Happened", STATUS.FAIL);
        }
    }

    @Then("Click on the Autolytics screen")
    public void click_on_the_autolytics_screen() {
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home button", "Successfully clicked on the Home button");


        boolean present;
        try {
            DriverManager.getWebDriver().findElement(By.xpath("(//div[text()='Autolytics'])[2]"));
            present = true;
        } catch (Exception e) {
            present = false;
        }


        if (present == true) {
            try {
                DriverAction.click(By.xpath("(//div[text()='Autolytics'])[2]"), "Autolytics Button", "Successfully clicked on the Autolytics Button");
            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Autolytics Button Status", "Not clicked", STATUS.FAIL);
            }

        } else {
            GemTestReporter.addTestStep("Autolytics Button Status", "Not Found", STATUS.FAIL);

        }
    }


    @Then("Verify the Autolytics Screen")
    public void verify_the_autolytics_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home Button", "Click was successful");
        try {


            DriverAction.click(By.xpath("(//div[text()='Autolytics'])[2]"), "Autolytics Button", "Click was Successful");
            String s = DriverAction.getCurrentURL();

            if (s.contains("autolytics")) {
                GemTestReporter.addTestStep("AUtolytics window", "Window is opened successfully", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("AUtolytics window", "Window is not opened successfully", STATUS.FAIL);

            }

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Status of Autolytics button", "Clicked Fsiled", STATUS.FAIL);
        }
    }


    @Then("Verify the Bridge Token Button is clickable or not")
    public void verify_the_bridge_token_button_is_clickable_or_not() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home Button", "Click was successful");


        boolean present;
        try {
            DriverManager.getWebDriver().findElement(By.xpath("(//div[text()='Bridge Token'])[2]"));
            present = true;
        } catch (Exception e) {
            present = false;
        }


        if (present == true) {

            try {
                DriverAction.click(By.xpath("(//div[text()='Bridge Token'])[2]"), "Bridge token Button", "Click was successful");
                String s = DriverAction.getCurrentURL();

                if (s.contains("bridge-token")) {
                    GemTestReporter.addTestStep("Bridge Token window", "Window was opened successfully", STATUS.PASS);
                } else {
                    GemTestReporter.addTestStep("Bridge Token window", "Window was not opened successfully", STATUS.FAIL);

                }

            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Bridge Token window", "Button NOt Present", STATUS.FAIL);

        }
    }

    @Then("Click on Copy Bridge Token")
    public void click_on_copy_bridge_token() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"));
        try {
            DriverAction.click(By.xpath("(//div[text()='Bridge Token'])[2]"), "Bridge token Button", "Click was successful");
            String s = DriverAction.getCurrentURL();
            if (s.contains("bridge-token")) {
                GemTestReporter.addTestStep("Bridge Token window", "Window is opened successfully", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("AUtolytics window", "Window is not opened successfully", STATUS.FAIL);
            }
            boolean present;
            try {
                DriverManager.getWebDriver().findElement(By.xpath("//div[@class='copyIcon col-2 d-flex justify-content-center align-items-center']"));
                present = true;
            } catch (Exception e) {
                present = false;
            }
            if (present == true) {
                try {
                    DriverAction.click(By.xpath("//div[@class='copyIcon col-2 d-flex justify-content-center align-items-center']"), "copy button", "Click was successful");
                    DriverAction.waitSec(2);
                    GemTestReporter.addTestStep("Status of Copy button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());

                } catch (Exception e) {
                    e.printStackTrace();
                    GemTestReporter.addTestStep("Status of Copy button", "Not clicked", STATUS.FAIL);
                }
            } else {
                GemTestReporter.addTestStep("Status of Copy button", "Not Found", STATUS.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
        }
    }

    @Then("Verify the Alert when copy button is clicked")
    public void verify_the_alert_when_copy_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home button", "Home button was clicked");
        boolean present;
        try {
            DriverManager.getWebDriver().findElement(By.xpath("(//div[text()='Bridge Token'])[2]"));
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present == true) {
            try {
                DriverAction.click(By.xpath("(//div[text()='Bridge Token'])[2]"), "Bridge token Button", "Bridge token was clicked");
                String s = DriverAction.getCurrentURL();

                if (s.contains("bridge-token")) {
                    GemTestReporter.addTestStep("Bridge Token window", "Window is opened successfully", STATUS.PASS);
                } else {
                    GemTestReporter.addTestStep("AUtolytics window", "Window is not opened successfully", STATUS.FAIL);
                }
                try {
                    DriverAction.click(By.xpath("//div[@class='copyIcon col-2 d-flex justify-content-center align-items-center']"), "copy button", "Copy button was clicked");
                    DriverAction.waitSec(1);
                    GemTestReporter.addTestStep("Status of Copy button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());

                } catch (Exception e) {
                    e.printStackTrace();
                    GemTestReporter.addTestStep("Status of Copy button", "Not clicked", STATUS.FAIL);
                }
                String se = DriverAction.getElement(By.xpath("//div[text()='Copied !']")).getText();
                if (se.equals("Copied !")) {
                    GemTestReporter.addTestStep("Alert status", "Expected alert:Copied ", STATUS.PASS);
                } else {
                    GemTestReporter.addTestStep("Alert status", "Expected alert:Copied ", STATUS.FAIL);
                }
            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Status of Bridge Token button", "Not Found", STATUS.FAIL);

        }
    }

    @Then("Verify the date and time when Change Token button is clicked")
    public void verify_the_date_and_time_when_change_token_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home button", "Home button was clicked");
        try {
            DriverAction.click(By.xpath("(//div[text()='Bridge Token'])[2]"));
            try {
                DriverAction.click(By.xpath("//div[text()='Change Token']"), "Change token button", "Change Token button was clicked");
                DriverAction.waitSec(1);
                GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());

            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Status of Change Token button", "Not clicked", STATUS.FAIL);
            }

            DriverAction.waitSec(2);
            String time = DriverAction.getElement(By.xpath("//div[@class='createdOn mt-3']")).getText();
            System.out.println(time);
            String timep = time.substring(11, 29);
            String date = timep;
//            String r = String.valueOf(date.charAt(0));
//            if (r.equals(" ")) {
//                date = "0" + date.substring(1);
//            }

            SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd,yyyy", Locale.ENGLISH);

            String dateInString = date;
            Date dateupdate = formatter.parse(dateInString);

            System.out.println(dateupdate);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            LocalDateTime now = LocalDateTime.now();
            String loc = dtf.format(now);
            if (StringUtils.contains(loc, date)) {
                GemTestReporter.addTestStep("Checking date", "Dates are matching", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Checking date", "Dates are not matching", STATUS.FAIL);
            }
            String times = time.substring(30, 36);
            System.out.println(times);
            String[] hel = times.split(":", 3);
            System.out.println(hel[0]);
            String jo = hel[0];
            String koko = String.valueOf(jo.charAt(0));
            if (koko.equals(" ")) {
                jo = "0" + jo.substring(1);
                hel[0] = jo;
            }
            System.out.println(hel[0]);
            System.out.println(hel[1]);
            DateTimeFormatter Time = DateTimeFormatter.ofPattern("hh/mm/ss");
            LocalDateTime ti = LocalDateTime.now();
            String timess = Time.format(ti);
            System.out.println(timess);
            String[] locat = timess.split("/", 3);
            int flag = 0;
            for (int o = 0; o < locat.length - 1; o++) {
                int numberlocal = Integer.parseInt(locat[o]);
                int get = Integer.parseInt(hel[o]);
                if (numberlocal - get < 5) {
                    flag = 0;
                } else {
                    flag = 1;
                }
            }
            if (flag == 0) {
                GemTestReporter.addTestStep("Comparing time", "Time is matching", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Comparing time", "Time is not matching", STATUS.FAIL);

            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }


    @Then("Verify the Alert when Change Token button is clicked")
    public void verify_the_alert_when_change_token_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home button", "Home button was clicked");
        try {
            DriverAction.click(By.xpath("(//div[text()='Bridge Token'])[2]"));
            try {
                DriverAction.click(By.xpath("//div[text()='Change Token']"), "Change token button", "Change Token button was clicked");
                DriverAction.waitSec(1);
                GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());

            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Status of Change Token button", "Not clicked", STATUS.FAIL);
            }
            String fi = DriverAction.getElement(By.xpath("//div[text()='Bridge Token Changed Successfully.']")).getText();
            if (fi.contains("Bridge Token Changed Successfully.")) {
                GemTestReporter.addTestStep("Alert status", "Expected alert:Changed successfully", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Alert status", "Expected alert:Changed successfully", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Click and verify the Logout button")
    public void click_and_verify_the_logout_button() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home button", "Home Button was clicked");
        try {
            DriverAction.waitSec(3);
            DriverAction.click(By.xpath("//div[@class='d-flex']"), "Profile Element", "Successfully clicked on the Profile");
            DriverAction.waitSec(3);
            DriverAction.click(By.xpath("//div[@class='dropdown-item mx-auto text-center']"), "Logout button", "Successfully clicked on the logout button");
            DriverAction.waitSec(2);

            String titlee = DriverAction.getCurrentURL();
            System.out.println(titlee);
            if (titlee.equals("https://jewel.gemecosystem.com/#/login")) {
                GemTestReporter.addTestStep("Verifying the URL", "Expected :https://jewel.gemecosystem.com/#/login", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Verifying the URL", "Expected :https://jewel.gemecosystem.com/#/login", STATUS.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the content of the Home screen")
    public void verify_the_content_of_the_home_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home Button", "Successfully clicked on the Home button");
        GemTestReporter.addTestStep("Successfully clicked", "Jewel Window", STATUS.INFO, DriverAction.takeSnapShot());
        try {
            String text = DriverAction.getElement(By.xpath("//div[@class='ms-5 headerHome']")).getText();
            System.out.println(text);
            if (text.equals("Jewel Applications")) {
                GemTestReporter.addTestStep("Title validation", "Expected Title:Jewel Applications", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Title validation", "Expected Title:Jewel Applications", STATUS.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the Cards present on the home screen")
    public void verify_the_cards_present_on_the_home_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home Button", "Successfully clicked on the Home button");

        try {
            List num = DriverAction.getElements(By.xpath("//div[@class='card-body ms-2']"));
            if (num.size() == 2) {
                GemTestReporter.addTestStep("Number of Cards Present ", "Expcted :2", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Number of Cards Present ", "Expcted :2", STATUS.FAIL);
            }
            System.out.println(num.size());

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the Autolytics Cards present on the home screen")
    public void verify_the_autolytics_cards_present_on_the_home_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home Button", "Successfully clicked on the Home button");
        try {

            String nuam = DriverAction.getElement(By.xpath("(//div[@class='mt-3 cardName'])[1]")).getText();

            if (nuam.equals("Autolytics")) {
                GemTestReporter.addTestStep("Validating the Autolytics card", "Expcted :Autolytics", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Validating the Autolytics card", "Expcted :Autolytics", STATUS.FAIL);

            }

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the Autolytics Card Content")
    public void verify_the_autolytics_card_content() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home button", "Home button was clicked successfully");

        try {

            String nuam = DriverAction.getElement(By.xpath("(//div[@class='mt-1 appCardContent'])[1]")).getText();
            System.out.println(nuam);
            if (nuam.equals("Autolytics provides the feature for generating descriptive reports to analyze the Testcases/Suite details and also enables users to share them effortlessly.")) {
                GemTestReporter.addTestStep("Validating the Autolytics card Content", "Expcted :Autolytics provides the feature for generating descriptive reports to analyze the Testcases/Suite details and also enables users to share them effortlessly.", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Validating the Autolytics card", "Expcted :Autolytics provides the feature for generating descriptive reports to analyze the Testcases/Suite details and also enables users to share them effortlessly.", STATUS.FAIL);

            }

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify if the Bridge token card is visible")
    public void verify_if_the_bridge_token_card_is_visible() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home Button", "Home button was clicked successfully");

        try {

            String nuam = DriverAction.getElement(By.xpath("(//div[@class='mt-3 cardName'])[2]")).getText();

            if (nuam.equals("Bridge Token")) {
                GemTestReporter.addTestStep("Validating the Bridge Token card", "Expcted :Bridge Token", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Validating the Bridge Token card", "Expcted :Bridge Token", STATUS.FAIL);
            }

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Validate the content of the Bridge Token card")
    public void validate_the_content_of_the_bridge_token_card() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home Button", "Home button was clicked successfully");

        try {

            String nuam = DriverAction.getElement(By.xpath("(//div[@class='mt-1 appCardContent'])[2]")).getText();
            System.out.println(nuam);
            if (nuam.equals("Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.")) {
                GemTestReporter.addTestStep("Validating the Bridge Token card Content", "Expcted :Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Validating the Autolytics card", "Expcted :Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.", STATUS.FAIL);

            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Validate alert ,username and status of the window button")
    public void validate_alert_username_and_status_of_the_window_button() {
        try {
            DriverAction.click(By.xpath(" //div[text()='Home']"), "Home Button", "Home button was clicked successfully");

            DriverAction.waitSec(2);
//            GemTestReporter.addTestStep("Login Success", "Successfully Logged in!!", STATUS.PASS);
            String s = DriverAction.getElementText(By.xpath("//div[@role='alert']"));
            System.out.println(s);
            GemTestReporter.addTestStep("Alert Text", s, STATUS.INFO);
            DriverAction.waitSec(5);
            DriverAction.waitSec(5);
            try {
                DriverAction.click(By.xpath("//img[@class='collapseBtn ms-3 mt-3 mb-2']"), "Three Lines button", "Successfully clicked on the three lines ");
                GemTestReporter.addTestStep("Button Status", "Clicked on the button", STATUS.PASS);

            } catch (Exception e) {
                GemTestReporter.addTestStep("Button Status", "Button Not clicked", STATUS.FAIL);

            }
            DriverAction.waitSec(2);
            String y = DriverAction.getElementText(By.xpath("//div[text()='Home']"));
            if (y == "Home") {
                GemTestReporter.addTestStep("Status of the side window", "Whole text is appearing", STATUS.INFO);
            } else {
                GemTestReporter.addTestStep("Status of the side window", "Only icons are appearing", STATUS.INFO);
            }
            try {
                DriverAction.click(By.xpath(" //div[@class='d-flex']"), "Usernane button", "Successfully clicked on the Username button");
                DriverAction.waitSec(2);
            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("CLick on the username", "FAiled!!", STATUS.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Something wrong Happened", "Error!!", STATUS.FAIL);
        }
    }

    @Then("Validate if there is change token button available ,if so click it")
    public void validate_if_there_is_change_token_button_available_if_so_click_it() {
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath(" //div[text()='Home']"), "Home Button", "Home button was clicked successfully");

        boolean present;
        try {
            DriverManager.getWebDriver().findElement(By.xpath("(//div[text()='Bridge Token'])[2]"));
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present == true) {
            try {


                DriverAction.click(By.xpath("(//div[text()='Bridge Token'])[2]"), "Bridge Token button", "Button was clicked successfully");

                try {


                    DriverAction.click(By.xpath("//div[text()='Change Token']"), "Change token button", "Button was clicked Successfully");
                    DriverAction.waitSec(1);
                    GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());


                } catch (Exception e) {
                    e.printStackTrace();
                    GemTestReporter.addTestStep("Status of Change Token button", "Not clicked", STATUS.FAIL);
                }

            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Error", "No such element", STATUS.FAIL);
        }

    }

    @Given("You are on the Sign up screen")
    public void you_are_on_the_sign_up_screen() {


        DriverAction.navigateToUrl("https://jewel-beta.gemecosystem.com/#/", true);


    }

    @Then("Click on the Sign up Button")
    public void click_on_the_sign_up_button() {
        DriverAction.waitSec(3);
        DriverAction.click(By.xpath("//span[text()='Sign up']"),"Sign up button","Successfully clicked");
        DriverAction.waitSec(3);
        GemTestReporter.addTestStep("Sign up screen", "Loaded", STATUS.INFO, DriverAction.takeSnapShot());
    }

    @Then("Enter random username")
    public void enter_random_username() {
        DriverAction.waitSec(2);
        DriverAction.typeText(By.xpath("//input[@placeholder='Firstname']"), "Hello");
        DriverAction.waitSec(3);
    }

    @Then("Enter all the fields and Validate the status")
    public void enter_all_the_fields_and_validate_the_status() {
        DriverAction.waitSec(2);
        DriverAction.typeText(By.xpath("//input[@placeholder='Lastname']"), "Jewel", "Last Name");
        DriverAction.waitSec(2);
        DriverAction.typeText(By.xpath("//input[@placeholder='Username']"), "test1" + System.currentTimeMillis(), "Username");
        DriverAction.waitSec(2);

        DriverAction.typeText(By.xpath("//input[@placeholder='Email']"), "test.jew@geminisolutions.com", "Test.jewel@geminisolutions.com");

        GemTestReporter.addTestStep("Status of username", "Clicked successfully", STATUS.INFO, DriverAction.takeSnapShot());
        DriverAction.typeText(By.xpath("//input[@placeholder='Password']"), "Hellothere", "Password");
        DriverAction.waitSec(2);
        DriverAction.typeText(By.xpath("//input[@placeholder='Confirm Password']"), "Hellothere", "Confirm Password");
        DriverAction.waitSec(2);
        DriverAction.typeText(By.xpath("//input[@placeholder='Company Name']"), "Gemini solutions", "Company Name");
        DriverAction.click(By.xpath("//button[text()='Register']"), "Register button", "Successfully clicked on the Register Button");
        DriverAction.waitSec(1);
//button[text()='Register']

        String text = DriverAction.getElement(By.xpath("//div[text()='User Registered.']")).getText();
        System.out.println(text);
        if (text.equals("User Registered.")) {
            GemTestReporter.addTestStep("User Registered Status", "User Registered Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("User Registered Status", "User is not Registered successfully", STATUS.FAIL, DriverAction.takeSnapShot());
        }


        try {
            String tt = DriverManager.getWebDriver().getCurrentUrl();
            if (tt.contains("login")) {
                GemTestReporter.addTestStep("Login screen status", "Opened Successfully", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Login Screen Status", "Errror Occurred", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }
//    @Then("Enter all the fields")
//    public void enter_all_the_fields() {
//        DriverAction.waitSec(2);
//        DriverAction.typeText(By.xpath("//input[@placeholder='Lastname']"), "Jewel", "Last Name");
//        DriverAction.waitSec(2);
//        DriverAction.typeText(By.xpath("//input[@placeholder='Username']"), "test1" + System.currentTimeMillis(), "Username");
//        DriverAction.waitSec(2);
//
//        DriverAction.typeText(By.xpath("//input[@placeholder='Email']"), "test.jew@geminisolutions.com", "Test.jewel@geminisolutions.com");
//
//        GemTestReporter.addTestStep("Status of username", "Clicked successfully", STATUS.INFO, DriverAction.takeSnapShot());
//        DriverAction.typeText(By.xpath("//input[@placeholder='Password']"), "Hellothere", "Password");
//        DriverAction.waitSec(2);
//        DriverAction.typeText(By.xpath("//input[@placeholder='Confirm Password']"), "Hellothere", "Confirm Password");
//        DriverAction.waitSec(2);
//        DriverAction.typeText(By.xpath("//input[@placeholder='Company Name']"), "Gemini solutions", "Company Name");
//        DriverAction.click(By.xpath("//button[text()='Register']"), "Register button");
//        DriverAction.waitSec(1);
////button[text()='Register']
//
//        String text = DriverAction.getElement(By.xpath("//div[text()='User Registered.']")).getText();
//        System.out.println(text);
//        if (text.equals("User Registered.")) {
//            GemTestReporter.addTestStep("User Registered Status", "User Registered Successfully", STATUS.PASS, DriverAction.takeSnapShot());
//        } else {
//            GemTestReporter.addTestStep("User Registered Status", "User is not Registered successfully", STATUS.FAIL, DriverAction.takeSnapShot());
//        }
//
//
//        try {
//            String tt = DriverManager.getWebDriver().getCurrentUrl();
//            if (tt.contains("login")) {
//                GemTestReporter.addTestStep("Login screen status", "Opened Successfully", STATUS.PASS, DriverAction.takeSnapShot());
//            }
//        } catch (Exception e) {
//            GemTestReporter.addTestStep("Login Screen Status", "Errror Occurred", STATUS.FAIL, DriverAction.takeSnapShot());
//        }
//
//
//        LocalTime time = LocalTime.now();
//        System.out.println("Current time: " + time);
//    }

    @Then("Click on Create Report Tab")
    public void click_on_create_report_tab() {
        addnewtabs();

    }

    public void addnewtabs() {
        DriverAction.click(By.xpath("//span[text()='Create Report']"), "Create Report","Clicked Successful");
        DriverAction.waitSec(4);
        DriverAction.click(By.xpath("//span[text()='Select Report Name']"),"Clicked on Report name was successful");
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath("//li[text()='Suite Run Report']"), "Suite run Report","Successfully clicked on Suite Run  report");
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath("//div[text()='Select Project Name(s)']"),"Project name","Clicked on the Project name");
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath("//span[text()='JEWEL-UI-JV']"),"Select from the dropdown","Successfully clicked on JEWEL_UI_JV");
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath("//button[@class='p-multiselect-close p-link']"),"Cross button","successfully clicked");
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath("//div[text()='Select Environment(s)']"),"Environment selection","Successfully clicked on the Environment button");
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath("//span[text()='Dev']"),"Select the Environment","Successfully selected the environment");
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath("//span[@class='p-multiselect-close-icon pi pi-times']"),"Cross button", "Successfully clicked on the cross button");
        DriverAction.waitSec(2);

        DriverAction.click(By.xpath("//span[text()='Select Date Range']"),"Select Date Range","Successfully clicked on the date range tab");
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath("//li[text()='Last 24 hours']"),"Select value","Successfully selected the value");
        DriverAction.waitSec(2);
        DriverAction.click(By.xpath("//button[text()='GENERATE']"),"Generate button","Click was successful");
        DriverAction.waitSec(3);

    }

    List<WebElement> hi = DriverAction.getElements(By.xpath("//div[@class='tabPane  align-items-center nav nav-pills']/div[starts-with(@id,'left-tabs')]"));

    @Then("Open few tabs")
    public void open_few_tabs() {

        for (int i = 0; i < 3; i++) {
            DriverAction.click(By.xpath("//i[@class='pi pi-plus-circle']"),"New Tab Button","Clicked Successful");
            addnewtabs();
        }
        List<WebElement> hi = DriverAction.getElements(By.xpath("//div[@class='tabPane  align-items-center nav nav-pills']/div[starts-with(@id,'left-tabs')]"));
        if (hi.size() == 4) {
            GemTestReporter.addTestStep("Number of Tabs", "Expected :4", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Number of Steps", "Expected :4", STATUS.FAIL);
        }
    }

    @Then("Click on SLide left button")
    public void Click_on_SLide_left_button() {
        DriverAction.click(By.xpath("//button[@id='slideLeftLeft']"),"Left Most Tab","Clicked Successful");
        DriverAction.waitSec(2);
        DriverAction.switchToActiveElement();

        WebElement l = DriverAction.getElement(By.xpath("(//div[starts-with(@id,'left-tabs-example-tabParent')])[1]/a"));

//activeElement() to verify element focused
        String element = l.getAttribute("aria-selected");
        if (element.equals("true")) {
            GemTestReporter.addTestStep("Left Most clicked Status", "Successfully clicked", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("Left Most clicked Status", "Clicked Failure", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }


    @Then("Click on the SLide most Right button")
    public void click_on_the_s_lide_most_right_button() {
        DriverAction.click(By.xpath("//button[@id='slideRightRight']"),"Right Most Tab","Clicked Successful");
        DriverAction.waitSec(1);
        WebElement l = DriverAction.getElement(By.xpath("(//div[starts-with(@id,'left-tabs-example-tabParent')])[4]/a"));

//activeElement() to verify element focused
        String element = l.getAttribute("aria-selected");
        if (element.equals("true")) {
            GemTestReporter.addTestStep("Right most Clicked Status", "Successfully clicked", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("Right most Clicked Status", "Clicked Failure", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Then("Click on the slide to next left button")
    public void click_on_the_slide_to_next_left_button() {
        try {


            DriverAction.click(By.xpath("//button[@id='slideLeft']"), "Slide Left Tab button", "Successfully clickeb");


            DriverAction.waitSec(1);
            WebElement l = DriverAction.getElement(By.xpath("(//div[starts-with(@id,'left-tabs-example-tabParent')])[3]/a"));


            String element = l.getAttribute("aria-selected");
            if (element.equals("true")) {
                GemTestReporter.addTestStep("Left Tab Clicked Status", "Successfully clicked", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Left tab Clicked Status", "Clicked Failure", STATUS.FAIL, DriverAction.takeSnapShot());
            }


        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR!", "Something wrong Happened", STATUS.FAIL);
        }
    }

    @Then("Click on the Slide to next right button")
    public void click_on_the_slide_to_next_right_button() {
        try {
        DriverAction.click(By.xpath("//button[@id='slideRight']"), "Slide Right Tab button", "Successfully clicked");


        DriverAction.waitSec(1);
        WebElement l = DriverAction.getElement(By.xpath("(//div[starts-with(@id,'left-tabs-example-tabParent')])[4]/a"));


        String element = l.getAttribute("aria-selected");
        if (element.equals("true")) {
            GemTestReporter.addTestStep("Left Tab Clicked Status", "Successfully clicked", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("Left tab Clicked Status", "Clicked Failure", STATUS.FAIL, DriverAction.takeSnapShot());
        }


    } catch (Exception e) {
        GemTestReporter.addTestStep("ERROR!", "Something wrong Happened", STATUS.FAIL);
    }
    }

    @Then("Validate the active tabs")
    public void validate_the_active_tabs() {

    }
/////////////////////////////////////////////
}

