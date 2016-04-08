/*
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
*/

public class Sixteen 
{	
	private int _sum; 
	public Sixteen(int shift)
	{
		// The resulting number will not have more digits than half of the shift. 
		int arraySize = shift/2; 
		int [] largeNumber = new int[arraySize]; 
		for (int i = 0; i < arraySize; i++)
			largeNumber[i] = 0; 
		largeNumber[0] = 1;
		CalculateNumber(largeNumber, shift);
		
		//SumOfDigits(shift); 
	}
	
	private void CalculateNumber(int [] largeNumberArray, int shift){
		int mult = 0; 
		int carry = 0; 
		for (int i = 0; i < shift; i++)
		{
			carry = 0; 
			// Multiply all values in the array and shift if necessary 
			for (int j = 0; j < largeNumberArray.length; j++) 
			{
				mult = largeNumberArray[j]*2+carry;
				if (mult > 9)
					carry = 1;
				else
					carry = 0; 
				largeNumberArray[j] = mult%10; 
			}
		}
	//	for (int j = 0; j < largeNumberArray.length; j++) 
	//	{
	//		System.out.print(largeNumberArray[j] + " ");
	//	}
		SumOfArray(largeNumberArray); 
	}
	
	private void SumOfArray(int [] largeNumberArray)
	{
		for (int i = 0; i < largeNumberArray.length; i++)
			_sum+= largeNumberArray[i]; 
	}
	
	private void SumOfDigits(int shift) 
	{
		double value = Math.pow(2,shift); 
		String num = String.format("%f", value); 
		System.out.println(num); 
		int length = num.length();
		System.out.println(length); 
		double toBeAdded = 0; 
		for (int i = 1; i < length; i++){
			toBeAdded = value%(Math.pow(10,i));
			value -= toBeAdded;
			_sum += toBeAdded/(Math.pow(10,i-1));
		}
	}
	
	public long getAnswer(){
		return _sum; 
	}

	public static void main(String args[]){
		int powerOfTwo = 1000; 
		Sixteen s = new Sixteen(powerOfTwo);
		
		System.out.println("\nThe sum of 2^"+powerOfTwo+"'s digits is " + s.getAnswer()+".");
	}
}

