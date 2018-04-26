using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace test
{
    class Program
    {
        static void Main(string[] args)
        {
           // Console.WriteLine("this is a test");
            ThreadStart ts = new ThreadStart      (()=>{ });
            AsyncCallback back=new AsyncCallback((a)=>{
                while (true)
                {
                    //Console.Clear();
                    Console.WriteLine("this is test {0}",DateTime.Now);
                   
                    Thread.Sleep(3000);
                }
            });
            ts.BeginInvoke(back, null);
          
            
            Thread th = new Thread(ts);
            th.IsBackground = true;
            th.Start();
            //ThreadStart tsw = new ThreadStart(delegate() {
            //    while (true)
            //    {
            //        string input = Console.ReadLine();
            //        Console.WriteLine(input);
            //    }
            //});
            //AsyncCallback asc=new AsyncCallback((a)=> {
            //    while (true)
            //    {
            //        string input = Console.ReadLine();
            //        Console.WriteLine(input);
            //    }
            //});
            //tsw.BeginInvoke(asc, null);
            //Thread thw = new Thread(tsw);
            //thw.IsBackground = true;
            //thw.Start();
           


            Console.WriteLine("this is a test now");
            //string s;
            //do
            //{
            //     s = Console.ReadLine();
            //} while (!s.Equals("foolish"));

            //char[] arr = new char[20];
            //int num = 0;
            //while (true)
            //{
            //    //ttribute[]
            //    arr[num++] = Console.ReadKey().KeyChar;
            //    if (num==20)
            //    {
            //        break;
            //    }
            //}

            //for (int i = 0; i < arr.Length; i++)
            //{
            //    Console.Write(arr[i]);
            //    //Console.WriteLine();
            //}
            //Console.WriteLine();
            //Console.ReadLine();
//            this is test 2016/10/5 18:40:04
//sthis is test 2016/10/5 18:40:07
//sddsthis is test 2016/10/5 18:40:10
//ddsdsadadadsthis is test 2016/10/5 18:40:13
//da

        }
    }
}
