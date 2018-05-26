package com.ubs.opsit.interviews;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class testclass {
  
  
  @Test
  public void thisTestShouldPassIfYouHaveEverythingIsSetupCorrectly() {
      String display=new BerlinClock().convertTime("23:59:59");
      assertEquals("1223432",display);
      assertThat(true, is(true));
  }
  
}
