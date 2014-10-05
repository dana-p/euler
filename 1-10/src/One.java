//Author: Daniela Prajea

//If we list all the natural numbers below 10 that are multiples of 3 or 5, 
//we get 3, 5, 6 and 9. The sum of these multiples is 23.
//Find the sum of all the multiples of 3 or 5 below 1000.

public class One {

	public int sum = 0;
	public One(){
		for (int i = 1; i < 1000; i++){
			if (i%3==0 || i%5==0)
				sum+=i;
		}
	}

	public static void main(String args[]){
		One answer = new One();
		System.out.println("The answer is ... " + answer.sum);
	}
	
}
