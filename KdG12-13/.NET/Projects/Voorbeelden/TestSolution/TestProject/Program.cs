using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TestProject
{
    class Program
    {
        static void Main(string[] args)
        {
            Publisher pub1 = new Publisher(21);
            Subscriber sub1 = new Subscriber("sub1", pub1);
            Subscriber sub2 = new Subscriber("sub2", pub1);

            pub1.OnEventName();

            Console.ReadLine();
        }
    }

    class Subscriber
    {
        public string Name { get; set; }

        public Subscriber(string name, Publisher pub)
        {
            this.Name = name;
            pub.eventName += sub_eventName;
        }

        //moet aan signatuur van eventhandler voldoen; vandaar object
        private void sub_eventName(object sender, EventArgs e)
        {
            Publisher pub = (Publisher) sender;
            Console.WriteLine("pub.id: {0} naam sub: {1}", pub.Id, this.Name);
        }
    }

    class Publisher
    {
        public int Id { get; set; }

        public Publisher(int id)
        {
            this.Id = id;
        }

        public event EventHandler eventName;

        public void OnEventName()
        {
            eventName(this, EventArgs.Empty);
        }
    }
}