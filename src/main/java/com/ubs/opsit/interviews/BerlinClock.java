package com.ubs.opsit.interviews;

public class BerlinClock implements TimeConverter {

	public String convertTime(String aTime) {

		String[][] timeDisplay = null;
		String[] tokens = aTime.split(":");

		if (tokens.length == 3) {
			timeDisplay = new String[5][];
			int hrs = Integer.parseInt(tokens[0]);
			int minutes = Integer.parseInt(tokens[1]);
			int seconds = Integer.parseInt(tokens[2]);

			String[] second = new String[1];
			String[] firstRowHours = new String[4];
			String[] secondRowHours = new String[4];
			String[] firstRowMinutes = new String[11];
			String[] secondRowMinutes = new String[4];

			generateSecondsPattern(seconds, second);
			generateHoursPattern(hrs, firstRowHours, secondRowHours);
			generateMinutesPattern(minutes, firstRowMinutes, secondRowMinutes);

			timeDisplay[0] = second;
			timeDisplay[1] = firstRowHours;
			timeDisplay[2] = secondRowHours;
			timeDisplay[3] = firstRowMinutes;
			timeDisplay[4] = secondRowMinutes;
		}

		StringBuilder finalDisplay = new StringBuilder();
		generateFinalResult(finalDisplay, timeDisplay);
		return finalDisplay.substring(0, finalDisplay.length() - 2);
	}

	void generateFinalResult(StringBuilder finalDisplay,
			String[][] timeDisplay) {

		for (String[] displayArray : timeDisplay) {
			for (String display : displayArray) {
				finalDisplay.append(display);
			}
			finalDisplay.append("\r\n");
		}
	}

	void generateMinutesPattern(int minutes, String[] firstRowMinutes,
			String[] secondRowMinutes) {

		if (minutes % 5 == 0) {
			int firstRowPosition = 0;
			
			firstRowPosition = generateCorrectMinutesPattern(minutes,
					firstRowMinutes, firstRowPosition);
			
			generateHoursPatternForEmptyPosition(firstRowMinutes,
					firstRowPosition);
			generateEmptyRows(secondRowMinutes);
			
		} else {
			int firstRowPosition = 0;
			
			firstRowPosition = generateCorrectMinutesPattern(minutes,
					firstRowMinutes, firstRowPosition);
			generateHoursPatternForEmptyPosition(firstRowMinutes,
					firstRowPosition);

			int reminder = minutes % 5;
			int secondRowPosition = 0;
			for (; secondRowPosition < reminder; secondRowPosition++) {
				secondRowMinutes[secondRowPosition] = "Y";
			}
			generateHoursPatternForEmptyPosition(secondRowMinutes,
					secondRowPosition);
		}
	}

	int generateCorrectMinutesPattern(int minutes,
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

	void generateHoursPattern(int hrs, String[] firstRowHours,
			String[] secondRowHours) {
		
		int quotient = hrs / 5;
		
		if (hrs % 5 == 0) {
			int firstRowPosition = 0;
			
			firstRowPosition = generateCorrectHoursPosition(quotient, firstRowHours,
					firstRowPosition);
			
			generateHoursPatternForEmptyPosition(firstRowHours,
					firstRowPosition);
			generateEmptyRows(secondRowHours);
			
		} else {
			
			int reminder = hrs % 5;
			
			int firstRowPosition = 0;
			int secondRowPosition = 0;
			
			firstRowPosition = generateCorrectHoursPosition(quotient, firstRowHours,
					firstRowPosition);
			secondRowPosition = generateCorrectHoursPosition(reminder,
					secondRowHours, secondRowPosition);
					
			generateHoursPatternForEmptyPosition(firstRowHours,
					firstRowPosition);
			generateHoursPatternForEmptyPosition(secondRowHours,
					secondRowPosition);
		}
	}



	int generateCorrectHoursPosition(int value,  String[] rowHours,
			int rowPosition) {

		for (; rowPosition < value; rowPosition++) {
			rowHours[rowPosition] = "R";
		}
		return rowPosition;
	}

	void generateEmptyRows(String[] rowArray) {
		for (int rowPosition = 0; rowPosition < rowArray.length; rowPosition++) {
			rowArray[rowPosition] = "O";
		}
	}

	void generateHoursPatternForEmptyPosition(String[] rows,
			int rowPosition) {
		if (rowPosition < rows.length) {
			for (; rowPosition < rows.length; rowPosition++) {
				rows[rowPosition] = "O";
			}
		}
	}

	void generateSecondsPattern(int seconds, String[] second) {
		if (seconds % 2 == 0) {
			second[0] = "Y";
		} else {
			second[0] = "O";
		}
	}

}
