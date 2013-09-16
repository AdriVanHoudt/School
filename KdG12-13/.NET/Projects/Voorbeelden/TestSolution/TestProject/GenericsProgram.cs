using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.Generics
{
  class GenericsProgram
  {
    static void Main(string[] args)
    {
      List<string> list = new List<string>();
      list.Add("first");
      list.Add("middle");
      list.Add("last");
      string item = list.Find(s => s == "middle");
      Console.WriteLine("List: "+item);
      
      Dictionary<string, int> d = new Dictionary<string, int>();
      d.Add("first", 100);
      d.Add("middle", 200);
      d.Add("last", 300);
      string key = "middle";
      int value;
      bool hasValue = d.TryGetValue(key, out value);
      if (hasValue) Console.WriteLine("Dictionary: "+key+" > "+value);

      Stack<string> stack = new Stack<string>();
      stack.Push("first");
      stack.Push("middle");
      stack.Push("last");
      Console.WriteLine("Stack: " + stack.Pop());
      
      Queue<string> queue = new Queue<string>();
      queue.Enqueue("first");
      queue.Enqueue("middle");
      queue.Enqueue("last");
      Console.WriteLine("Queue: "+queue.Dequeue());
      
      LinkedList<string> linked = new LinkedList<string>();
      linked.AddLast("last");
      linked.AddFirst("first");
      var linkedNode = linked.Find("last"); //of type LinkedListNode<T>
      linked.AddBefore(linkedNode, "middle");
      Console.Write("LinkedList: ");
      foreach (string str in  linked)
      {
        Console.Write(str+" ");
      }
      Console.Write(Environment.NewLine);
      
      Console.ReadLine(); // wait for <ENTER>
    }
  }
}
