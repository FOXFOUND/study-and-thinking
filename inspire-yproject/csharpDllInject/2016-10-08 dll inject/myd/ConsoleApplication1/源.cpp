#include<iostream>
#include<fstream>
using namespace std;
void main()
{
	const char filename[] = "new.txt";
	ofstream fs(filename);
	//fs.open(filename);
	//fs.open();
	fs << "this is a test";

	fs.close();
	//return true;
}