package com.paxotech.frameword.test;

import org.testng.annotations.Test;

import com.paxotech.framework.OTCFirstClass;

public class FirstTest extends OTCFirstClass {

	@Test
	public void sampleTest(){
		verifyHomePageDisplayed("OTCM OTC Markets Group Inc.: Summary, Stock Quote & Trades for OTC Markets Group Inc. - OTCMarkets.com");
		verifyOTCLogoIsDisplayed();
		verifyOTCTitleIsDisplayed("OTC Markets Group Inc.");
		verifyOTCPercentRateIsDisplayed("16.00");
		verfyPrevious_CloseLinkIsDisplayed("Previous Close");
		verifyPreviousCloseRatesAreDisplayed("16.00", "N/A");
		verifyDailyRangeLink_And_RatesAreDisplayed("Daily Range", "N/A - N/A", "10.50 - 16.65");
		verifyVolumeLink_And_RatesAreDisplayed("Volume", "30", "0.40");
		verifyAverageLink_And_RatesAreDisplayed("Average Vol (30d)", "367", "2.5");
	}
}
