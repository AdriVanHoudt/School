using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CA1
{
    class TicketId
    {
        private static int Year;
        private static int Count;

        private int year;
        private int number;

        public TicketId()
        {
            if (TicketId.Year != DateTime.Today.Year)
            {
                TicketId.Year = DateTime.Today.Year;
                TicketId.Count = 0;
            }
            year = TicketId.Year;
            number = ++TicketId.Count;
        }

        public new string ToString()
        {
            return year + "/" + String.Format("{0:d4}", number);
        }
    }
}
