using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.Events
{
  // using generic EventHandler and generic EventArgs
  // a event handler is a delegate-type
  // generic EventHandler signature: EventHandlerName(object, EventArgs)
  //  - first parameter: 'object'
  //  - second parameter: 'EventArgs' (or derived from it)
  // generic EventArgs: has no public properties or fields to store event information

  public class EventsProgram
  {
    static void Main(string[] args)
    {
      MyEventClass mec = new MyEventClass(); // instanciate object
      mec.EventName += new EventHandler(mec_EventName); // add event-handling method to event
      mec.OnEventName(); // invoke event method which in turn will raise the event

      Console.ReadLine(); // wait for <ENTER> to close console
    }

    // event-handling method will be created automaticly when creating statement on line 20
    static void mec_EventName(object sender, EventArgs e) { Console.WriteLine("Completed"); }
  }

  public class MyEventClass
  {
    public event EventHandler EventName;

    public void OnEventName()
    {
      // some implementation
      Console.WriteLine("Event started...");

      #region countdown 5 seconds
      int duration = 5; // in seconds
      int secondsCounter = 0;
      DateTime start = DateTime.Now;
      
      while (true)
      {
        TimeSpan time = DateTime.Now - start;
        int seconds = time.Seconds;
        if (seconds > secondsCounter) Console.WriteLine(duration - secondsCounter++);
        if (seconds > duration) break;
      }
      #endregion

      // raise the corresponding event (with no event information)
      EventName(this, EventArgs.Empty);
    }
  }
}

