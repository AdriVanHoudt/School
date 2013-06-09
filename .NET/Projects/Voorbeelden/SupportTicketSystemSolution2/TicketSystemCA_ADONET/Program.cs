using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using System.Data;
using TicketSystem.DAL;
using TicketSystem.POCO;
using System.Data.OleDb;

namespace TicketSystem.CA
{
  class Program
  {
    static void Main(string[] args)
    {
        OleDbManager manager = new OleDbManager();

        List<Ticket> tickets = manager.GetTickets();

        foreach (Ticket ticket in tickets)
        {
            List<TicketResponse> responses = manager.GetTicketResponses(ticket.TicketNumber);
            ticket.Responses = responses;

            Console.Write(ticket.ToString());
            Console.WriteLine(ticket.GetResponseOverview());
        }
        Console.WriteLine("--------------------------------------------------------------------------------");

        SqlClientManager sqlmanager = new SqlClientManager();

        List<Ticket> sqltickets = sqlmanager.GetTickets();

        foreach (Ticket ticket in sqltickets)
        {
            List<TicketResponse> responses = sqlmanager.GetTicketResponses(ticket.TicketNumber);
            ticket.Responses = responses;

            Console.Write(ticket.ToString());
            Console.WriteLine(ticket.GetResponseOverview());
        }
        Console.ReadLine();
    }
  }
}

