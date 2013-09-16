using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CA1
{
    class Ticket : ITicket
    {
        #region properties
        public TicketId TicketId{get;private set;}
        public int AccountId { get; private set; }
        public String Comment { get; private set; }
        public DateTime DateOpened { get; private set; }
        public TicketState State { get; set; }
        #endregion

        private LinkedList<TicketResponse> Responses;

        #region constructor
        public Ticket(int accountId, String question)
        {
            this.TicketId = new TicketId();
            this.AccountId = accountId;
            this.Comment = question;
            this.DateOpened = DateTime.Now;
            this.State = TicketState.Open;
            this.Responses = new LinkedList<TicketResponse>();
        }
        #endregion


        #region methods
        public virtual new string ToString()
        {
            return "Ticket no.: " + this.TicketId.ToString() + "\nDate: " + this.DateOpened.ToString() + "\nAccount no.: " + this.AccountId + "\nQuestion: " + this.Comment + "\nState: " + this.State + "\n";
        }

        public void AddResponse(string response, bool isClientResponse)
        {
            this.Responses.AddLast(new TicketResponse(response, isClientResponse));
            if (isClientResponse) this.State = TicketState.ClientAnswer;
            else this.State = TicketState.Answered;
        }

        public void CloseTicket()
        {
            this.State = TicketState.Closed;
        }

        public string GetResponseOverview()
        {
            string overview = "";
            foreach (TicketResponse i in this.Responses)
            {
                overview += i.ToString();
            }
            return overview;
        }
        #endregion
    }
}
