package coopCounter; 

public class Counter {
	private static short sec, min, hour;
	
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
	
	public short getSecond(){return sec;}
	
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
	public short getMinute(){return min;}
	
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
	public short getHour(){return hour;}
	
	//the purpose of the following functions is to reset the counter
	public void reset(){
		sec=0;
		min=0;
		hour=0;
	}
	
	
	
	//******************************************************************************
	//The following method are responsible for the counter's presentation and format
	//******************************************************************************
	
	public String getTime(boolean military){
		/* 
		 * getTime() is responsible for returning the time in either military or standard format
		 * military is true for military format and false for standard format
		 * getTime() will return the time in hh:mm:ss format and for standard time, have an attached
		 * abbreviation (AM/PM)
		*/
		
		String strSec = Integer.toString(sec);					//creates a string version of sec
		String strMin = Integer.toString(min);					//creates a string version of min
		String strHour = Integer.toString(hour);				//creates a string version of hour
		String strTime;											//declares for further use
		
		//the following is for formatting, if seconds, minutes, or hours are a single digit (less than 10)
		//then place an extra zero in front of it
		if(sec<10)
			strSec = "0" + strSec;
		if(min<10)
			strMin = "0" + strMin;
		if(hour<10)
			strHour = "0"+ strHour;
		
		strTime = strHour+":"+strMin+":"+strSec;				//stores the time in hh:mm:ss format
		
		if(!military)											//if standard time
			strTime = convertTime(strSec, strMin, hour);		//convert military time to standard
		
		
		return(strTime);										//will return the time in either standard or military time
	}
	
	
	private String convertTime(String strSec, String strMin, int hour){
		/* 
		 * convertTime() is responsible for converting military time into standard time.
		 * It will take military time, subtract 12 from it and add an abbreviation to it
		 * depending on the time. Times greater than or equal to 12 will have a PM and times 
		 * less than 12 will have an attached AM. This function will return the time as a 
		 * string in hh:mm:dd A/PM
		 */
		
		String abbreviation; 						//declares abbreviation
		String strHour;								//declares strHour	
		int standardHour = hour;					//assigns the parsed hour to standardHour
		
		if(standardHour>12){
			standardHour -= 12;						//will take military time and subtract 12 to convert to standard
			abbreviation = "PM";					//if time is greater than 12, PM
		}
		else
			abbreviation = "AM";					//in all other cases, AM
		
		if(standardHour==0)							//if its 0 0'clock convert to 12
			standardHour = 12;
		strHour = Integer.toString(standardHour);	//takes standard hour and converts it to a string
		
		if(standardHour<10)
			strHour = "0" + strHour;				//adds a zero in front of a number if less than 10 for correct formatting
		
		
		return(strHour+":"+strMin+":"+strSec+" "+abbreviation); //returns the time in hh:mm:ss format
	}
	

}
