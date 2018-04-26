using System;
using System.IO;
using System.Text;

class Program
{
    static  void run(string[] args)
    {
        FileStream fswrite = new FileStream(@"new.txt", FileMode.Create, FileAccess.Write);
        string input = "this is a test ,successful";
        byte[] buffer = Encoding.Default.GetBytes(input);
        fswrite.Write(buffer, 0, buffer.Length);
        fswrite.Dispose();
    }
}
    //public class myclass
    //{
    //   // [autorun]
    //    public  void ma()
    //    {
    //        FileStream fswrite = new FileStream(@"new.txt", FileMode.Create, FileAccess.Write);
    //        string input="this is a test ,successful";
    //        byte [] buffer=Encoding.Default.GetBytes(input);
    //        fswrite.Write(buffer,0,buffer.Length);
    //        fswrite.Dispose();
    //    }
    //}
