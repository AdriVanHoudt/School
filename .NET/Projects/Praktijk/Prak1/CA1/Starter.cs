using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Praks.Prak1.CA1
{
    class Starter
    {
        static void Main(string[] args)
        {
            //Console.WriteLine("Huidige tijd: {0}", DateTime.Now);
            //Console.Write("Geboortedatum: ");
            //DateTime date = DateTime.Parse(Console.ReadLine());

            DateTime date;
            do{
                Console.WriteLine("Huidige tijd: {0}", DateTime.Now);
                Console.Write("Geboortedatum: ");
            } while (DateTime.TryParse(Console.ReadLine(), out date) == false);

            TimeSpan t = DateTime.Now - date;
            Console.WriteLine("Leeftijd: {0}",Convert.ToInt16(Math.Floor(t.TotalDays/365.25)));

            Console.ReadLine();
        }
    }
}