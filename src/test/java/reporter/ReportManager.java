package reporter;

import java.awt.image.BufferedImage;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import common.General;
import common.StaticResources;
import driver.Driver;
import io.cucumber.java.Status;


public class ReportManager {
    
    private static ExtentReports reporter;
    private static ExtentTest test;
    private static int iterator = 0;
    private static String ROOT_PATH = "";
    private static String images_path = "";

    public static void setResultPath(String featureName, String scenarioName) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Date.from(Instant.now()));
        if(!StaticResources.suite_test) {
            ROOT_PATH = "C:/Test_Results/" + date + "/" + getFeatureName(featureName) + "/" + scenarioName.replaceAll("[\\/?\\*:<>]", "");
        }
        else
            if(reporter == null)
                ROOT_PATH = "C:/Test_Results/" + date + "/" + "Suite_Run_" + new SimpleDateFormat("HH-mm").format(Calendar.getInstance().getTime());
    }

    public static void startReport() {
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
        if (!StaticResources.suite_test)
            iterator = 0;
    }

    public static void endReport() {
        reporter.flush();
        reporter.close();
        reporter = null;
    }

    public static void setTestStep( Status status, String stepLog ) {
        LogStatus stat = ( LogStatus.valueOf(status.name().replace("ED", "")) != null ) ? LogStatus.valueOf(status.name().replace("ED", "")) : LogStatus.valueOf("error");
        test.log( stat, stepLog, test.addScreenCapture(getShot()) );
    }

    public static void setTestLog(String stepLog) {
        test.log(LogStatus.INFO, stepLog);
    }

    private static String getShot() {
        byte[] image = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
        File file = new File( images_path + "/step_" + (++iterator) + ".png" );
        General.createFolders(images_path);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(image);
        }
        catch(Exception e) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.WARNING, "Erro ao realizar captura de tela na geração de evidência de teste", e);
        }
        return file.getPath();
    }

    public static String getFeatureName( String scenarioClass ) {
        return scenarioClass.split("features/")[1].split("[.]")[0];
    }

    private static String getShotJava() {
        File file = new File(images_path + "/step_" + (++iterator) + ".png");
        try {
            Point pos = General.getChromePosition();
            Dimension size = General.getChromeDimensions();
            BufferedImage bi = new Robot().createScreenCapture( new Rectangle(pos.x, pos.y, size.width, size.height) );
            ImageIO.write(bi, "png", file);
        } catch (AWTException | IOException e) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.WARNING, "Erro ao realizar captura de tela na geração de evidência de teste", e);
        }
        return file.getPath();
    }

    public static void setTestStepOutContext(Status status, String stepLog) {
        LogStatus stat = (LogStatus.valueOf(status.name().replace("ED", "")) != null)
                ? LogStatus.valueOf(status.name().replace("ED", ""))
                : LogStatus.valueOf("error");
        test.log(stat, stepLog, test.addScreenCapture(getShotJava()));
    }

}
