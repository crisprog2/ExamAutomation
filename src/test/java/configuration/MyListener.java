package configuration;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("El test pasó");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("El test falló");
    }
}
