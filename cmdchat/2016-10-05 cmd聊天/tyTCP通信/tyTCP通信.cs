using System;
using System.Net;
using System.Net.Sockets;
using System.Collections.Generic;
using System.Text;
using System.IO;
using System.Threading;

namespace net
{
    class Program
    {
        private static Socket ServerSocket;
        static void S5566()
        {

            IPEndPoint ipEnd = new IPEndPoint(IPAddress.Any, 5566);
            Socket socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            socket.Bind(ipEnd);
            socket.Listen(10);
            Console.WriteLine("等待连接中......");
            Socket client = socket.Accept();
            ServerSocket = client;
            IPEndPoint ipEndClient = (IPEndPoint)client.RemoteEndPoint;
            Console.WriteLine("远程计算机{0}:{1}已连入......", ipEndClient.Address, ipEndClient.Port);
            NetworkStream ns = new NetworkStream(client);
            StreamWriter sw = new StreamWriter(ns);
            string welcome = "已经连接,可以通信了......";
            sw.WriteLine(welcome);
            sw.Flush();
            sw.Close();
            ns.Close();
        }

        static void KHIP()
        {
            string data;
            IPAddress ip = IPAddress.Parse("127.0.0.1");
            IPEndPoint ipEnd = new IPEndPoint(ip, 5566);
            Socket socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            try
            {
                socket.Connect(ipEnd);
            }
            catch (SocketException e)
            {
                Console.Write("无法连接到远程计算机.........");
                //Console.Write(e.ToString());
                Console.Read();
                return;
            }
            ServerSocket = socket;
            NetworkStream ns = new NetworkStream(socket);
            StreamReader sr = new StreamReader(ns);
            data = sr.ReadLine();
            Console.WriteLine(data);
            sr.Close();
            ns.Close();
        }


        static void Sdty()
        {
            string fwdata;
            NetworkStream ns2 = new NetworkStream(ServerSocket);
            StreamReader sr1 = new StreamReader(ns2);

            while (true)
            {
                try
                {
                    fwdata = sr1.ReadLine();
                }
                catch (IOException)
                {
                    break;
                }
                Console.WriteLine(fwdata);
            }
            Console.WriteLine("连接已经断开......");
            sr1.Close();
            ns2.Close();
            Console.Read();
        }
        static void Sxty()
        {
            string fwinput;
            NetworkStream ns1 = new NetworkStream(ServerSocket);
            StreamWriter sw1 = new StreamWriter(ns1);
            while (true)
            {
                fwinput = Console.ReadLine();
                if (fwinput == "exit")
                { ServerSocket.Close(); }
                sw1.WriteLine(fwinput);
                sw1.Flush();

            }
        }


        static void Main(string[] args)
        {
            Console.WriteLine("输入1将被动连接，输入2将主动连接：");
            int pd;
            pd = int.Parse(Console.ReadLine());
            if (pd == 1)
            {
                S5566();
            }
            else if (pd == 2)
            {
                KHIP();
            }
            else
            {
                return;
            }
            Thread t1 = new Thread(new ThreadStart(Sxty));
            t1.Start();

            Thread t2 = new Thread(new ThreadStart(Sdty));
            t2.Start();
        }
    }
}
