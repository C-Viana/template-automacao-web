package reporter;

import java.io.File;
import java.io.FileOutputStream;
import java.time.Instant;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.Driver;
import io.cucumber.java.Status;


public class ReportManager {
    
    private static ExtentReports reporter;
    private static ExtentTest test;
    private static int iterator = 0;
    private static String ROOT_PATH = "C:/Test_Results/";
    private static String images_path = "";

    public static void setResultPath(String featureName, String scenarioName) {
        ROOT_PATH += getFeatureName(featureName) +"/"+ scenarioName.replaceAll("[\\/?\\*:<>]","");
    }

    public static void startReport( String featureName ) {
        if( reporter != null ) return;
        reporter = new ExtentReports( ROOT_PATH + "/results.html", true );
    }

    public static void startTest( String testName ) {
        test = reporter.startTest(testName);
        images_path = ROOT_PATH + "/screenshots";
        test.setStartedTime(Date.from(Instant.now()));
    }

    public static void endTest() {
        test.setEndedTime(Date.from(Instant.now()));
        reporter.endTest(test);
        test = null;
        iterator = 0;
        images_path = "";
    }

    public static void endReport() {
        reporter.flush();
        reporter.close();
    }

    public static void setTestStep( Status status, String stepLog ) {
        LogStatus stat = ( LogStatus.valueOf(status.name().replace("ED", "")) != null ) ? LogStatus.valueOf(status.name().replace("ED", "")) : LogStatus.valueOf("error");
        test.log( stat, stepLog, test.addScreenCapture(getShot()) );
    }

    private static String getShot() {
        byte[] image = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
        File file = new File( images_path + "/step_" + (++iterator) + ".png" );
        createFolders(images_path);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(image);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return file.getPath();
    }

    public static void createFolders(String path) {
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    public static String getFeatureName( String scenarioClass ) {
        return scenarioClass.split("features/")[1].split("[.]")[0];
    }

}
