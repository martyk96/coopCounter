package coopCounter; 

public class Counter {
	private short sec, min, hour, standardHour;
	
	//constructor for the counter class, takes the starting seconds, minutes, and hours as
	//its initial conditions
	public Counter(short startSec, short startMin, short startHour){
		sec = startSec;
		min = startMin;
		hour = startHour;		
	}
	
	
	//********************************************************************************
	//The following methods are responsible for increasing and decreasing the counter
	//********************************************************************************
	
	//the purpose of the following function is to increase or decrease our seconds by 1
	public void incSecond(){
		if (sec==59){
			sec = 0;
			this.incMinute();
		}
		else
			sec++;
		}
	public void decSecond(){
		if (sec==0){
			sec=59;
			this.decMinute();
		}
		else
			sec--;
		}
	
	//the purpose of the following function is to increase or decrease our minutes by 1
	public void incMinute(){
		if (min==59){
			min = 0;
			this.incHour();
		}
		else
			min++;
	}
	public void decMinute(){
		if (min==0){
			min=59;
			this.decHour();
		}
		else
			min--;
	}
	
	//the purpose of the following functions is to increase or decrease our hours by 1
	public void incHour(){
		if (hour==23)
			hour = 0;
		else
			hour++;
		}
	
	public void decHour(){
		if (hour==0){
			hour=23;
		}
		else
			hour--;
	}
	
	// *********************************************************
	// The following methods are responsible for getting values
	// *********************************************************
	public short getSecond(){return sec;}
	public short getMinute(){return min;}
	public short getHour(boolean military){
		standardHour = hour;						//assigns the parsed hour to standardHour
		
		if(standardHour>12)
			standardHour -= 12;						//will take military time and subtract 12 to convert to standard
		
		if(standardHour==0)							//if its 0 0'clock convert to 12
			standardHour = 12;
		
		if(military)								//return military hour if military
			return hour;
		else
			return standardHour;					//return standard hour if standard
		}
	public String getAbbreviation(){
		if(hour>12)						
			return "PM";										//if time is greater than 12, PM
		else
			return "AM";
	}
	public String getTime(boolean military){
		/* 
		 * getTime() is responsible for returning the time in either military or standard format
		 * military is true for military format and false for standard format
		 * getTime() will return the time in hh:mm:ss format and for standard time, have an attached
		 * abbreviation (AM/PM)
		*/
		String strTime;
		if(military)											//if military time
			strTime = formatTime(military);						//stores the time in hh:mm:ss format
		else													//if standard time
			strTime = convertTime();							//convert military time to standard

		return(strTime);										//will return the time in either standard or military time
	}
	
	
	
	//the purpose of the following functions is to reset the counter
	public void reset(){
		sec=0;
		min=0;
		hour=0;
	}
	
	
	
	//******************************************************************************
	//The following method are responsible for the counter's presentation and format
	//******************************************************************************
	private String formatTime(boolean military){
		/*
		 * the following is for formatting, if seconds, minutes, or hours are a single digit (less than 10)
		 * then place an extra zero in front of it. This method will perform the previous for both military
		 * and standard time
		 */
		String strSec = Integer.toString(sec);					//creates a string version of sec
		String strMin = Integer.toString(min);					//creates a string version of min
		String strHour;											//declares a string version of hour
		String strTime;											//declares for further use
		standardHour = getHour(false);
		
		if(military)
			strHour = Integer.toString(hour);					//if military, convert military hour to string
		else
			strHour = Integer.toString(standardHour);			//if standard, convert standard hour to string
		
		
		if(sec<10)
			strSec = "0" + strSec;
		if(min<10)
			strMin = "0" + strMin;
		if(hour<10 && military)									//for military time, if hour<10, add a zero in front					
			strHour = "0"+ strHour;
		else if(standardHour<10 && !military)					//for standard time, if standard hour<10, add a zero in front
			strHour = "0"+ strHour;
			
		strTime = strHour+":"+strMin+":"+strSec;
		
		return strTime;
	}
	private String convertTime(){
		/* 
		 * convertTime() is responsible for converting military time into standard time.
		 * It will take military time, subtract 12 from it and add an abbreviation to it
		 * depending on the time. Times greater than or equal to 12 will have a PM and times 
		 * less than 12 will have an attached AM. This function will return the time as a 
		 * string in hh:mm:dd A/PM
		 */
		
		String abbreviation; 						//declares abbreviation
		String strTime;								//declares strHour
		 
		strTime = formatTime(false);
		System.out.println(strTime);
		abbreviation = getAbbreviation();
	
		return(strTime+" "+abbreviation); 			//returns the time in hh:mm:ss format
	}
	

}
