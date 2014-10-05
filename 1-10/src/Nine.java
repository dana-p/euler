/*A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2

For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/
public class Nine {

	int abc; 

	public Nine (){
		boolean found = false;
		for (int a = 100; a < 900; a++){
			if (found == true)
				break;
			for (int b = 100; b < 900; b++)
				for (int c = 100; c < 900; c++)
					if (((a*a + b*b) == (c*c)) && a + b + c == 1000){
						System.out.println (a + " " + b + " " + c);
						abc = a * b * c;
						found = true;
					}
		}
	}
	
	public static void main(String args[]){
		Nine answer = new Nine();
		System.out.println(answer.abc);
	}
	
}
