using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.EventsPubSubCustomEventArgs
{
  // using custom event arguments for passing information from publisher to subscriber
  
  public class EventsPubSubCustomEventArgsProgram
  {
    static void Main(string[] args)
    {
      Publisher pub = new Publisher();
      
      Subsciber sub1 = new Subsciber("sub1", pub);
      Subsciber sub2 = new Subsciber("sub2", pub);

      pub.OnEventName();

      Console.ReadLine(); // wait for <ENTER> to close console
    }
  }

  // create a custom event arguments class
  public class CustomEventArgs : EventArgs
  {
    public bool Completed { get; private set; }

    public CustomEventArgs(bool completed)
    {
      Completed = completed;
    }
  }

  public class Publisher
  {
    public delegate void CustomEventHandler(object sender, CustomEventArgs e);

    public event CustomEventHandler EventName;

    public void OnEventName()
    {
      //some implementation
      Console.WriteLine("Event started...");
      bool completed = true;

      DateTime start = DateTime.Now;
      Console.WriteLine("Press 'ESC' to interrupt...");
      while (true)
      {
        TimeSpan time = DateTime.Now - start;
        if (time.Seconds > 5) break;
        else if (Console.KeyAvailable)
        {
          ConsoleKeyInfo keyInfo = Console.ReadKey();
          if (keyInfo.Key == ConsoleKey.Escape)
          {
            completed = false;
            break;
          }
        }
      }
      
      // raise the appropriate event with custom event arguments
      EventName(this, new CustomEventArgs(completed));
    }
  }

  public class Subsciber
  {
    private string id;

    public Subsciber(string Id, Publisher publisher)
    {
      id = Id;
      publisher.EventName += EventHandlerMethod;
    }

    public void EventHandlerMethod(object sender, CustomEventArgs e)
    {
      if (e.Completed) Console.WriteLine(id + ": " + "Completed");
      else Console.WriteLine(id + ": " + "Interrupted");
    }
  }
}
