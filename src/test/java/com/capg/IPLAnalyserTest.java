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
	public void givenbattingData_ShouldReturn_BattingAvgList() throws IPLException{
		List<IPLBattingData> topBattingAverage = iplAnalyser.getTopBattingAverages();
		Assert.assertEquals(83.2, topBattingAverage .get(0).getAverage(), 0.0);
		Assert.assertEquals(69.2, topBattingAverage .get(1).getAverage(), 0.0);
	}
	
	@Test
	public void givenbattingData_ShouldReturn_StrikeRateList(){
		List<IPLBattingData> topStrikeRate = iplAnalyser.getTopStrikingRates();
		Assert.assertEquals(333.33, topStrikeRate.get(0).getStrikeRate(), 0.0);
		Assert.assertEquals(204.81, topStrikeRate.get(1).getStrikeRate(), 0.0);
	}
	
	@Test
	public void givenbattingData_ShouldReturn_CricketerListWithMax6s(){
		List<IPLBattingData> batmenWithMax6s = iplAnalyser.getTopBatmenWithMax6s();
		Assert.assertEquals("Andre Russell", batmenWithMax6s.get(0).getPlayer());
	}
	
	@Test
	public void givenbattingData_ShouldReturn_CricketerListWithMax4s(){
		List<IPLBattingData> batmenWithMax4s = iplAnalyser.getTopBatmenWithMax4s();
		Assert.assertEquals("Shikhar Dhawan", batmenWithMax4s.get(0).getPlayer());
	}
	
	@Test
	public void givenbattingData_ShouldReturn_BestStrikeRatesWith6sAnd4s(){
		List<IPLBattingData> listOfTopStrikeRate = iplAnalyser.getCricketerWithBestStrikingRateWith6sAnd4s();
		Assert.assertEquals("Andre Russell", listOfTopStrikeRate.get(0).getPlayer());
	}
	
	@Test
	public void givenbattingData_ShouldReturn_CricketersWithGreatAverageAndBestStrikeRates(){
		List<IPLBattingData> listOfTopAverageWithBestStrikERate = iplAnalyser.getGreatestAverageWithBestStrikingRate();
		Assert.assertEquals("MS Dhoni", listOfTopAverageWithBestStrikERate.get(0).getPlayer());
	}
}
	

