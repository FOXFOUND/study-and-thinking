#include <iostream>  
using namespace std;
const int N = 3;
const int V = 5;//5  
int weight[N + 1] = { 0, 3, 2, 2 };
int Value[N + 1] = { 0, 5, 10, 20 };

int f[V + 1] = { 0 };

int Completeknapsack()
{
	f[0] = 0;
	for (int i = 1; i <= N; i++)
	{
		for (int v = weight[i]; v <= V; v++)
		{
			f[v] = max(f[v], f[v - weight[i]] + Value[i]);
		}
	}
	return f[V];
}
int main()
{
	cout << Completeknapsack() << endl;
	system("pause");
	return 1;
}