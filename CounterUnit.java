package coopCounter;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;


public class CounterUnit {
	Counter testCounter;
	short[] minSecTestValues = {0,15,30,45,59};		//test values to confirm that methods work
	short[] hourTestValues = {0,6,12,18,23};
	

	@Test
	public void secondShouldIncreaseOne(){
		short secBefore, secAfter;
		
		for(int i=0; i<hourTestValues.length; i++){				//Will test specific values
			testCounter = new Counter(minSecTestValues[i], minSecTestValues[i], hourTestValues[i]);
			//System.out.println(testCounter.getTime(true));
			secBefore = testCounter.getSecond();
			testCounter.incSecond();
			secAfter = testCounter.getSecond();
			
			if(secBefore<59)
				assertEquals(secBefore,secAfter-1);	//seconds before should equal minutes -1
			else{
				assertEquals(secAfter,0);			//if seconds is 59, seconds should reset to 0
				this.minuteShouldIncreaseOne();		//and increase a minute
			}
		}
			
		
	}
	@Test
	public void secondShouldDecreaseOne(){			
		short secBefore;
		short secAfter;
		
		for(int i=0; i<hourTestValues.length; i++){				
			testCounter = new Counter(minSecTestValues[i], minSecTestValues[i], hourTestValues[i]);
			//System.out.println(testCounter.getTime(true));
			secBefore = testCounter.getSecond();
			testCounter.decSecond();
			secAfter = testCounter.getSecond();
			
			if(secBefore!=0)
				assertEquals(secBefore,secAfter+1);	//seconds before should equal minutes +1	
			else
				assertEquals(secAfter,59);			//if seconds is 0, seconds should roll back to 59				this.minuteShouldDecreaseOne();		//and decrease a minute	
		}
	}
	@Test
	public void minuteShouldIncreaseOne(){
		short minBefore, minAfter;
		
		for(int i=0; i<hourTestValues.length; i++){				
			testCounter = new Counter(minSecTestValues[i], minSecTestValues[i], hourTestValues[i]);
			//System.out.println(testCounter.getTime(true));
			minBefore = testCounter.getMinute();
			testCounter.incMinute();
			minAfter = testCounter.getMinute();
			
			if(minBefore<59)
				assertEquals(minBefore,minAfter-1);	//minute before should equal minute after -1
			else{
				assertEquals(minAfter,0);			//if minutes is 59, minutes should reset to 0
				this.hourShouldIncreaseOne();		//and increase a hour
			}
		}
	}
	@Test
	public void minuteShouldDecreaseOne(){
		short minBefore, minAfter;
		
		for(int i=0; i<hourTestValues.length; i++){				
			testCounter = new Counter(minSecTestValues[i], minSecTestValues[i], hourTestValues[i]);
			//System.out.println(testCounter.getTime(true));
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
	}
	@Test
	public void hourShouldIncreaseOne(){
		short hourBefore, hourAfter;
		
		for(int i=0; i<hourTestValues.length; i++){				
			testCounter = new Counter(minSecTestValues[i], minSecTestValues[i], hourTestValues[i]);
			//System.out.println(testCounter.getTime(true));
			hourBefore = testCounter.getHour();
			testCounter.incHour();
			hourAfter = testCounter.getHour();
			
			if(hourBefore < 23)
				assertEquals(hourBefore, hourAfter-1);	//hour before should equal hour after -1
			else{
				assertEquals(hourAfter,0);			//if hours is 23, hours should reset to 0 
			}
		}
	}
	@Test
	public void hourShouldDecreaseOne(){
		short hourBefore, hourAfter;
		
		for(int i=0; i<hourTestValues.length; i++){				
			testCounter = new Counter(minSecTestValues[i], minSecTestValues[i], hourTestValues[i]);
			//System.out.println(testCounter.getTime(true));
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
	
	//not working yet and not sure what I want to do yet
	@Test
	public void timeShouldBeStandard(){
		String military = testCounter.getTime(true);
		String standard = testCounter.getTime(false);
		//System.out.println("Military: "+military+"\nStandard: "+standard);
		
	}
	
	@After
	public void secMinHourShouldBeZero(){		//seconds, minutes, and hours should be reset to 0
		testCounter.reset();
		//System.out.println(testCounter.getTime(true));
		assertEquals(testCounter.getSecond(),0);
		assertEquals(testCounter.getMinute(),0);
		assertEquals(testCounter.getHour(),0);
	}
	
}
