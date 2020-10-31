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
	
	@Test
	public void givenIplBowlingData_SortBowlingDataAccordingToEconomy_ReturnSameList() {
		List<IPLBallingData> listOfTopBowlersWithBestEconomy = iplAnalyser.getTopBowlerWithBestEconomy();
		Assert.assertEquals("Shivam Dube",listOfTopBowlersWithBestEconomy.get(0).player);
	}
	
	@Test
	public void givenIplBowlingData_SortBowlingDataAccordingToBestEconomyWithMax4wAnd5w_ReturnSameList() {
		List<IPLBallingData> listOfTopBowlersWithBestStrikeRateANdMax4w5w = iplAnalyser.getBowlersWithBestStrikeRateWithMax4wAnd5w();
		Assert.assertEquals("Kagiso Rabada",listOfTopBowlersWithBestStrikeRateANdMax4w5w.get(0).player);
	}
	
	@Test
	public void givenIplBowlingData_SortBowlingDataAccordingToBestStrikeRateAndAverage_ReturnSameList() {
		List<IPLBallingData> listOfTopBowlersWithBestStrikeRateAndAverage = iplAnalyser.getBowlersWithStrikeRateAndBestAverage();
		Assert.assertEquals("Anukul Roy",listOfTopBowlersWithBestStrikeRateAndAverage.get(0).player);
	}
	
	@Test
	public void givenIplBowlingData_SortWithMaxWicketsAndGreatAverage_ReturnSameList() {
		List<IPLBallingData> listOfBowlersWithMaximumWicketsAndGreatAverage=iplAnalyser.getBowlersWithMaxWicketsAndBestAverage();
		Assert.assertEquals("Imran Tahir",listOfBowlersWithMaximumWicketsAndGreatAverage.get(0).player);
	}
	
	@Test
	public void givenBattingAndBowlingData_whenSortedOnBestBattingAndBowlingAverage_ShouldReturnCorrectList() {
		List<String> playersWithBestBattingAndBowlingAverage=iplAnalyser.getBestBattingAndBowlingAverage();
		Assert.assertEquals("Andre Russell", playersWithBestBattingAndBowlingAverage.get(0));
		Assert.assertEquals("Marcus Stoinis", playersWithBestBattingAndBowlingAverage.get(1));
	}
	
	@Test
	public void givenBattingAndBowlingData_whenSortedOnMostRunsAndMostWicket_ShouldReturnCorrectList() {
		List<String> playerWithMostRunAndMostWicket=iplAnalyser.getPlayerWithMostRunAndMostWicket();
		Assert.assertEquals("Andre Russell", playerWithMostRunAndMostWicket.get(0));
		Assert.assertEquals("Hardik Pandya", playerWithMostRunAndMostWicket.get(1));
	}
	
	@Test
	public void givenBattingData_whenSortedWithWithMaxCenturiesAndBattingAverage_ShouldReturnCorrectList() {
		List<IPLBattingData> playerWithMaxCenturyAndBestBattingAverage=iplAnalyser.getPlayerWithMax100AndBestBattingAverage();
		Assert.assertEquals("David Warner",playerWithMaxCenturyAndBestBattingAverage.get(0).player);
	}
	
}
	

