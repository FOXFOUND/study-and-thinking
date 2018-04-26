using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace dlinject
{

    class Program
    {
        [DllImport("kernel32.dll")] //声明API函数
        public static extern int VirtualAllocEx(IntPtr hwnd, int lpaddress, int size, int type, int tect);

        [DllImport("kernel32.dll")]
        public static extern int WriteProcessMemory(IntPtr hwnd, int baseaddress, string buffer, int nsize, int filewriten);

        [DllImport("kernel32.dll")]
        public static extern int GetProcAddress(int hwnd, string lpname);

        [DllImport("kernel32.dll")]
        public static extern int GetModuleHandleA(string name);

        [DllImport("kernel32.dll")]
        public static extern int CreateRemoteThread(IntPtr hwnd, int attrib, int size, int address, int par, int flags, int threadid);
        static void Main(string[] args)
        {

            int ok1;
            //int ok2;
            //int hwnd;
            int baseaddress;
            int temp = 0;
            int hack;
            int yan;
            string dllname;

            dllname = @"D:\my\zhuru.dll";
          //  dllname = @"D:\my\my.dll";
            int dlllength;
            dlllength = dllname.Length + 1;
            Process[] pname = Process.GetProcesses(); //取得所有进程
            foreach (Process name in pname) //遍历进程
            {
                //Console.WriteLine(name.ProcessName.ToLower());
                if (name.ProcessName.ToLower().IndexOf("目标进程") != -1) //所示记事本，那么下面开始注入
                {
                    baseaddress = VirtualAllocEx(name.Handle, 0, dlllength, 4096, 4);   //申请内存空间
                    if (baseaddress == 0) //返回0则操作失败，下面都是
                    {
                        Console.WriteLine("申请内存空间失败！！");
                        return;
                    }

                    ok1 = WriteProcessMemory(name.Handle, baseaddress, dllname, dlllength, temp); //写内存
                    if (ok1 == 0)
                    {
                        Console.WriteLine("写内存失败！！");
                        return;
                    }

                    hack = GetProcAddress(GetModuleHandleA("Kernel32"), "LoadLibraryA"); //取得loadlibarary在kernek32.dll地址

                    if (hack == 0)
                    {
                        Console.WriteLine("无法取得函数的入口点！！");
                        return;
                    }

                    yan = CreateRemoteThread(name.Handle, 0, 0, hack, baseaddress, 0, temp); //创建远程线程。

                    if (yan == 0)
                    {
                        Console.WriteLine("创建远程线程失败！！");
                       // Console.ReadLine();
                        return;
                    }
                    else
                    {
                        Console.WriteLine("已成功注入dll!!");
                    }
                    

                }
            }
            
            Console.ReadLine();
        }
    }
}
