#include <iostream>  
#include <vector>  
#include <assert.h>  
using namespace std;
/*
f[v]:表示第i件物品放入容量为v的背包后，获得的最大容量
f[v] = max(f[v],f[v - weight[i]] + value[i]);
初始条件：f[0] = 0;
*/

const int N = 3;
const int V = 20;//5  
int weight[N + 1] = { 0, 3, 2, 2 };
int Value[N + 1] = { 0, 5, 10, 20 };

int NNew = 0;
vector<int> weightVector;
vector<int> Valuevector;
int f[V + 1] = { 0 };
/*拆分物品*/
void SplitItem()
{
	//从1开始  
	weightVector.push_back(0);
	Valuevector.push_back(0);
	//开始拆分  
	int nPower = 1;
	for (int i = 1; i <= N; i++)
	{
		nPower = 1;
		while (nPower * weight[i] <= V)
		{
			weightVector.push_back(nPower * weight[i]);
			Valuevector.push_back(nPower * Value[i]);
			nPower <<= 1;
		}
	}
}

int Completeknapsack()
{
	//拆分物品  
	SplitItem();
	//转化为01背包处理  
	NNew = weightVector.size() - 1;//多加了一个0，要减去  

	for (int i = 1; i <= NNew; i++)//物品个数变化  
	{
		for (int v = V; v >= weightVector[i]; v--)//背包容量仍是V  
		{
			f[v] = max(f[v], f[v - weightVector[i]] + Valuevector[i]);
		}
	}

	return f[NNew];
}
int main()
{
	cout << Completeknapsack() << endl;
	system("pause");
	return 1;
}