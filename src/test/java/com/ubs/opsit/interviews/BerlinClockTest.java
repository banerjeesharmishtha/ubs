package com.ubs.opsit.interviews;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class BerlinClockTest {
	BerlinClock berlinClock=new BerlinClock();
  
	@Test
	  public void testGenerateFinalResult() {
		StringBuilder finalDisplay=new StringBuilder();
		String[][] timeDisplay={{"Y"},{"R","R","O","O"},{"R"},{"Y"}};
	       berlinClock.generateFinalResult(finalDisplay,timeDisplay);
	      
	      assertThat(finalDisplay.toString(), is("Y\r\nRROO\r\nR\r\nY\r\n"));
	  }
	@Test
	  public void testGenerateHoursPatternForEmptyPositionWherePositionisLessThanRowLength() {
		String [] string=new String[1];
	      berlinClock.generateHoursPatternForEmptyPosition(string, 0);
	      
	      assertThat(string[0], is("O"));
	  }
	@Test
	  public void testGenerateHoursPatternForEmptyPositionWherePositionisGreaterThanRowLength() {
		String [] string=new String[1];
	      berlinClock.generateHoursPatternForEmptyPosition(string, 1);
	      
	      assertNull(string[0]);
	  }
	@Test
	  public void testGenerateSecondsPatternForEvenSeconds() {
		String [] string=new String[1]; 
		berlinClock.generateSecondsPattern(10, string);
	      
	      assertThat(string[0], is("Y"));
	  }
	@Test
	  public void testGenerateSecondsPatternForOddSeconds() {
		String [] string=new String[1]; 
		berlinClock.generateSecondsPattern(55, string);
	      
	      assertThat(string[0], is("O"));
	  }
	@Test
	  public void testGenerateEmptyRows() {
		String [] string=new String[1]; 
	     berlinClock.generateEmptyRows(string);
	      
	      assertThat(string[0], is("O"));
	  }
	@Test
	  public void testGenerateCorrectHoursPosition() {
		String [] string=new String[4]; 
	     int rowPosition=berlinClock.generateCorrectHoursPosition(2, string, 0);
	     assertThat(rowPosition, is(2));
	      assertThat(string[1], is("R"));
	  }
	@Test
	  public void testgenerateHoursPatternForHrsMultipleOf5() {
		String [] firstRowHours=new String[4];
		String [] secondRowHours=new String[4];
	      berlinClock.generateHoursPattern(20, firstRowHours, secondRowHours);
	      assertThat(firstRowHours[1], is("R"));
	      assertThat(secondRowHours[0], is("O"));
	  }
	@Test
	  public void testgenerateHoursPatternForHrsNotAMultipleOf5() {
		String [] firstRowHours=new String[4];
		String [] secondRowHours=new String[4];
	      berlinClock.generateHoursPattern(22, firstRowHours, secondRowHours);
	      assertThat(firstRowHours[2], is("R"));
	      assertThat(secondRowHours[3], is("O"));
	  }
	@Test
	  public void testGenerateCorrectMinutesPatternForMultipleOf5AndDivisibleBy3() {
		String [] string=new String[11]; 
	     int rowPosition = berlinClock.generateCorrectMinutesPattern(45, string, 0);
	     assertThat(rowPosition, is(9));
	      assertThat(string[3], is("Y"));
	  }
	@Test
	  public void testGenerateCorrectMinutesPatternForMultipleOf5ButNotDivisibleBy3() {
		String [] string=new String[11]; 
	     int rowPosition = berlinClock.generateCorrectMinutesPattern(50, string, 0);
	     assertThat(rowPosition, is(10));
	      assertThat(string[2], is("R"));
	  }
	@Test
	  public void testGenerateCorrectMinutesPatternForNotMultipleOf5AndDivisibleBy3() {
		String [] string=new String[11]; 
	     int rowPosition = berlinClock.generateCorrectMinutesPattern(41, string, 0);
	     assertThat(rowPosition, is(8));
	      assertThat(string[5], is("R"));
	  }
	@Test
	  public void testGenerateCorrectMinutesPatternForNotMultipleOf5ButNotDivisibleBy3() {
		String [] string=new String[11]; 
	     int rowPosition = berlinClock.generateCorrectMinutesPattern(50, string, 0);
	     assertThat(rowPosition, is(10));
	      assertThat(string[9], is("Y"));
	  }
	@Test
	  public void testGenerateMinutesPattern() {
		String [] firstRowMinute=new String[11];
		String [] secondRowMinute=new String[4];
	      berlinClock.generateMinutesPattern(45, firstRowMinute, secondRowMinute);
	      assertThat(firstRowMinute[9], is("O"));
	      assertThat(secondRowMinute[3], is("O"));
	  }
	@Test
	  public void scenario1() {
	      String display=new BerlinClock().convertTime("02:34:55");
	      
	      assertThat(display, is("O\r\nOOOO\r\nRROO\r\nYYRYYROOOOO\r\nYYYY"));
	  }
	@Test
	  public void scenario2() {
	      String display=new BerlinClock().convertTime("15:25:30");
	      
	      assertThat(display, is("Y\r\nRRRO\r\nOOOO\r\nYYRYYOOOOOO\r\nOOOO"));
	  }
	
	@Test
	  public void scenario3() {
	      String display=new BerlinClock().convertTime("17:33:45");
	      
	      assertThat(display, is("O\r\nRRRO\r\nRROO\r\nYYRYYROOOOO\r\nYYYO"));
	  }
	@Test
	  public void scenario4() {
	      String display=new BerlinClock().convertTime("05:10:00");
	      
	      assertThat(display, is("Y\r\nROOO\r\nOOOO\r\nYYOOOOOOOOO\r\nOOOO"));
	  }@Test
	  public void scenario5() {
	      String display=new BerlinClock().convertTime("09:51:25");
	      
	      assertThat(display, is("O\r\nROOO\r\nRRRR\r\nYYRYYRYYRYO\r\nYOOO"));
	  }
	  @Test
	  public void scenario6() {
	      String display=new BerlinClock().convertTime("23:00:00");
	      
	      assertThat(display, is("Y\r\nRRRR\r\nRRRO\r\nOOOOOOOOOOO\r\nOOOO"));
	  }
	  @Test
	  public void scenario7() {
	      String display=new BerlinClock().convertTime("16:40:05");
	      
	      assertThat(display, is("O\r\nRRRO\r\nROOO\r\nYYRYYRYYOOO\r\nOOOO"));
	  }
	
	  @Test
	  public void scenario1OfStory() {
	      String display=berlinClock.convertTime("00:00:00");
	      
	      assertThat(display, is("Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO"));
	  }
	  
	  @Test
	  public void scenario2OfStory() {
	      String display=berlinClock.convertTime("13:17:01");
	      
	      assertThat(display, is("O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO"));
	  }
	  @Test
	  public void scenario3OfStory() {
	      String display=berlinClock.convertTime("23:59:59");
	      
	      assertThat(display, is("O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY"));
	  }
	  
	  @Test
	  public void scenario4OfStory() {
	      String display=berlinClock.convertTime("24:00:00");
	      
	      assertThat(display, is("Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO"));
	  }
	  
}
