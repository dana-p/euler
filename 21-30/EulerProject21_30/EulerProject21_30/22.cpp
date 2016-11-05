#include "22.h"

/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over 
five-thousand first names, begin by sorting it into alphabetical order. 
Then working out the alphabetical value for each name, multiply this value by its 
alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is 
worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
*/

using namespace std; 

string getNames();

void split(const string &s, char delim, vector<string> &elems);

int TwentyTwo::Solution() {
	string unorderedNames = getNames();

	// Put items in a vector and alphabetize 
	vector<string> unorderedNamesVector;
	split(unorderedNames, ',', unorderedNamesVector);
	sort(unorderedNamesVector.begin(), unorderedNamesVector.end());

	// Go through each name
	int position = 1;
	int sum = 0; 
	for (string name : unorderedNamesVector)
	{
		int nameSum = 0;
		for (char& c : name) {
			nameSum += (int)c - 64;
		}
		nameSum += 60; // Negating the effect of adding " 
		//cout << name << " : " << nameSum << " at " << position << endl;
		int score = nameSum * position; 
		sum += score;
		position++; 
	}
	return sum; 
}

void split(const string &inputString, char delim, vector<string> &elems) {
	stringstream ss;
	ss.str(inputString);
	string item;
	while (getline(ss, item, delim)) {
		elems.push_back(item);
	}
}

vector<string> split(const string &s, char delim) {
	vector<string> elems;
	split(s, delim, elems);
	return elems;
}

string getNames() {
	ifstream myfile;
	myfile.open("names.txt");
	string names; 
	if (myfile.is_open())
	{
		getline(myfile, names);
	}
	myfile.close();
	return names;
}