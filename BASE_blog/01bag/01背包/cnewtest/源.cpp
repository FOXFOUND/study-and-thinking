#include<iostream>
using namespace std;
class m
{
private :
	static int t;
	int m1 = 20;
public:
	 int show()
	{
		//t = 10;
		return t;
	}
};
int  m::t = 10;
void main()
{
	m m1 = m();
	cout<< m1.show();
}