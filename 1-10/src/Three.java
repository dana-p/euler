/* The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

public class Three {

	public static double theNumber = 600851475143.0; 
	public int primeNumber = (int) ((theNumber+1)/2);
	public int not_prime = (int) ((theNumber+1)/2);
	public Three (){
		for (int i = (int)Math.sqrt(theNumber); i > 2; i--){
			if (theNumber % i == 0){
				for (int j = 2; j < i; j++)
					if (i % j == 0){
						not_prime = i;
						break;
					}
				if (i != not_prime){
					primeNumber = i; 
					break;
				}
			}
	}}
	
	public static void main (String args[]){
		Three answer = new Three();
		System.out.println(answer.primeNumber);
	}
}
