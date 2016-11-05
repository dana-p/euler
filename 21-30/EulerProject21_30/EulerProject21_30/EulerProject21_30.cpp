// EulerProject21_30.cpp : Defines the entry point for the console application.

#include "stdafx.h"
#include "21.h"
#include "22.h"
#include <string>
#include <iostream>

int problemNum = 22; 
void problemTwentyOne();
void problemTwentyTwo();
void problemTwentyThree();
void problemTwentyFour();
void problemTwentyFive();
void problemTwentySix();
void problemTwentySeven();
void problemTwentyEight();
void problemTwentyNine();
void problemThirty();

int main()
{
	std::cout << "The answer to problem " << problemNum << " is: ";
	switch (problemNum) {
		case 21: { problemTwentyOne();	break; }
		case 22: { problemTwentyTwo();	break; }
		case 23: { problemTwentyThree();break; }
		case 24: { problemTwentyFour();	break; }
		case 25: { problemTwentyFive();	break; }
		case 26: { problemTwentySix();	break; }
		case 27: { problemTwentySeven();break; }
		case 28: { problemTwentyEight();break; }
		case 29: { problemTwentyNine();	break; }
		case 30: { problemThirty();		break; }
	}
	std::cout << std::endl;
    return 0;
}

void problemTwentyOne() {
	TwentyOne problem = TwentyOne();
	std::cout << problem.Solution(10000);
}

void problemTwentyTwo() {
	TwentyTwo problem = TwentyTwo();
	std::cout << problem.Solution();
}
void problemTwentyThree(){}
void problemTwentyFour() {}
void problemTwentyFive() {}
void problemTwentySix() {}
void problemTwentySeven() {}
void problemTwentyEight() {}
void problemTwentyNine() {}
void problemThirty() {}
