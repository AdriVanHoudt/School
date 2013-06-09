using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject.EventsPubSub
{
  public class EventsPubSubProgram
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

  public class Publisher
  {
    public event EventHandler EventName;

    public void OnEventName()
    {
      //some implementation
      Console.WriteLine("Event started...");

      DateTime start = DateTime.Now;
      while (true)
      {
        TimeSpan time = DateTime.Now - start;
        if (time.Seconds > 5) break;
      }
      
      // call the appropriate event delegate
      EventName(this, EventArgs.Empty);
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

    public void EventHandlerMethod(object sender, EventArgs e)
    {
      Console.WriteLine(id + ": " + "Completed");
    }
  }
}
