using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.EventsCustomEventHandler
{
  // using non-generic EventHandler with non-generic EventArgs

  public class EventsCustomEventHandlerProgram
  {
    static void Main(string[] args)
    {
      MyEventClass mec = new MyEventClass();
      mec.EventName += new MyEventClass.CustomEventHandler(mec_EventName);

      mec.OnEventName();

      Console.ReadLine(); // wait for <ENTER> to close console
    }

    static void mec_EventName(MyEventInfo e)
    {
      if (e.Completed) Console.WriteLine("Completed");
      else Console.WriteLine("Interrupted");
    }
  }

  public class MyEventInfo
  {
    public bool Completed { get; private set; }

    public MyEventInfo(bool completed)
    {
      Completed = completed;
    }
  }

  public class MyEventClass
  {
    // create custom event handler delegate with custom parameters
    public delegate void CustomEventHandler(MyEventInfo e);
    
    public event CustomEventHandler EventName;

    public void OnEventName()
    {
      //some implementation
      Console.WriteLine("Event started...");

      // countdown 5 seconds, but interruptable with 'ESC'
      int duration = 5; // in seconds
      int secondsCounter = 0;
      DateTime start = DateTime.Now;

      bool completed = true;
      Console.WriteLine("Press 'ESC' to interrupt...");

      while (true)
      {
        TimeSpan time = DateTime.Now - start;
        if (time.Seconds > secondsCounter) Console.WriteLine(duration - secondsCounter++);
        if (time.Seconds > duration) break;
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

      // raise the corresponding event with custom event handler and custom event info
      EventName(new MyEventInfo(completed));
    }
  }
}
