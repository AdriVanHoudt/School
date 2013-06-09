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
            Book b1 = new Book("C# Language", "KdG", "C# is one of the programming languages designed for the Common Language Infrastructure.");

            Console.WriteLine("Book: {0}", b1.ToString());

            while (true)
            {
                //vraag pagina
                Console.Write("Page: ");
                String input = Console.ReadLine();

                if (input != "exit")
                {
                    //toon pagina
                    Console.WriteLine(b1.GetPage((ushort.Parse(input))));
                }
                else
                {
                    break;
                }
            }


        }
    }
}