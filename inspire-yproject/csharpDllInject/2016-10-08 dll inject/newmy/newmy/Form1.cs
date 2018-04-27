using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace newmy
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        [DllImport("user32.dll", EntryPoint = "FindWindow")]
        private extern static IntPtr FindWindow(string lpClassName, string lpWindowName);

        [DllImport("User32.dll", CharSet = CharSet.Auto)]
        public static extern int GetWindowThreadProcessId(IntPtr hwnd, out int ID);
        [DllImport("kernel32.dll")]
        public static extern int OpenProcess(int dwDesiredAccess, bool bInheritHandle, int dwProcessId);

        [DllImport("kernel32.dll")]
        public static extern int VirtualAllocEx(int hwnd, int lpaddress, int size, int type, int tect);

        [DllImport("kernel32.dll")]
        public static extern int WriteProcessMemory(int hwnd, int baseaddress, string buffer, int nsize, int filewriten);

        [DllImport("kernel32.dll")]
        public static extern int CreateRemoteThread(int hwnd, int attrib, int size, int address, int par, int flags, int threadid);

        [DllImport("kernel32.dll")]
        public static extern int GetModuleHandleA(string name);

        [DllImport("kernel32.dll")]
        public static extern int GetProcAddress(int hwnd, string lpname);
        private void button2_Click(object sender, EventArgs e)
        {

            IntPtr hwnd = FindWindow(null, "目标进程");
            //查找进程的ID
            int PID;
            GetWindowThreadProcessId(hwnd, out PID);

            //  调用函数获得操作的句柄
            int calcProcess = OpenProcess(2 | 8 | 32, false, PID);
            // 分配内存空间，获得首地址
            int address = VirtualAllocEx(calcProcess, 0, @"D:\my\zhuru.dll".Length + 1, 4096, 64);

            // 调用函数写入内存
            if (WriteProcessMemory(calcProcess, address, @"D:\my\zhuru.dll", @"D:\\my\\zhuru.dll".Length + 1, 0) == 0)
            {
                MessageBox.Show("写入内存失败！");
            }

            if (CreateRemoteThread(calcProcess, 0, 0, GetProcAddress(GetModuleHandleA("Kernel32"), "LoadLibraryA"), address, 0, 0) == 0)
                MessageBox.Show("创建失败！");
            else
                MessageBox.Show("成功");

        }
    }
}
