#include<iostream>
using namespace std;


class d
{
public:
	int show();
	
};
class Person
{
private :
	int age=10;
	char gender;
public:
	int num;
	char male;
	friend int d::show();
protected:
	int n;
	char m;
};

int d::show()
{
	Person per=Person();
	cout << per.age << endl;
	return 0;
}
/*
  1. 不管继承方式如何 private 字段不能被继承

  2.在继承中 protected内的字段等价于 public
*/
class Son : public Person
{
public :
	void show()
	{
		//age  no
		//gender  no

		// num  yes
		//male  yes

		//n  yes
	}
};

class son : protected Person
{
public:
	void show()
	{
		//age no

		//num  yes

		//n yes
	}
};

class w :private Person
{
public:

	void show()
	{
		//age no

		// num yes

		//n  yes
	}
};

int main()
{
	cout << "hello admin" << endl;
	d d1=d();
	d1.show();
}

