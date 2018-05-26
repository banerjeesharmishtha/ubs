package com.ubs.opsit.interviews;

public class BerlinClockUtil {


	static int generateCorrectMinutesPattern(int minutes,
			String[] minuteRow, int rowPosition) {
		
		int quotient = minutes / 5;
		for (; rowPosition < quotient; rowPosition++) {
			
			if (rowPosition > 0 && (rowPosition + 1) % 3 == 0) {
				minuteRow[rowPosition] = "R";
			} else {
				minuteRow[rowPosition] = "Y";
			}
			
		}
		return rowPosition;
	}

	static int generateCorrectHoursPosition(int value,  String[] rowHours,
			int rowPosition) {

		for (; rowPosition < value; rowPosition++) {
			rowHours[rowPosition] = "R";
		}
		return rowPosition;
	}

	static void generateEmptyRows(String[] rowArray) {
		for (int rowPosition = 0; rowPosition < rowArray.length; rowPosition++) {
			rowArray[rowPosition] = "O";
		}
	}

	static void generateHoursPatternForEmptyPosition(String[] rows,
			int rowPosition) {
		if (rowPosition < rows.length) {
			for (; rowPosition < rows.length; rowPosition++) {
				rows[rowPosition] = "O";
			}
		}
	}
}
