using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.EventsCustomEventArgs
{
  // using generic EventHandler with non-generic EventArgs

  public class EventsCustomEventArgsProgram
  {
    static void Main(string[] args)
    {
      MyEventClass mec = new MyEventClass();
      mec.EventName += new EventHandler(mec_EventName);

      mec.OnEventName();

      Console.ReadLine(); // wait for <ENTER> to close console
    }

    // event-handling method will be created automaticly when creating statement on line 15
    static void mec_EventName(object sender, EventArgs e)
    {
      CustomEventArgs ce = e as CustomEventArgs;
      if (ce != null)
      {
        if (ce.Completed) Console.WriteLine("Completed");
        else Console.WriteLine("Interrupted");
      }
    }
  }

  // create custom event arguments class with members to hold event information
  public class CustomEventArgs : EventArgs
  {
    public bool Completed { get; private set; }

    public CustomEventArgs(bool completed)
    {
      Completed = completed;
    }
  }

  public class MyEventClass
  {
    public event EventHandler EventName;

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

      // raise the corresponding event with custom event info
      EventName(this, new CustomEventArgs(completed));
    }
  }
}
