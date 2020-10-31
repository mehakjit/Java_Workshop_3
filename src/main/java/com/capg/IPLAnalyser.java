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
	}

