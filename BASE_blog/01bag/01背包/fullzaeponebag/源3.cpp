#include <iostream>  
#include <assert.h>  
using namespace std;
/*
f[i][v]:前i件物品放入背包容量为v的背包获得的最大收益

f[i][v] = max(f[i - 1][v],f[i - 1][v - k * Wi] + k * Vi,其中 1<=k<= v/Wi)

边界条件
f[0][v] = 0;
f[i][0] = 0;
*/

const int N = 3;
const int V = 5;
int weight[N + 1] = { 0, 3, 2, 2 };
int Value[N + 1] = { 0, 5, 10, 20 };

int f[N + 1][V + 1] = { 0 };

int Completeknapsack()
{
	//边界条件  
	for (int i = 0; i <= N; i++)
	{
		f[i][0] = 0;
	}
	for (int v = 0; v <= V; v++)
	{
		f[0][v] = 0;
	}
	//递推  
	for (int i = 1; i <= N; i++)
	{
		for (int v = 1; v <= V; v++)
		{
			f[i][v] = 0;
			int nCount = v / weight[i];
			for (int k = 0; k <= nCount; k++)
			{
				f[i][v] = max(f[i][v], f[i - 1][v - k * weight[i]] + k * Value[i]);
			}
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