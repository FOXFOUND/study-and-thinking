#include <fstream>   
#include<iostream>
using namespace std;
bool dllject()
{
	//const char filename[] = "new.txt";
	//std::ofstream fs;
	//fs.open(filename);
	//fs << "this is a test";
	//fs.close();
	//return true;
	////fs.op
	const char filename[] = "new.txt";
	ofstream fs(filename);
	//fs.open(filename);
	//fs.open();
	fs << "this is a test";

	fs.close();
	return true;
}