package coopCounter;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CounterUnit {
	
	//short[] minSecTest = new short[]{0,30,59};
	//short[] hourTest = new short[]{0,15,23};
	
	Counter testCounter;
	//int o = hourTest.length;
	
	for(int i=0; i < hourTest.length; i++){
		// testCounter = new Counter(minSecTest[i], minSecTest[i], hourTest[i]);
	}

	//need to create an array testing different values
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void secondShouldIncreaseOne(){
		short secBefore, secAfter;
		
		secBefore = testCounter.getSecond();
		testCounter.incSecond();
		secAfter = testCounter.getSecond();
		
		if(secBefore!=59)
			assertEquals(secBefore,secAfter-1);	//seconds before should equal minutes -1
		else{
			assertEquals(secAfter,0);			//if seconds is 59, seconds should reset to 0
			this.minuteShouldIncreaseOne();		//and increase a minute
		}
	}
	@Test
	public void secondShouldDecreaseOne(){			
		short secBefore;
		short secAfter;
		
		secBefore = testCounter.getSecond();
		testCounter.decSecond();
		secAfter = testCounter.getSecond();
		
		if(secBefore!=0)
			assertEquals(secBefore,secAfter+1);	//seconds before should equal minutes +1	
		else
			assertEquals(secAfter,59);			//if seconds is 0, seconds should roll back to 59
			this.minuteShouldDecreaseOne();		//and decrease a minute
	}
	@Test
	public void minuteShouldIncreaseOne(){
		short minBefore, minAfter;
		
		minBefore = testCounter.getMinute();
		testCounter.incMinute();
		minAfter = testCounter.getMinute();
		
		if(minBefore!=59)
			assertEquals(minBefore,minAfter-1);	//minute before should equal minute after -1
		else{
			assertEquals(minAfter,0);			//if minutes is 59, minutes should reset to 0
			this.hourShouldIncreaseOne();		//and increase a hour
		}
	}
	@Test
	public void minuteShouldDecreaseOne(){
		short minBefore, minAfter;
		
		minBefore = testCounter.getMinute();
		testCounter.decMinute();
		minAfter = testCounter.getMinute();
		
		if(minBefore!=0)
			assertEquals(minBefore,minAfter+1);	//minute before should equal minute after +1
		else{
			assertEquals(minAfter,59);			//if minutes is 0, minutes should roll back to 59  
			this.secondShouldDecreaseOne();		//and decrease a hour
		}
	}
	@Test
	public void hourShouldIncreaseOne(){
		short hourBefore, hourAfter;
		
		hourBefore = testCounter.getHour();
		testCounter.incHour();
		hourAfter = testCounter.getHour();
		
		if(hourBefore!=23)
			assertEquals(hourBefore, hourAfter-1);	//hour before should equal hour after -1
		else{
			assertEquals(hourAfter,0);			//if hours is 23, hours should reset to 0 
		}
	}
	@Test
	public void hourShouldDecreaseOne(){
		short hourBefore, hourAfter;
		
		hourBefore = testCounter.getHour();		
		testCounter.decHour();
		hourAfter = testCounter.getHour();
		
		if(hourBefore!=0)
			assertEquals(hourBefore, hourAfter+1);	//hour before should equal hour after +1
		else{
			assertEquals(hourAfter, 23);		//if hours is 0, hours should roll back to 23
		}
	}
	
}
