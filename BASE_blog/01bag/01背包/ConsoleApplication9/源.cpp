#include<iostream>
using namespace std;
void main()
{
	int num = 28;
	int arr[30] = {0};
	int pri = 0;
	for (int i = 1; i < num; i++)
	{
		if (num%i==0)
		{
			arr[pri++] = i;
		}
	}
	int sum = 0;
	for (int i = 0; i < 30; i++)
	{
		sum += arr[i];
	}
	cout << ((sum == num )? 1 : 0)<<endl;
}