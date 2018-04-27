#include <windows.h>
#include <tchar.h>
#include<fstream>
BOOL WINAPI DllMain( HINSTANCE hinstDLL, DWORD fdwReason, LPVOID lpvReserved )
{
    switch ( fdwReason )
    {
    case DLL_PROCESS_ATTACH:
        {
            MessageBox( NULL, _T("DLL已进入目标进程。hello admin"), _T("信息"), MB_ICONINFORMATION );
			const char filename[] = "new.txt";
			std::ofstream fs(filename);
			//fs.open(filename);
			//fs.open();
			fs << "this is a test";

			fs.close();

        }
        break;
    case DLL_PROCESS_DETACH:
        {
            MessageBox( NULL, _T("DLL已从目标进程卸载。hello admin"), _T("信息"), MB_ICONINFORMATION );
        }
        break;
    }
    return TRUE;
}
