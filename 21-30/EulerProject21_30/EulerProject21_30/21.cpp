/* 
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
*/

#include "21.h"

int GetDivisorSum(int input);

int TwentyOne::Solution(int input)
{
	int sum = 0; 
	for (int i = 1; i < input; i++) {
		int divisorSum = GetDivisorSum(i);
		if (divisorSum < input && i == GetDivisorSum(divisorSum) && i != divisorSum) {
			sum = sum + i;
			std::cout << "Found amicable pair " << i << " and " << divisorSum << std::endl; 
		}
	}
	return sum;
}

int GetDivisorSum(int input) {
	int divisorSum = 1;
	//std::cout << "Getting divisors for " << input << std::endl;
	for (int i = 2; i < sqrt(input); i++) {
		if (input%i == 0) {
			divisorSum += i;
			divisorSum += input/i;
			//std::cout << "Found divisor " << i << " and " << input/i << std::endl;
		}
	}
	return divisorSum; 
}
