#include <iostream>
#include <algorithm>
#include <vector>
#include <iomanip>
#include <stdio.h>
using namespace std;

int IsSuitableTime(int i, int a[], int b[], int p, int c[], int d[], int q);
int main()
{
    int p, q, l, r;
	cin >> p >> q >> l >> r;
	int a[p], b[p], c[q], d[q];
	for (int i = 0; i<p; i++) {
		cin >> a[i] >> b[i];
	}
	for (int i = 0; i<q; i++) {
		cin >> c[i] >> d[i];
	}
	int num = 0;
	for (int t = l; t <= r; t++)
	{
		num += IsSuitableTime(t, a, b, p, c, d, q);
	}
	cout << num << endl;

}
int IsSuitableTime(int t, int a[], int b[], int p, int c[], int d[], int q)
{
	for (int i = 0; i<q; i++){
		int j = 0;
		while ((c[i] + t>b[j] || d[i] + t<a[j]) && j<p) {

			j++;
		}
		if (j<p)return 1;
	}
	return 0;

}