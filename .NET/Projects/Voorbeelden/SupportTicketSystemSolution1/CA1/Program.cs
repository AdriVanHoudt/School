using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CA1
{
    class Program
    {
        static void Main(string[] args)
        {
            Ticket t1 = new Ticket(1, "First question?");
            Console.WriteLine(t1.ToString());

            Ticket t2 = new Ticket(2, "Second question?");
            Console.WriteLine(t2.ToString());

            Ticket t3 = new Ticket(3, "Third question?");
            Console.WriteLine(t3.ToString());

            Ticket t4 = new HarwareTicket(1, "COMP100", "Bluescreen");
            Console.WriteLine(t4.ToString());

            HarwareTicket t5 = new HarwareTicket(2, "COMP200", "Touchpad not working");
            Console.WriteLine(t5.ToString());

            t5.AddResponse("helpdesk response", false);
            System.Threading.Thread.Sleep(50000);
            t5.AddResponse("client response", true);
            t5.AddResponse("client new responses", true);

            Console.WriteLine(t5.GetResponseOverview());
            t5.CloseTicket();
            Console.WriteLine("State: {0}", t5.State);

            Console.ReadLine();
        }
    }
}