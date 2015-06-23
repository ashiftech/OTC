package com.paxotech.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paxotech.framework.Scriptbase.OTCScript;

public class OTCFirstClass extends OTCScript {

	private WebElement titleOtc;

	public void highlightElement(WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: green; border: 5px solid blue;");
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");
		}
	}

	public void verifyHomePageDisplayed(String expectedResult) {
		String actualResult = driver.getTitle();
		Assert.assertEquals(actualResult, expectedResult);
	}

	public void verifyOTCLogoIsDisplayed() {
		WebElement logoFrame = driver.findElement(By.xpath(".//*[@id='logo']"));
		if (logoFrame != null && logoFrame.isDisplayed()) {
			boolean logo = logoFrame.isDisplayed();
			highlightElement(logoFrame);
			Assert.assertTrue(logo, "OTC Logo Does not display in the HomePage");

		}
	}

	public void verifyOTCTitleIsDisplayed(String expectedTitle) {
		if (titleOtc != null) {
			String actualTitle = titleOtc.getText();
			Assert.assertEquals(actualTitle, expectedTitle);
		} else {
			WebElement titleOtc = driver.findElement(By
					.xpath(".//*[@id='xcompanyInfo']/h3"));
			String actualTitle = titleOtc.getText();
			highlightElement(titleOtc);
			Assert.assertEquals(actualTitle, expectedTitle);
		}
	}

	public void verifyOTCPercentRateIsDisplayed(String expectedRate) {
		WebElement actualRate = driver.findElement(By
				.xpath(".//*[@class='price']"));
		if (actualRate != null) {
			String text = actualRate.getText();
			highlightElement(actualRate);
			Assert.assertEquals(text, expectedRate);
		}
	}

	public void verfyPrevious_CloseLinkIsDisplayed(String expectedText) {
		WebElement previous = driver.findElement(By
				.xpath(".//*[@glossaryid='previousclose']"));
		String pClose = previous.getText();
		highlightElement(previous);
		Assert.assertEquals(pClose, expectedText);
	}

	public void verifyPreviousCloseRatesAreDisplayed(String exptectedRate,
			String expectedOpenRate) {
		WebElement rate = driver.findElement(By
				.xpath(".//*[@val='previousClose']"));
		if (rate != null) {
			String text = rate.getText();
			highlightElement(rate);
			Assert.assertEquals(text, exptectedRate);
			WebElement openRate = driver.findElement(By
					.xpath(".//*[@val='openingPrice']"));
			if (openRate != null) {
				String text2 = openRate.getText();
				highlightElement(openRate);
				Assert.assertEquals(text2, expectedOpenRate);
			}
		}
	}

	public void verifyDailyRangeLink_And_RatesAreDisplayed(String expectedLink,
			String exptectedDailyRange, String expected52WKRange) {
		WebElement link = driver.findElement(By
				.xpath(".//*[@glossaryid='dailyhigh']"));
		if (link != null && link.isDisplayed()) {
			String actualLink = link.getText();
			highlightElement(link);
			Assert.assertEquals(actualLink, expectedLink);

			WebElement dRange = driver.findElement(By
					.xpath(".//*[@id='tradeSummary']/div[2]/span[1]"));
			if (dRange != null) {
				String text = dRange.getText();
				highlightElement(dRange);
				Assert.assertEquals(text, exptectedDailyRange);

				WebElement wkRange = driver.findElement(By
						.xpath(".//*[@id='tradeSummary']/div[2]/span[2]"));
				if (wkRange != null) {
					String text2 = wkRange.getText();
					highlightElement(wkRange);
					Assert.assertEquals(text2, expected52WKRange);
				}
			}
		}
	}

	public void verifyVolumeLink_And_RatesAreDisplayed(String expectedLink,
			String exptectedVolume, String expectedDivident) {
		WebElement link = driver.findElement(By
				.xpath(".//*[@glossaryid='volume']"));
		if (link != null && link.isDisplayed()) {
			String actualLink = link.getText();
			highlightElement(link);
			Assert.assertEquals(actualLink, expectedLink);

			WebElement actualVolume = driver.findElement(By
					.xpath(".//*[@val='volumeFormatted']"));
			if (actualVolume != null) {
				String text = actualVolume.getText();
				highlightElement(actualVolume);
				Assert.assertEquals(text, exptectedVolume);

				WebElement actualDivident = driver.findElement(By
						.xpath(".//*[@val='dividend']"));
				if (actualDivident != null) {
					String text2 = actualDivident.getText();
					highlightElement(actualDivident);
					Assert.assertEquals(text2, expectedDivident);
				}
			}
		}
	}

	public void verifyAverageLink_And_RatesAreDisplayed(String expectedLink,
			String exptectedAverageVolume, String expectedDividentYield) {
		WebElement link = driver.findElement(By
				.xpath(".//*[@id='tradeSummary']/div[4]/strong[1]"));
		if (link != null && link.isDisplayed()) {
			String actualLink = link.getText();
			highlightElement(link);
			Assert.assertEquals(actualLink, expectedLink);

			WebElement actualAverageVolume = driver.findElement(By
					.xpath(".//*[@val='thirtyDaysAvgVolFormatted']"));
			if (actualAverageVolume != null) {
				String text = actualAverageVolume.getText();
				highlightElement(actualAverageVolume);
				Assert.assertEquals(text, exptectedAverageVolume);

				WebElement actualDividentYield = driver.findElement(By
						.xpath(".//*[@val='yield']"));
				if (actualDividentYield != null) {
					String text2 = actualDividentYield.getText();
					highlightElement(actualDividentYield);
					Assert.assertEquals(text2, expectedDividentYield);
				}
			}
		}
	}
}
