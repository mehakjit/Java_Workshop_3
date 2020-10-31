package com.capg.filereader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

import com.capg.*;

public class CsvFileLoader {
	
		public static <E> List<E> loadCsvFile(String csvFilePath, Class csvClass) throws IPLException {
		if (!csvFilePath.contains(".csv"))
			throw new IPLException("Not .csv file", IPLException.ExceptionType.WRONG_TYPE);
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			return  csvBuilder.getCSVFileList(reader, csvClass);
		} catch (IOException e) {
			throw new IPLException("File not found", IPLException.ExceptionType.WRONG_TYPE);
		} catch (NullPointerException e) {
			throw new IPLException("File is empty", IPLException.ExceptionType.NO_DATA);
		} catch (RuntimeException e) {
			throw new IPLException("File internal data not proper", IPLException.ExceptionType.INTERNAL_ISSUE);
		} catch (CSVException e) {
			throw new IPLException(e.getMessage(), IPLException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
}
