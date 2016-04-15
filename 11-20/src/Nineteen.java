/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/

public class Nineteen 
{	
	int[] _allDates;
	int _year; 
	
	int _answer; 
	int _day; 
	int _resetDay; 
	
	public Nineteen()
	{
		// If 1 Jan 1900 was a Monday then 1 Jan 1901 was a Tuesday
		_answer = 0; 
		_year = 1901;
		_day = -5; // First Sunday is the 6th of January, 1901
		while (true) 
		{	
			// Checking if February 1 is a Sunday... 
			_day += 31; 
			CheckForSunday(); 
			
			// Checking if March 1 is a Sunday... 
			if (_year % 4 != 0 || _year==2000)
				_day += 28;
			else
				_day += 29;
			CheckForSunday(); 
			
			// Checking if April 1 is a Sunday... 
			_day += 31; 
			CheckForSunday(); 
			
			// May...
			_day += 30; //System.out.println("April"); 
			CheckForSunday(); 
			
			// June
			_day += 31; //System.out.println("May"); 
			CheckForSunday(); 
			
			// July
			_day += 30; 
			CheckForSunday(); 
			
			// August
			_day += 31; //System.out.println("Jul"); 
			CheckForSunday(); 
			
			// September
			_day += 31;// System.out.println("Aug"); 
			CheckForSunday(); 
			
			// October 
			_day += 30; //System.out.println("Sept"); 
			CheckForSunday(); 
			
			// November 
			_day += 31;// System.out.println("Oct"); 
			CheckForSunday(); 
			
			// December 
			_day += 30; 
			CheckForSunday(); 
			
			// Go to next year 
			_year++; 			
			if (_year == 2001)
				break;
			
			// Check if January 1 is a Sunday...
			_day += 31;
			CheckForSunday(); 
		}
	}
	private void CheckForSunday()
	{
		if (_day % 7==0){ // Then this is a Sunday 
			_answer++; 
			_day=0; 
		}
	}

	public int getAnswer(){
		return _answer; 
	}

	public static void main(String args[]){
		Nineteen n = new Nineteen();
		
		System.out.println("The answer is " + n.getAnswer()+".");
	}
}
