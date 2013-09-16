using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.Delegates
{
  class DelegatesProgram
  {
    public delegate int MyDel(int i);
    public delegate void PrintDelegate(string s);
    
    static void Main(string[] args)
    {
      // MyDel example
      MyDel delInt = new MyDel(SecondPowerOf);
      int i = delInt(2);
      Console.WriteLine(i);

      delInt = ThirdPowerOf;   // shorter syntax
      i = delInt(2);
      Console.WriteLine(i);

      Console.WriteLine();

      // PrintDelegate example
      PrintDelegate print = FirstPrint;
      print += SecondPrint;
      print += ThirdPrint;

      print("string literal");
      
      Console.ReadLine();  // wait for <ENTER>
    }

    static int SecondPowerOf(int number) { return number * number; }

    static int ThirdPowerOf(int number) { return number * number * number; }
    
    static void FirstPrint(string text) { Console.WriteLine("first: {0}", text); }

    static void SecondPrint(string text) { Console.WriteLine("second: {0}", text); }

    static void ThirdPrint(string text) { Console.WriteLine("third: {0}", text); }
  }
}
