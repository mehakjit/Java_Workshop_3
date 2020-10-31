package com.capg.filereader;

@SuppressWarnings("serial")
public class IPLException extends Exception {
	enum ExceptionType {
	       WRONG_CSV, WRONG_TYPE, INTERNAL_ISSUE, UNABLE_TO_PARSE, NO_DATA
	    }
		
		ExceptionType type;
	
		public IPLException(String message, ExceptionType type) {
			super(message);
			this.type = type;
		}
}
