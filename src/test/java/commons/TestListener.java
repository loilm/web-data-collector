package commons;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Log;
import utils.TestUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("| Start : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("| " + result.getName() + ": PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("| " + result.getName() + ": FAIL");
        TestUtils.screenCapture(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("| " + result.getName() + ": SKIP");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Log.error("| " + result.getName() + ": TestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        Log.error("| " + result.getName() + ": TestFailedWithTimeout");
    }

    @Override
    public void onStart(ITestContext context) {
        Log.info("|      START");
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("|      FINISH");
        Log.info("|---------------------------------------");
    }
}
