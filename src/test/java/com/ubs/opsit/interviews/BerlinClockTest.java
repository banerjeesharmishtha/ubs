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
	  public void testGenerateMinutesPattern() {
		String [] firstRowMinute=new String[11];
		String [] secondRowMinute=new String[4];
	      berlinClock.generateMinutesPattern(45, firstRowMinute, secondRowMinute);
	      assertThat(firstRowMinute[9], is("O"));
	      assertThat(secondRowMinute[3], is("O"));
	  }
	
	@Test
	  public void scenario1() {
	      String display=berlinClock.convertTime("02:34:55");
	      
	      assertThat(display, is("O\r\nOOOO\r\nRROO\r\nYYRYYROOOOO\r\nYYYY"));
	  }
	
	@Test
	  public void scenario2() {
	      String display=berlinClock.convertTime("15:25:30");
	      
	      assertThat(display, is("Y\r\nRRRO\r\nOOOO\r\nYYRYYOOOOOO\r\nOOOO"));
	  }
	
	@Test
	  public void scenario3() {
	      String display=berlinClock.convertTime("17:33:45");
	      
	      assertThat(display, is("O\r\nRRRO\r\nRROO\r\nYYRYYROOOOO\r\nYYYO"));
	  }
	@Test
	  public void scenario4() {
	      String display=berlinClock.convertTime("05:10:00");
	      
	      assertThat(display, is("Y\r\nROOO\r\nOOOO\r\nYYOOOOOOOOO\r\nOOOO"));
	  }@Test
	  public void scenario5() {
	      String display=berlinClock.convertTime("09:51:25");
	      
	      assertThat(display, is("O\r\nROOO\r\nRRRR\r\nYYRYYRYYRYO\r\nYOOO"));
	  }
	  @Test
	  public void scenario6() {
	      String display=berlinClock.convertTime("23:00:00");
	      
	      assertThat(display, is("Y\r\nRRRR\r\nRRRO\r\nOOOOOOOOOOO\r\nOOOO"));
	  }
	  @Test
	  public void scenario7() {
	      String display=berlinClock.convertTime("16:40:05");
	      
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
