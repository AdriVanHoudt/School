using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.Inheritance
{
  class InheritanceProgram
  {
    static void Main(string[] args)
    {
      BaseClass bc = new BaseClass();
      bc.Method1(); //output: Base - Method1
      bc.Method2(); //output: Base - Method2

      DerivedClass dc = new DerivedClass();
      dc.Method1(); //output: Derived - Method1
      dc.Method2(); //output: Derived - Method2

      BaseClass bcdc = new DerivedClass(); // implicit upcasting
      bcdc.Method1(); //output: Derived - Method1 
      bcdc.Method2(); //output: Base - Method2

      Console.ReadLine(); // wait for <ENTER>
    }
  }

  class BaseClass
  {
    public virtual void Method1() { Console.WriteLine("Base - Method1"); }

    public void Method2() { Console.WriteLine("Base - Method2"); }
  }

  class DerivedClass : BaseClass
  {
    public sealed override void Method1() { Console.WriteLine("Derived - Method1"); }

    public new void Method2() { Console.WriteLine("Derived - Method2"); }
  }
}

