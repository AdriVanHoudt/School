using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CA1
{
    class TicketResponse
    {
        private string text;
        private DateTime date;
        private bool IsCLientResponse;

        public TicketResponse(string response, bool isClientResponse)
        {
            this.text = response;
            this.date = DateTime.Now;
            this.IsCLientResponse = isClientResponse;
        }

        public new string ToString()
        {
            return String.Format("{0} ({1}) {2} \n", this.date, this.IsCLientResponse ? "Client" : "Helpdesk", text);
        }
    }
}
