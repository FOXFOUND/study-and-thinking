using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleApplication2
{
    class Program
    {
        static void Main(string[] args)
        {

            char[] temp = new char[20];
            bool iswrite = false;
            int numnow = 0;
            Thread th = new Thread(new ThreadStart(() => {
                while (true)
                {
                    if (iswrite)
                    {
                        //for (int i = 0; i < numnow; i++)
                        //{
                        //  // ConsoleKey.Backspace;  
                        //    //Console.Write( ConsoleKey.Backspace);
                        //    Console.Write('\u0008');
                        //}
                       // Thread.Sleep(3000);
                       // Console.WriteLine("this is test {0}", DateTime.Now);
                        for (int i = 0; i < numnow; i++)
                        {
                            Console.Write(temp[i]);
                        }
                        //Console.WriteLine();
                    }
                    
                        Thread.Sleep(3000);
                        Console.WriteLine();
                        Console.WriteLine("this is test {0}", DateTime.Now);
                    
                    
                }
            }));
            th.IsBackground = true;
            th.Start();

            while (true)
            {
                temp[numnow++]=Console.ReadKey().KeyChar;
                iswrite = true;
                if (numnow==20)
                {
                    Console.WriteLine();
                    for (int i = 0; i < temp.Length; i++)
                    {
                        Console.Write(temp[i]);
                    }
                    Console.WriteLine();
                    temp = new char[20];
                    numnow = 0;
                    iswrite = false;
                }

            }
        }
    }
}
