#include<iostream>
#include<vector>
using namespace std;
void main()
{
	vector<int> a(20);
	a[1] = 5;
	for (int i = 0; i < 20; i++)
	{
		cout << a[i] << endl;
	}
	
}