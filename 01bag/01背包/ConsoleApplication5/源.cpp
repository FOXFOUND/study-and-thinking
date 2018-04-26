#include<iostream>
#include<vector>
using namespace std;
inline int max(int a, int b) { return a > b ? a : b; }
int main()
{
	int n,V;
	cin >> n>>V;
	//const int m = n;
	//int a[m];
	vector<int> val(n);
	for (int i = 0; i < val.size(); i++)
	{
		cin >> val[i];
	}

	vector<int> dp(V + 1);
	for (int i = 0; i < n; i++)
	{
		for (int j = V; j >=val[i]; j--)
		{
			dp[j] = max(dp[j], dp[j - val[i]] + 1);
		}
	}
	cout << dp[V]<<endl;
	cout << "********************" << endl;
	for (int i = 0; i < dp.size(); i++)
	{
		cout << dp[i] << endl;
	}
}