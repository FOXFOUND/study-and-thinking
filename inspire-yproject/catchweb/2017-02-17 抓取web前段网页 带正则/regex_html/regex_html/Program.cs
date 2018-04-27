using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace regex_html
{
    class Program
    {
        static void Main(string[] args)
        {
            WebClient wb = new WebClient();
            wb.Encoding = Encoding.UTF8;
            FileStream fs = new FileStream("1.html", FileMode.Open, FileAccess.Read);
            StringBuilder sb = new StringBuilder();
            byte[] buffer = new byte[1024 * 5];
            int res = 0;
            while ((res=fs.Read(buffer,0,buffer.Length))!=0)
            {
               
                sb.Append(Encoding.UTF8.GetString(buffer, 0, res));
            }
           // Console.WriteLine(sb.ToString());
            string resstr = sb.ToString();
            string regex = @"http://.*.html";
           MatchCollection mc= Regex.Matches(resstr, regex);
           string[] reshtml = new string[mc.Count];
           //foreach (Match item in mc)
           //{

           //    Console.WriteLine(item.Value);
           //}
           regex = @"\/([a-zA-Z-0-9]+)";
           for (int i = 0; i < reshtml.Length; i++)
           {
               reshtml[i] = mc[i].Value;
               Console.WriteLine(reshtml[i]);
               MatchCollection mco =Regex.Matches(reshtml[i], regex);
               Console.WriteLine(mco[mco.Count-1].Groups[1].Value);
               try
               {
                   wb.DownloadFile(reshtml[i], "temp");
                   //File fr = File.Open("temp", FileMode.Open);
                   File.Move("temp", mco[mco.Count - 1].Groups[1].Value + ".html");

               }
               catch (Exception)
               {
                   continue;
                   //throw;
               }
               
              
           }
           



        }
    }
}
