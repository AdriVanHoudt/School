using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using TicketSystem.POCO;
using System.Data;

namespace TicketSystem.DAL
{
    public interface IDbManager
    {
        DataSet GetTicketsDataSet();
        void UpdateTicketsDataSet(DataSet dsTickets);

        List<Ticket> GetTickets();
        Ticket GetTicket(int ticketID);
        List<TicketResponse> GetTicketResponses(int ticketId);
    }
}
