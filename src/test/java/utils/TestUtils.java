package utils;

import atu.testrecorder.ATUTestRecorder;
import commons.Browser;
import commons.CommonPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {
    private ATUTestRecorder recorder;
    private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
    private static String imagePath = "output/images/";
    private static String videoPath = "output/videos/";

    public static void screenCapture(String screenName) {
        Log.info("| Wait for page loaded BEFORE screen capture");
        CommonPage.waitForPageLoaded();
        TakesScreenshot takesScreenshot = (TakesScreenshot) Browser.getDriver();
        File filePath = new File(imagePath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(imagePath + screenName + "_" + dateFormat.format(new Date()) + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
            Log.info("| " + screenName + ": Capture success");
        } catch (IOException e) {
            Log.error("| " + screenName + ": Capture FAIL - " + e.getMessage());
        }
    }

    /*record video*/
    public void startRecord(String videoName) {
        try {
            File filePath = new File(videoPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            recorder = new ATUTestRecorder(videoPath, videoName + "_" + dateFormat.format(new Date()), false);
            Log.info("| Start record video...");
            recorder.start();
        } catch (Exception e) {
            Log.error("| Start record video FAIL: " + e.getMessage());
        }
    }

    public void stopRecord() {
        try {
            recorder.stop();
            Log.info("| Stop record video");
        } catch (Exception e) {
            Log.error("| Stop record video FAIL: " + e.getMessage());
        }
    }

    /*code screenCapture for AfterMethod*/
//    public void screenCapture(ITestResult testResult) {
//        try {
//            if (!testResult.isSuccess()) {
//                TakesScreenshot takesScreenshot = (TakesScreenshot) Browser.getDriver();
//                File filePath = new File(imagePath);
//                if (!filePath.exists()) {
//                    filePath.mkdirs();
//                }
//                File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//                File destFile = new File(imagePath + testResult.getName() + "_" + dateFormat.format(date) + ".png");
//                FileUtils.copyFile(srcFile, destFile);
//                Log.info("| " + testResult.getName() + ": Capture success");
//            }
//        } catch (Exception e) {
//            Log.error("| " + testResult.getName() + ": " + e.getMessage());
//        }
//    }
}
