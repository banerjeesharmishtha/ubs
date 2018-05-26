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
			
			firstRowPosition = BerlinClockUtil.generateCorrectMinutesPattern(minutes,
					firstRowMinutes, firstRowPosition);
			
			BerlinClockUtil.generateHoursPatternForEmptyPosition(firstRowMinutes,
					firstRowPosition);
			BerlinClockUtil.generateEmptyRows(secondRowMinutes);
			
		} else {
			int firstRowPosition = 0;
			
			firstRowPosition = BerlinClockUtil.generateCorrectMinutesPattern(minutes,
					firstRowMinutes, firstRowPosition);
			BerlinClockUtil.generateHoursPatternForEmptyPosition(firstRowMinutes,
					firstRowPosition);

			int reminder = minutes % 5;
			int secondRowPosition = 0;
			for (; secondRowPosition < reminder; secondRowPosition++) {
				secondRowMinutes[secondRowPosition] = "Y";
			}
			BerlinClockUtil.generateHoursPatternForEmptyPosition(secondRowMinutes,
					secondRowPosition);
		}
	}

	

	void generateHoursPattern(int hrs, String[] firstRowHours,
			String[] secondRowHours) {
		
		int quotient = hrs / 5;
		
		if (hrs % 5 == 0) {
			int firstRowPosition = 0;
			
			firstRowPosition = BerlinClockUtil.generateCorrectHoursPosition(quotient, firstRowHours,
					firstRowPosition);
			
			BerlinClockUtil.generateHoursPatternForEmptyPosition(firstRowHours,
					firstRowPosition);
			BerlinClockUtil.generateEmptyRows(secondRowHours);
			
		} else {
			
			int reminder = hrs % 5;
			
			int firstRowPosition = 0;
			int secondRowPosition = 0;
			
			firstRowPosition = BerlinClockUtil.generateCorrectHoursPosition(quotient, firstRowHours,
					firstRowPosition);
			secondRowPosition = BerlinClockUtil.generateCorrectHoursPosition(reminder,
					secondRowHours, secondRowPosition);
					
			BerlinClockUtil.generateHoursPatternForEmptyPosition(firstRowHours,
					firstRowPosition);
			BerlinClockUtil.generateHoursPatternForEmptyPosition(secondRowHours,
					secondRowPosition);
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
