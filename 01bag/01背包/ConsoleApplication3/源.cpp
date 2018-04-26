#include<iostream>
using namespace std;
struct MyStruct
{
	int n;
	char a;
	long h;
	long long j;
};
union MyUnion
{
	int n;
	char a;
	long h;
};
void main()
{
	MyStruct m;
	m.a = 'a';
	cout << sizeof(m) << endl;
	MyUnion my;
	my.a = 'b';
	cout << sizeof(my) << endl;
	my.n = 0x12345678;
	cout << my.n << endl;
	cout << my.a << endl;
}