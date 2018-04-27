using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            ThreadStart ts = new ThreadStart(() => { });
            AsyncCallback back = new AsyncCallback((a) =>
            {
                while (true)
                {
                    //Console.Clear();
                    Console.WriteLine("this is test {0}", DateTime.Now);

                    Thread.Sleep(3000);
                }
            });
            ts.BeginInvoke(back, null);


            Thread th = new Thread(ts);
            th.IsBackground = true;
            th.Start();

            ThreadStart tsw = new ThreadStart(() => { });
            AsyncCallback wback = new AsyncCallback((a) => {
                string input = Console.ReadLine();
               // Console.Read();
                Console.WriteLine(input);
            });
            tsw.BeginInvoke(wback, null);
            Thread thw = new Thread(tsw);
            thw.IsBackground = true;
            thw.Start();

            while (true)
            {
                
            }
        }
    }
}
