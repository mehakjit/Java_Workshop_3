package com.capg;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.capg.filereader.CsvFileLoader;
import com.capg.filereader.IPLBattingData;
import com.capg.filereader.IPLException;

public class IPLAnalyser {
	
	public static List<IPLBattingData> IplBattingList;

	public static void loadData(String csvFilePath,Class csvClass) throws IPLException {
		CsvFileLoader csvFileLoader = null;
		IplBattingList = CsvFileLoader.loadCsvFile(csvFilePath, csvClass);
	}

	public List<IPLBattingData> getTopBattingAverages() throws IPLException {
		loadData("BattingData.csv", IPLBattingData.class);
		List<IPLBattingData> sortedAvgList = IplBattingList.stream()
				.sorted((player1, player2) -> Double.compare(player1.getAverage(), player2.getAverage()))
				.collect(Collectors.toList());
		Collections.reverse(sortedAvgList);
		return sortedAvgList;
	}

	public List<IPLBattingData> getTopStrikingRates() {
		List<IPLBattingData> sortedStrikingRateList = IplBattingList.stream()
				.sorted((player1, player2) -> Double.compare(player1.getStrikeRate(), player2.getStrikeRate()))
				.collect(Collectors.toList());
		Collections.reverse(sortedStrikingRateList);
		return sortedStrikingRateList;
	}
	
	public List<IPLBattingData> getTopBatmenWithMax6s() {
		List<IPLBattingData> batmenWithMax6s = IplBattingList.stream()
				.sorted((player1, player2) -> Double.compare(player1.getNoOfSixes(), player2.getNoOfSixes()))
				.collect(Collectors.toList());
		Collections.reverse(batmenWithMax6s);
		return batmenWithMax6s;
	}

	public List<IPLBattingData> getTopBatmenWithMax4s() {
		List<IPLBattingData> batmenWithMax4s = IplBattingList.stream()
				.sorted((player1, player2) -> Double.compare(player1.getNoOfFours(), player2.getNoOfFours()))
				.collect(Collectors.toList());
		Collections.reverse(batmenWithMax4s);
		return batmenWithMax4s;
	}

	public List<IPLBattingData> getCricketerWithBestStrikingRateWith6sAnd4s() {
			int max4sAnd6s = IplBattingList.stream().map(player -> (player.getNoOfFours() + player.getNoOfSixes())).max(Integer::compare)
					.get();
			List<IPLBattingData> batmenWithMax4sAnd6s = IplBattingList.stream()
					.filter((player -> (player.getNoOfSixes() + player.getNoOfFours()) == max4sAnd6s)).collect(Collectors.toList());

			double bestStrikingRate = batmenWithMax4sAnd6s.stream().map(player -> player.getStrikeRate()).max(Double::compare)
					.get();

			List<IPLBattingData> batmenBestStrikingRateWithMax4sAnd6s = batmenWithMax4sAnd6s.stream()
					.filter(player -> player.getStrikeRate() == bestStrikingRate).collect(Collectors.toList());

			return batmenBestStrikingRateWithMax4sAnd6s;
		}
	}

