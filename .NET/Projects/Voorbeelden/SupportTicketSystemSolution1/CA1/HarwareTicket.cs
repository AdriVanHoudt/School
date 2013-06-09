using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CA1
{
    class HarwareTicket : Ticket
    {
        public String DeviceName { get; private set; }

        public HarwareTicket(int accountId, string deviceName, String problem) : base(accountId, problem)
        {
            this.DeviceName = deviceName;
        }

        public override string ToString()
        {
            return "Ticket no.: " + this.TicketId.ToString() + "\nDate: " + this.DateOpened.ToString() + "\nAccount no.: " + this.AccountId + "\nDevice name: " + this.DeviceName + "\nQuestion: " + this.Comment + "\nState: " + this.State + "\n";
        }
    }
}
