/*
he following iterative sequence is defined for the set of positive integers:

n -> n/2 (n is even)
n -> 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?
*/

import java.util.*; 

public class Fourteen 
{	
	int _longestLength = 0; 
	long _collatzNum = 0; 
	int [] _chains = new int[1000001]; 
	
	public Fourteen()
	{
		_chains[0] = 1; // Fill in first value 
		int newLength = 0; 
		for (int i = 1; i <= 1000000; i++){
			int thisLength = GetChainLength((long)i);
			_chains[i] = thisLength; 
			if (thisLength > _longestLength){
				_longestLength = thisLength; 
				_collatzNum = i; 
			}
		}
		
	//		for (int i = 1; i <= 13; i++){
	//			System.out.println(_chains[i]); 
	//	}
		
	}
	
	private int GetChainLength(long collatzNum)
	{
		int length = 1; 
		long collatzToChange = collatzNum; 
		while (collatzToChange != 1)
		{
			if ((collatzToChange&1) == 1){ // Odd
				collatzToChange = collatzToChange * 3 + 1; 
				length++; 
			}
			else{ // Even
				collatzToChange = collatzToChange >> 1; 
				if (collatzToChange < collatzNum){
					length += _chains[(int)collatzToChange];
					break; 
				}
				length++;
			}
		}
		return length; 
	}
	
	public long getAnswer(){
		return _collatzNum; 
	}
	
	public int getLength(){
		return _longestLength; 
	}
	
	
	public static void main(String args[]){
		Fourteen f = new Fourteen();
		
		System.out.println("The longest chain is produced by " + f.getAnswer() + " with length of " +f.getLength() +".");
	}
}

