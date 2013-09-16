using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.AnonymousFunctions
{
  class AnonymousFunctionsProgram
  {
      delegate void TestDelegate(string s);
      
      static void M(string s)
      {
          Console.WriteLine(s);
      }

      static void Main(string[] args)
      {
          // Original delegate syntax required 
          // initialization with a named method.
          TestDelegate testDelA = new TestDelegate(M);

          // C# 2.0: A delegate can be initialized with
          // inline code, called an "anonymous method." This
          // method takes a string as an input parameter.
          TestDelegate testDelB = delegate(string s) { Console.WriteLine(s); };

          // C# 3.0. A delegate can be initialized with
          // a lambda expression. The lambda also takes a string
          // as an input parameter (x). The type of x is inferred by the compiler.
          TestDelegate testDelC = (x) => { Console.WriteLine(x); };

          // Invoke the delegates.
          testDelA("Hello. My name is M and I write lines.");
          testDelB("That's nothing. I'm anonymous and ");
          testDelC("I'm a famous author.");

          // Initialize delegate with named method, anonymous method and lamba expression.
          TestDelegate testDel = new TestDelegate(M);
          testDel += delegate(string s) { Console.WriteLine(s); };
          testDel += (x) => { Console.WriteLine(x); };

          // Invoke the delegate.
          testDel("Delegate with multiple initialisations.");

          Console.ReadLine(); //wait for <ENTER>
      }
  }
}

