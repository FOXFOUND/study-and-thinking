#include <windows.h>
#include <tchar.h>
#include <TLHELP32.H>

#include "resource.h"

DWORD FindTarget( LPCTSTR lpszProcess )
{
    DWORD dwRet = 0;
    HANDLE hSnapshot = CreateToolhelp32Snapshot( TH32CS_SNAPPROCESS, 0 );
    PROCESSENTRY32 pe32;
    pe32.dwSize = sizeof( PROCESSENTRY32 );
    Process32First( hSnapshot, &pe32 );
    do
    {
        if ( lstrcmpi( pe32.szExeFile, lpszProcess ) == 0 )
        {
            dwRet = pe32.th32ProcessID;
            break;
        }
    } while ( Process32Next( hSnapshot, &pe32 ) );
    CloseHandle( hSnapshot );
    return dwRet;
}

BOOL RemoteLoadLibrary( DWORD dwProcessID, LPCSTR lpszDll )
{
    // 打开目标进程
    HANDLE hProcess = OpenProcess( PROCESS_CREATE_THREAD | PROCESS_VM_OPERATION | PROCESS_VM_WRITE, FALSE, dwProcessID );
    // 向目标进程地址空间写入DLL名称
    DWORD dwSize, dwWritten;
    dwSize = lstrlenA( lpszDll ) + 1;
    LPVOID lpBuf = VirtualAllocEx( hProcess, NULL, dwSize, MEM_COMMIT, PAGE_READWRITE );
    if ( NULL == lpBuf )
    {
        CloseHandle( hProcess );
        return FALSE;
    }
    if ( WriteProcessMemory( hProcess, lpBuf, (LPVOID)lpszDll, dwSize, &dwWritten ) )
    {
        // 要写入字节数与实际写入字节数不相等，仍属失败
        if ( dwWritten != dwSize )
        {
            VirtualFreeEx( hProcess, lpBuf, dwSize, MEM_DECOMMIT );
            CloseHandle( hProcess );
            return FALSE;
        }
    }
    else
    {
        CloseHandle( hProcess );
        return FALSE;
    }
    // 使目标进程调用LoadLibrary，加载DLL
    DWORD dwID;
    LPVOID pFunc = LoadLibraryA;
    HANDLE hThread = CreateRemoteThread( hProcess, NULL, 0, (LPTHREAD_START_ROUTINE)pFunc, lpBuf, 0, &dwID );
    // 等待LoadLibrary加载完毕
    WaitForSingleObject( hThread, INFINITE );
    // 释放目标进程中申请的空间
    VirtualFreeEx( hProcess, lpBuf, dwSize, MEM_DECOMMIT );
    CloseHandle( hThread );
    CloseHandle( hProcess );
    return TRUE;
}

BOOL RemoteFreeLibrary( DWORD dwProcessID, LPCSTR lpszDll )
{
    // 打开目标进程
    HANDLE hProcess = OpenProcess( PROCESS_CREATE_THREAD | PROCESS_VM_OPERATION | PROCESS_VM_WRITE, FALSE, dwProcessID );
    // 向目标进程地址空间写入DLL名称
    DWORD dwSize, dwWritten;
    dwSize = lstrlenA( lpszDll ) + 1;
    LPVOID lpBuf = VirtualAllocEx( hProcess, NULL, dwSize, MEM_COMMIT, PAGE_READWRITE );
    if ( NULL == lpBuf )
    {
        CloseHandle( hProcess );
        return FALSE;
    }
    if ( WriteProcessMemory( hProcess, lpBuf, (LPVOID)lpszDll, dwSize, &dwWritten ) )
    {
        // 要写入字节数与实际写入字节数不相等，仍属失败
        if ( dwWritten != dwSize )
        {
            VirtualFreeEx( hProcess, lpBuf, dwSize, MEM_DECOMMIT );
            CloseHandle( hProcess );
            return FALSE;
        }
    }
    else
    {
        CloseHandle( hProcess );
        return FALSE;
    }
    // 使目标进程调用GetModuleHandle，获得DLL在目标进程中的句柄
    DWORD dwHandle, dwID;
    LPVOID pFunc = GetModuleHandleA;
    HANDLE hThread = CreateRemoteThread( hProcess, NULL, 0, (LPTHREAD_START_ROUTINE)pFunc, lpBuf, 0, &dwID );
    // 等待GetModuleHandle运行完毕
    WaitForSingleObject( hThread, INFINITE );
    // 获得GetModuleHandle的返回值
    GetExitCodeThread( hThread, &dwHandle );
    // 释放目标进程中申请的空间
    VirtualFreeEx( hProcess, lpBuf, dwSize, MEM_DECOMMIT );
    CloseHandle( hThread );
    // 使目标进程调用FreeLibrary，卸载DLL
    pFunc = FreeLibrary;
    hThread = CreateRemoteThread( hProcess, NULL, 0, (LPTHREAD_START_ROUTINE)pFunc, (LPVOID)dwHandle, 0, &dwID );
    // 等待FreeLibrary卸载完毕
    WaitForSingleObject( hThread, INFINITE );
    CloseHandle( hThread );
    CloseHandle( hProcess );
    return TRUE;
}

int CALLBACK MainDlgProc( HWND hDlg, UINT uMsg, WPARAM wParam, LPARAM lParam )
{
    static DWORD dwProcessID;
    switch ( uMsg )
    {
    case WM_INITDIALOG:
        {
            dwProcessID = 0;
            SendDlgItemMessage( hDlg, IDC_EDT_TARGET, EM_LIMITTEXT, MAX_PATH, 0 );
        }
        break;
    case WM_COMMAND:
        {
            switch ( LOWORD( wParam ) )
            {
            case IDC_BTN_EXIT:
                {
                    EndDialog( hDlg, 0 );
                }
                break;
            case IDC_BTN_INSERT:
                {
                    TCHAR szTarget[MAX_PATH];
                    GetDlgItemText( hDlg, IDC_EDT_TARGET, szTarget, MAX_PATH );
                    dwProcessID = FindTarget( szTarget );
                    if ( 0 == dwProcessID )
                    {
                        MessageBox( hDlg, _T("找不到目标进程。"), _T("错误"), MB_ICONINFORMATION );
                        break;
                    }
                    if ( !RemoteLoadLibrary( dwProcessID, "DLL.dll" ) )
                    {
                        MessageBox( hDlg, _T("远程DLL加载失败。"), _T("错误"), MB_ICONINFORMATION );
                    }
                }
                break;
            case IDC_BTN_DETACH:
                {
                    if ( 0 == dwProcessID )
                    {
                        MessageBox( hDlg, _T("找不到目标进程。"), _T("错误"), MB_ICONINFORMATION );
                        break;
                    }
                    if ( !RemoteFreeLibrary( dwProcessID, "DLL.dll" ) )
                    {
                        MessageBox( hDlg, _T("远程DLL卸载失败。"), _T("错误"), MB_ICONINFORMATION );
                    }
                }
                break;
            }
        }
        break;
    case WM_CLOSE:
        {
            EndDialog( hDlg, 0 );
        }
        break;
    }
    return 0;
}

int WINAPI _tWinMain( HINSTANCE hInstance, HINSTANCE hPrevInstance, LPTSTR lpCmdLine, int nShowCmd )
{
    return DialogBox( hInstance, MAKEINTRESOURCE( IDD_MAIN_DLG ), NULL, MainDlgProc );
}