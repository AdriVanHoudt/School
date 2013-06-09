using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.GenericsPerformance
{
  class GenericsPerformanceProgram
  {
    static void Main(string[] args)
    {
      LinkedList<int> list = new LinkedList<int>();
      
      int i = 1;
      while (i <= 100000)
      {
        list.AddLast(i);
        i++;
      }

      System.Diagnostics.Stopwatch timer = new System.Diagnostics.Stopwatch();
      Console.WriteLine("Measurements in ticks");
      int loopsCounter;

      #region foreach
        loopsCounter = 0;
        timer.Restart();
        foreach (int j in list)
        {
          loopsCounter++;
          int x = j;
        }
        timer.Stop();
        Console.WriteLine("{0,-8}: {1,8} (items count: {2})", "foreach", timer.ElapsedTicks, loopsCounter);
      #endregion

      #region nodes
        loopsCounter = 0;
        timer.Restart();
        LinkedListNode<int> node = list.First;
        while (node != null)
        {
          loopsCounter++;
          int y = node.Value;
          node = node.Next;
        }
        timer.Stop();
        Console.WriteLine("{0,-8}: {1,8} (items count: {2})", "nodes", timer.ElapsedTicks, loopsCounter);
      #endregion
      
      Console.ReadLine();
    }
  }
}
