#include<iostream>
#include<vector>
using namespace std;
int main()
{
	int n, m;
	cin >> n >> m;
	vector<int> dp(n + 1);
	//dp[1] = 1;
	dp[0] = 1;

	for (int i = 1; i < m; i++)
	{
		for (int j = n-1; j >=1; j--)
		{
			//dp[j] = dp[j - 1 <0 ? n  : j - 1] + dp[j + 1 >n-1 ? 0 : j + 1];
			//dp[j] = dp[j - 1 ==0 ? n -1: j - 1] + dp[j + 1 ==n -1 ? 0 : j + 1];
			dp[j] = dp[j - 1 < 0 ? n : j - 1] + dp[j + 1 > n ? 0 : j + 1];
		}
	}
	cout << dp[1] << endl;
	cout << "****************" << endl;
	for (int i = 0; i < dp.size(); i++)
	{
		cout << dp[i] << endl;
	}
	return 0;
}