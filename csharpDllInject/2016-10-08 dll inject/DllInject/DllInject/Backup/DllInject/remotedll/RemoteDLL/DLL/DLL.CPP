#include <windows.h>
#include <tchar.h>

BOOL WINAPI DllMain( HINSTANCE hinstDLL, DWORD fdwReason, LPVOID lpvReserved )
{
    switch ( fdwReason )
    {
    case DLL_PROCESS_ATTACH:
        {
            MessageBox( NULL, _T("DLL已进入目标进程。"), _T("信息"), MB_ICONINFORMATION );
        }
        break;
    case DLL_PROCESS_DETACH:
        {
            MessageBox( NULL, _T("DLL已从目标进程卸载。"), _T("信息"), MB_ICONINFORMATION );
        }
        break;
    }
    return TRUE;
}
