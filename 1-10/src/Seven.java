//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

//What is the 10001st prime number?

public class Seven {
	
	int primeNumber;
	
	Seven(){
		
		int NumberWeAreAt = 3; //we're starting with the third prime
		primeNumber = 5; //5 is the third prime
		int testprime = 7;
		boolean prime;
		while(NumberWeAreAt < 10001){
			
			prime = true;
			for (int i = 2; i < testprime; i++){
				if (testprime%i == 0){
					prime = false;
					break;
				}
			}
			//if the 'testprime' passed the test and prime is still 'true'
			//then set the next prime number to the newly found one
			if (prime == true){
				primeNumber = testprime;
				NumberWeAreAt++;
			}
			testprime++; 
		}
	}
	
	public static void main(String []args){
		Seven answer = new Seven();
		System.out.println(answer.primeNumber);
	}
}
