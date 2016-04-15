/*
n! means n * (n - 1) * ... * 3 * 2 * 1

For example, 10! = 10 * 9 * ... * 3 * 2 * 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
*/

public class Twenty 
{	
	int _answer; 
	int [] largeNumber; 
	int [] largeNumber2; 
	public Twenty(int factorial)
	{
		_answer = 0; 
		CalculateNumber(factorial);
	}
	
	private void CalculateNumber(int factorial){
		
		int arraySize = 200;
		largeNumber = new int[arraySize]; 
		largeNumber2 = new int[arraySize]; 
		for (int i = 0; i < arraySize; i++){
			largeNumber[i] = 0; 
			largeNumber2[i] = 0; 
		}
		largeNumber[0] = 1;
		
		int mult = 1;
		while (true)
		{
			largeNumber2 = Multiply(largeNumber, mult); 
			if (++mult > factorial) {largeNumber=largeNumber2; break;}
			largeNumber = Multiply(largeNumber2, mult); 
			if (++mult > factorial) break;
		}
		SumOfArray(largeNumber); 
	}
	
	private int [] Multiply(int[] input, int multiplier)
	{
		System.out.println("\n\nReceived following array with this multiplier..." + multiplier); 
		for (int j = 0; j < input.length; j++) 
		{
			System.out.print(input[j] + " "); 
		}
		int [] output = new int [input.length];
		int mult1 = multiplier%10; 
		int mult2 = multiplier/10; 

		int value = 0; 		
		int carry = 0; 
		for (int j = 0; j < input.length; j++) 
		{
			value = input[j]*mult1+carry;
			if (value > 9)
				carry = value/10;
			else 
				carry = 0; 
			output[j] = value%10; 
		}
		
		if (mult2 > 0)
		{
			int j = 0; 
			while(j < (input.length-1)) 
			{
				value = input[j]*mult2+carry;
				if (value > 9)
					carry = value/10;
				else 
					carry = 0;
				int currentVal = output[++j]; 
				int newVal = currentVal + value%10; 
				if (newVal > 9)
					carry += newVal/10;
				output[j] = newVal%10; 
			}
		}
		
		System.out.println("\nOutputting following array after multiplication with ..." + multiplier); 
		for (int j = 0; j < output.length; j++) 
		{
			System.out.print(output[j] + " "); 
		}
		
		return output; 
	}
	
	private void SumOfArray(int [] largeNumberArray)
	{
		for (int i = 0; i < largeNumberArray.length; i++)
			_answer+= largeNumberArray[i]; 
	}
	
	public int getAnswer(){
		return _answer; 
	}

	public static void main(String args[]){
		Twenty s = new Twenty(Integer.parseInt(args[0]));
		
		System.out.println("The answer is " + s.getAnswer()+".");
	}
}
