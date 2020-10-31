package com.capg.filereader;

import java.util.Comparator;

public class DataSorter {
	public static Comparator<IPLBattingData> TOP_BATTING_AVG = Comparator.comparing(IPLBattingData::getAverage);
}
