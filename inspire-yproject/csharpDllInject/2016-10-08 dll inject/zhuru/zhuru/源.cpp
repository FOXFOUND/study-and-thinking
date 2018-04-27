#include<objbase.h>
#include<fstream>
#include<iostream>

BOOL APIENTRY DllMain(HANDLE hModule, DWORD dwReason, void * lpReserved)
{
	//const char filename[] = "D:\my\new1.txt";
	const char filename[] = "hello.txt";
	std::ofstream fs;
	HANDLE g_hmule;
	
	switch (dwReason)
	{
	case DLL_PROCESS_ATTACH:
		fs.open(filename);
		fs << "this is a test ,successful,hello admin";
		fs.close();
		break;
	}
		
	
	return true;
}