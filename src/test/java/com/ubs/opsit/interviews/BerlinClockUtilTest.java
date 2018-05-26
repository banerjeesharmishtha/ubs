package com.ubs.opsit.interviews;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class BerlinClockUtilTest {
	  
	
	@Test
	  public void testGenerateHoursPatternForEmptyPositionWherePositionisLessThanRowLength() {
		String [] string=new String[1];
		BerlinClockUtil.generateHoursPatternForEmptyPosition(string, 0);
	      
	      assertThat(string[0], is("O"));
	  }
	@Test
	  public void testGenerateHoursPatternForEmptyPositionWherePositionisGreaterThanRowLength() {
		String [] string=new String[1];
		BerlinClockUtil.generateHoursPatternForEmptyPosition(string, 1);
	      
	      assertNull(string[0]);
	  }
	
	
	@Test
	  public void testGenerateEmptyRows() {
		String [] string=new String[1]; 
		BerlinClockUtil.generateEmptyRows(string);
	      
	      assertThat(string[0], is("O"));
	  }
	
	@Test
	  public void testGenerateCorrectHoursPosition() {
		String [] string=new String[4]; 
	     int rowPosition=BerlinClockUtil.generateCorrectHoursPosition(2, string, 0);
	     assertThat(rowPosition, is(2));
	      assertThat(string[1], is("R"));
	  }
	
	@Test
	  public void testGenerateCorrectMinutesPatternForMultipleOf5AndDivisibleBy3() {
		String [] string=new String[11]; 
	     int rowPosition = BerlinClockUtil.generateCorrectMinutesPattern(45, string, 0);
	     assertThat(rowPosition, is(9));
	      assertThat(string[3], is("Y"));
	  }
	
	@Test
	  public void testGenerateCorrectMinutesPatternForMultipleOf5ButNotDivisibleBy3() {
		String [] string=new String[11]; 
	     int rowPosition = BerlinClockUtil.generateCorrectMinutesPattern(50, string, 0);
	     assertThat(rowPosition, is(10));
	      assertThat(string[2], is("R"));
	  }
	
	@Test
	  public void testGenerateCorrectMinutesPatternForNotMultipleOf5AndDivisibleBy3() {
		String [] string=new String[11]; 
	     int rowPosition = BerlinClockUtil.generateCorrectMinutesPattern(41, string, 0);
	     assertThat(rowPosition, is(8));
	      assertThat(string[5], is("R"));
	  }
	
	@Test
	  public void testGenerateCorrectMinutesPatternForNotMultipleOf5ButNotDivisibleBy3() {
		String [] string=new String[11]; 
	     int rowPosition = BerlinClockUtil.generateCorrectMinutesPattern(50, string, 0);
	     assertThat(rowPosition, is(10));
	      assertThat(string[9], is("Y"));
	  }
	
	
	  
}
