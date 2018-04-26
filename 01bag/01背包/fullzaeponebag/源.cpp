#include <iostream>  
#include <vector>  
#include <assert.h>  
using namespace std;
const int N = 3;
const int V = 5;//5  
int weight[N + 1] = { 0, 3, 2, 2 };
int Value[N + 1] = { 0, 5, 10, 20 };

int f[N + 1][V + 1] = { 0 };

int Completeknapsack()
{
	//≥ı ºªØ  
	for (int i = 0; i <= N; i++)
	{
		f[i][0] = 0;
	}
	for (int v = 0; v <= V; v++)
	{
		f[0][v] = 0;
	}
	for (int i = 1; i <= N; i++)
	{
		for (int v = weight[i]; v <= V; v++)
		{
			f[i][v] = max(f[i - 1][v], f[i][v - weight[i]] + Value[i]);
		}
	}
	return f[N][V];
}

int main()
{
	cout << Completeknapsack() << endl;
	system("pause");
	return 1;
}