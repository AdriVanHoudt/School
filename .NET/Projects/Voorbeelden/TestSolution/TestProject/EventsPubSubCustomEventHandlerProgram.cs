using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.EventsPubSubCustomEventHandler
{
  // using custom event arguments for passing information from publisher to subscriber
  
  public class EventsPubSubCustomArgsProgram
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

  // create a event information class to pass information from publisher to subsciber
  public class MyEventInfo
  {
    public bool Completed { get; private set; }

    public MyEventInfo(bool completed)
    {
      Completed = completed;
    }
  }

  public class Publisher
  {
    // create delegate for the custom event handler (to attach the event handler methods to)
    public delegate void CustomEventHandler(MyEventInfo e);

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
      
      // raise the appropriate event with event information
      EventName(new MyEventInfo(completed));
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

    public void EventHandlerMethod(MyEventInfo e)
    {
      if (e.Completed) Console.WriteLine(id + ": " + "Completed");
      else Console.WriteLine(id + ": " + "Interrupted");
    }
  }
}
