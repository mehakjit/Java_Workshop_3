package com.capg;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import com.capg.filereader.*;

public class IPLAnalyserTest {
	
	public static final String BATTING_DATA_FILE_PATH = "BattingData.csv";
	public static final String BALLING_DATA_FILE_PATH = "BallingData.csv";
	public IPLAnalyser iplAnalyser;
	
	public List<IPLBattingData> batsmenList = null;
	public CsvFileLoader csvFileLoader = new CsvFileLoader();
	
	@Before
	public void setUp() throws IPLException {
		iplAnalyser=new IPLAnalyser();
	}
	
	@Test
	public void givenIplDataCSVFileReturnsTop3BattingAvg() throws IPLException{
		List<IPLBattingData> topBattingAverage = iplAnalyser.getTopBattingAverages();
		Assert.assertEquals(83.2, topBattingAverage .get(0).getAverage(), 0.0);
		Assert.assertEquals(69.2, topBattingAverage .get(1).getAverage(), 0.0);
		Assert.assertEquals(56.66, topBattingAverage .get(2).getAverage(), 0.0);
	}
}
	

