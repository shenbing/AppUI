package com.appium.keyword.ios;

import com.appium.keyword.Engine_Excel;
import com.appium.locator.AppLocator;
import com.appium.locator.GetLocator;
import com.framework.utils.ConfigManager;
import com.framework.utils.ExcelUtils;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class IOSKeyWordTest {
	
	protected static AppLocator<MobileElement> locator;
	protected static Engine_Excel keywordTest;
	protected ExcelUtils excelUtils;

	@BeforeSuite
	public void beforeSuite() throws IOException, InterruptedException {
		String iOSExcelTestPath = ConfigManager.getIOSExcelName();
		excelUtils = new ExcelUtils(iOSExcelTestPath);
		locator = new GetLocator().getIOSLocator(excelUtils.getIOSDeviceTestConfig(1));
		keywordTest = new Engine_Excel(iOSExcelTestPath);
	}

	@Test
	public void test() {
		keywordTest.runTest(new MainKeyWord(locator));
	}

	@AfterSuite
	public void afterSuite() {
		locator.quit();
	}

}
