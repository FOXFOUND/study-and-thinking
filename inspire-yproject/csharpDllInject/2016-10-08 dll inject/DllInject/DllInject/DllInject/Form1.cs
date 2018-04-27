using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Runtime.InteropServices;
using System.Diagnostics;


namespace DllInject
{
    public partial class Form1 : Form
    {

        #region DllImport
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
        #endregion

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            int ok1;
            int baseaddress;
            int temp = 0;
            int hack;
            int yan;
            string dllname;
            //此文件必须为Win32 Dll
            dllname = @"D:\DLL.dll";
            int dlllength;
            dlllength = dllname.Length + 2;
            Process[] pname = Process.GetProcesses(); //取得所有进程
            foreach (Process name in pname) //遍历进程
            {
                //MessageBox.Show(name.ProcessName.ToLower());
                if (name.ProcessName.ToLower().IndexOf("notepad") != -1) //所示记事本，那么下面开始注入
                {
                    //--
                    baseaddress = VirtualAllocEx(name.Handle, 0, dlllength, 4096, 4);  //申请内存空间
                    if (baseaddress == 0) //返回0则操作失败，下面都是
                    {
                        MessageBox.Show("申请内存空间失败！！");
                        Application.Exit();
                    }

                    //写内存
                    ok1 = WriteProcessMemory(name.Handle, baseaddress, dllname, dlllength, temp);
                    if (ok1 == 0)
                    {

                        MessageBox.Show("写内存失败！！");
                        Application.Exit();
                    }

                    //取得loadlibarary在kernek32.dll地址
                    hack = GetProcAddress(GetModuleHandleA("Kernel32"), "LoadLibraryA");
                    if (hack == 0)
                    {
                        MessageBox.Show("无法取得函数的入口点！！");
                        Application.Exit();
                    }

                    //创建远程线程。
                    yan = CreateRemoteThread(name.Handle, 0, 0, hack, baseaddress, 0, temp);
                    if (yan == 0)
                    {
                        MessageBox.Show("创建远程线程失败！！");
                        Application.Exit();
                    }
                    else
                    {
                        MessageBox.Show("已成功注入dll!!");
                    }
                }
            }
        }


    }
}
