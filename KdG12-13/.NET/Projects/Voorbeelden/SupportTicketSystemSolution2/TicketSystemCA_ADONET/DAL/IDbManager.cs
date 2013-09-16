using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using TicketSystem.POCO;

namespace TicketSystem.DAL
{
    interface IDbManager
    {
        List<Ticket> GetTickets();
        Ticket GetTicket(int ticketID);
        List<TicketResponse> GetTicketResponses(int ticketId);
    }
}
