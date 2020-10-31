package com.capg;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import com.capg.filereader.*;

public class IPLAnalyserTest {
	
	public IPLAnalyser iplAnalyser;
	
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
	
	@Test
	public void givenBattingData_ShouldReturn_CricketersWithMaximumRunAndBestAverages(){
		List<IPLBattingData> listOfMaxRunAndGreatestAverage = iplAnalyser.getMaximumRunWithGreatestAverage();
		Assert.assertEquals("David Warner ", listOfMaxRunAndGreatestAverage.get(0).getPlayer());
	}
	@Test
	public void givenIplBowlingData_SortBowlingDataAccordingToAverage_ReturnSameList() throws IPLException {
		List<IPLBallingData> listOfTopBowlingAverage = iplAnalyser. getTopBowlingAverages();
		Assert.assertEquals("Anukul Roy",listOfTopBowlingAverage.get(0).player);
		Assert.assertEquals("Jagadeesha Suchith",listOfTopBowlingAverage.get(1).player);
		Assert.assertEquals("Alzarri Joseph",listOfTopBowlingAverage.get(2).player);
	}
	
	@Test
	public void givenIplBowlingData_SortBowlingDataAccordingToStrikeRate_ReturnSameList() {
		List<IPLBallingData> listOfTopBowlingStrikeRate = iplAnalyser.getTopBowlingStrikeRates();
		Assert.assertEquals("Alzarri Joseph",listOfTopBowlingStrikeRate.get(0).player);
		Assert.assertEquals("Ish Sodhi",listOfTopBowlingStrikeRate.get(1).player);
		Assert.assertEquals("Khaleel Ahmed",listOfTopBowlingStrikeRate.get(2).player);
	}
	
	
}
	

