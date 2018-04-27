using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace encode
{
    class Program
    {
        static void Main(string[] args)
        {
            //string str = System.Text.Encoding.UTF8.GetString("\xe5\x8f\x91\xe7\x94\x9f\xe9\x94\x99\xe8\xaf\xaf\xef\xbc\x8c\xe8\xaf\xb7\xe9\x87\x8d\xe8\xaf\x95".ToArray().Select(t => Convert.ToByte(t)).ToArray());
            string str = System.Text.Encoding.UTF8.GetString("\x90\x90\x90\x83\xec\x28\xeb".ToArray().Select(t => Convert.ToByte(t)).ToArray());
            //Console.WriteLine("\x90\x90\x90\x83\xec\x28\xeb\x0b\xe8\xe2\xa8\xd6\x77\x50\xe8\xc1\x90\xd6\x77\x33\xc0\x50\xe8\xed\xff\xff\xff");
            Console.WriteLine(str);
            str = System.Text.Encoding.Unicode.GetString("\x90\x90\x90\x83\xec\x28\xeb".ToArray().Select(t => Convert.ToByte(t)).ToArray());
            Console.WriteLine(str);
            str = System.Text.Encoding.BigEndianUnicode.GetString("\x90\x90\x90\x83\xec\x28\xeb\x0b\xe8\xe2\xa8\xd6\x77\x50\xe8\xc1\x90\xd6\x77\x33\xc0\x50\xe8\xed\xff\xff\xff".ToArray().Select(t => Convert.ToByte(t)).ToArray());
            Console.WriteLine(str);
            str = System.Text.Encoding.ASCII.GetString("\x90\x90\x90\x83\xec\x28\xeb".ToArray().Select(t => Convert.ToByte(t)).ToArray());
            Console.WriteLine(str);
            Console.WriteLine("\xe5\x8f\x91\xe7\x94\x9f\xe9\x94\x99\xe8\xaf\xaf\xef\xbc\x8c\xe8\xaf\xb7\xe9\x87\x8d\xe8\xaf\x95");
           // Console.ReadLine();

            string s = "hello admin";
            byte [] b= System.Text.Encoding.UTF8.GetBytes(s);
            for (int i = 0; i < b.Length; i++)
            {
                Console.WriteLine(b[i].ToString("x"));
            }


            Console.WriteLine("~~~~~~~~~~~~~~~~");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.Length; i++)
            {
                sb.Append("\\x" + b[i].ToString("x"));
            }
           string temp = sb.ToString();
           // string temp=
            temp = "\x68\x65\x6c\x6c\x6f\x20\x61\x64\x6d\x69\x6e";
            //Console.WriteLine(temp);

            //byte t1 = byte.Parse("\x68");
            //Console.WriteLine("@@@@@@@@@@@@@@@@@@@");
            //Console.WriteLine(t1);
           
            Console.WriteLine("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            //byte[] bytetemp = temp.ToArray().Select(t => Convert.ToByte(t)).ToArray();
            byte[] bytetemp = Encoding.UTF8.GetBytes(temp);
            string snew = System.Text.Encoding.UTF8.GetString(bytetemp);

            
            Console.WriteLine(snew);

            Console.WriteLine();
            Console.WriteLine("\x68\x65\x6c\x6c\x6f\x20\x61\x64\x6d\x69\x6e");
            Console.ReadKey();
        }
    }
}
