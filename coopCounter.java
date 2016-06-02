package coopCounter;

import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class coopCounter extends Frame{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Label counterLabel;    // Declare a Label component 
	private TextField counterDisplay; // Declare a TextField component 
	
	private Button secIncBut, secDecBut;   // Declare Button components
	private Button minIncBut, minDecBut;
	private Button hourIncBut, hourDecBut;
	private Button resetBut;
	
	private ButtonGroup timeFormat = new ButtonGroup();	//create button group, only one can be selected at a time
	private JRadioButton militaryTime;					//militaryTime option
	private JRadioButton standardTime;					//standardTime option 
	
	private static boolean timeType = true;				//instantiates timeType to be true, where true indicates military time
	
	private static Counter myCounter;					//declares myCounter
	
	
	
	
	public coopCounter(String time){
		
	setLayout(new FlowLayout());				//will switch this later

     counterLabel = new Label("Counter");  		// creates Label
     add(counterLabel);                    		// adds label to gui

     counterDisplay = new TextField(time, 10); 	// creates text field
     counterDisplay.setEditable(false);       	// set to read-only
     add(counterDisplay);                     	// adds TextField to gui

     
     //**********************************************************************************
     //The following creates buttons for the inc/decrement of seconds, minutes, and hours
     //as well as sets up the listeners for these buttons
     //**********************************************************************************
     
     setTitle("Time Counter");  // "super" Frame sets its title
     setSize(500, 200);         // "super" Frame sets its initial window size
     
     secIncBut = new Button("+ Sec");   // creates the buttons                     
     secDecBut = new Button("- Sec");  
     minIncBut = new Button("+ Min");                    
     minDecBut = new Button("- Min");
     hourIncBut = new Button("+ Hour");                   
     hourDecBut = new Button("- Hour");
     resetBut = new Button("Reset");
     
     add(secIncBut);					//adds Buttons
     add(secDecBut);
     add(minIncBut);			
     add(minDecBut);
     add(hourIncBut);					
     add(hourDecBut);
     add(resetBut);
     
     //The following are listeners for each and every button. Depending on what button was
     //pressed, a method from Counter will be called

	 secIncBut.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
        	myCounter.incSecond();
     		counterDisplay.setText(myCounter.getTime(timeType));
         }
      });
     secDecBut.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
        	myCounter.decSecond();
     		counterDisplay.setText(myCounter.getTime(timeType));
         }
      });
     minIncBut.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
        	myCounter.incMinute();
     		counterDisplay.setText(myCounter.getTime(timeType));
         }
      });
     minDecBut.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
        	myCounter.decMinute();
     		counterDisplay.setText(myCounter.getTime(timeType));
         }
      });
     hourIncBut.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
        	myCounter.incHour();
     		counterDisplay.setText(myCounter.getTime(timeType));
         }
      });
     hourDecBut.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
        	myCounter.decHour();
     		counterDisplay.setText(myCounter.getTime(timeType));
         }
      });
     resetBut.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
        	myCounter.reset();
     		counterDisplay.setText(myCounter.getTime(timeType));
         }
      });
     
   
     //******************************************************************
     //Sets up the option to view the time in standard or military time
     //****************************************************************** 
     
     //the following creates two radio buttons that will determine the format for the counter
     //the two options are standard and military time, military time is the default
     militaryTime = new JRadioButton("Military",true);
 	 standardTime = new JRadioButton("Standard");
 	
 	 timeFormat.add(militaryTime);
 	 timeFormat.add(standardTime);
 	
 	 add(militaryTime);
 	 add(standardTime);
 	
 	 militaryTime.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {         
        	timeType = true;							//true indicates military time
        	counterDisplay.setText(myCounter.getTime(timeType));
        	//System.out.println(timeType);
        }           
     });
 	 standardTime.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {         
        	timeType = false;							//false indicates standard time
        	counterDisplay.setText(myCounter.getTime(timeType));
        	//System.out.println(timeType);
        }           
     });

     setVisible(true);         //shows the frame

	}
	

	public static void main(String[] args) {
		final short SEC=0, MIN=0, HOUR=0;
		myCounter = new Counter(SEC, MIN, HOUR);		//instantiates myCounter with 0 secs, mins, and hours

		new coopCounter(myCounter.getTime(timeType));	//creates the counter
	}
}
