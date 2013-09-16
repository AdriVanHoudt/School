using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.Structs
{
  public class StructsProgram
  {
    static void Main(string[] args)
    {
      MyStruct struct1 = new MyStruct();
      Console.WriteLine("struct1: {0}\t{1}", struct1.I, ((struct1.MyClass1 == null) ? "null" : struct1.MyClass1.S));

      struct1.MyClass1 = new MyClass();
      Console.WriteLine("struct1: {0}\t{1}", struct1.I, ((struct1.MyClass1 == null) ? "null" : struct1.MyClass1.S));

      MyStruct struct2 = struct1;
      struct2.I = 20;
      struct2.MyClass1.S = "other literal";

      Console.WriteLine("struct1: {0}\t{1}", struct1.I, ((struct1.MyClass1 == null) ? "null" : struct1.MyClass1.S));
      Console.WriteLine("struct2: {0}\t{1}", struct2.I, ((struct2.MyClass1 == null) ? "null" : struct2.MyClass1.S));
          
      Console.ReadLine(); // wait for <ENTER>
    }
  }

  public struct MyStruct
  {
    public int I;
    public MyClass MyClass1;
  }

  public class MyClass
  {
    private string s;

    public string S
    {
      get { return s; }
      set { s = value; }
    }

    public MyClass()
    {
      s = "default literal";
    }

    public MyClass(string str)
    {
      s = str;
    }

  }
}
