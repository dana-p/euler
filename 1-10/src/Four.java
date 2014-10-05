/*A palindromic number reads the same both ways. The largest palindrome 
 * made from the product of two 2-digit numbers is 9009 = 91 � 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
*/

//999 * 999 = 998001 therfore, out number has to be smaller than 998001. 
public class Four {
	
	public int palindrome = 9009;
	public Four () {
		for (int i = 998001; i > 1; i--){
			if ((i/1000)%10 == (i%1000)/100 && 
				(i/10000)%10 == (i%100)/10 &&
				(i/100000 == i%10))
				for (int j = 999; j > 100; j--)
					if (i%j == 0 && i/j<1000){
						palindrome = i;
						return;
					}
		}	
	}
	
	public static void main (String args[]){
		Four answer = new Four();
		System.out.println(answer.palindrome);
	}
}
