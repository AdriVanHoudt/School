using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.ParameterModifiers
{
  class ParameterModifiersProgram
  {
    class MyClass
    {
      public bool Changed { get; set; }

      public MyClass(bool b) { Changed = b; }
    }

    static void Main(string[] args)
    {
      int i = 1;
      string s = "string";
      MyClass m = new MyClass(false);
      Method1(i, s, m);
      Console.WriteLine("i: {0}\ts: {1,-18}m: {2}", i, s, m.Changed);

      #region same for Method2
      i = 1;
      s = "string";
      m = new MyClass(false);
      Method2(i, s, m);
      Console.WriteLine("i: {0}\ts: {1,-18}m: {2}", i, s, m.Changed);
      #endregion

      #region same for Method1Ref
      i = 1;
      s = "string";
      m = new MyClass(false);
      Method1Ref(ref i, ref s, ref m);
      Console.WriteLine("i: {0}\ts: {1,-18}m: {2}", i, s, m.Changed); 
      #endregion

      #region same for Method2Ref
      i = 1;
      s = "string";
      m = new MyClass(false);
      Method2Ref(ref i, ref s, ref m);
      Console.WriteLine("i: {0}\ts: {1,-18}m: {2}", i, s, m.Changed); 
      #endregion

      Console.ReadLine();
    }

    static void Method1(int number, string text, MyClass myClass)
    {
      number = 10;
      text = "new string";
      myClass = new MyClass(true);
        //same
    }

    static void Method2(int number, string text, MyClass myClass)
    {
      number += 10;
      text += " changed";
      myClass.Changed = true;
        //true
    }

    static void Method1Ref(ref int number, ref string text, ref MyClass myClass)
    {
      number = 10;
      text = "new string";
      myClass = new MyClass(true);
        //i=10  
        //string = "new String"
        //true
    }

    static void Method2Ref(ref int number, ref string text, ref MyClass myClass)
    {
      number += 10;
      text += " changed";
      myClass.Changed = true;
        // 11
        // string changed
        // true
    }
  }
}
