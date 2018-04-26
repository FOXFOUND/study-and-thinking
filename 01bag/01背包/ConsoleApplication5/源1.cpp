#include<iostream>
using namespace std;
int main()
{
	int a[2][2] = { 1, 2, 3, 4 };
	for (int i = 0; i < 4; i++)
	{
		cout << a[0][i] << endl;
	}
	return 0;
}