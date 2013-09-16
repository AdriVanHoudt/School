using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


using System.Data;
using System.Data.OleDb;

using TicketSystem.POCO;

namespace TicketSystem.DAL
{
    public class OleDbManager: IDbManager
    {
        private OleDbConnection GetConnection()
        {
            OleDbConnection conn = new OleDbConnection();
            conn.ConnectionString = "Provider=Microsoft.ACE.OLEDB.12.0;"
                                    + "Data Source=|DataDirectory|TicketSystemDBx64.accdb;" 
                                    + "Persist Security Info=True";
            return conn;
        }

        public List<Ticket> GetTickets()
        {
            List<Ticket> tickets = new List<Ticket>();

            String sql = "SELECT Id, AccountId, DateOpened, State FROM tblTickets";

            using (OleDbConnection conn = this.GetConnection())
            {
                conn.Open();
                OleDbCommand sqlCmd = new OleDbCommand(sql, conn);


                using (OleDbDataReader reader = sqlCmd.ExecuteReader())
                {
                    if (reader.HasRows)
                    {
                        while (reader.Read())
                        {
                            int idColumnNumber = reader.GetOrdinal("Id");
                            int accIdColumnNumber = reader.GetOrdinal("AccountId");
                            int dateOpenedColumnnumber = reader.GetOrdinal("DateOpened");
                            int stateVolumnNumber = reader.GetOrdinal("State");

                            Ticket ticket = new Ticket();
                            ticket.TicketNumber = reader.GetInt32(idColumnNumber);
                            ticket.AccountId = reader.GetInt32(accIdColumnNumber);
                            ticket.DateOpened = reader.GetDateTime(dateOpenedColumnnumber);
                            ticket.State = (TicketState)reader.GetByte(stateVolumnNumber);

                            tickets.Add(ticket);
                        }
                    }
                    reader.Close();
                }
                conn.Close();
              }
              return tickets;
        }

        public Ticket GetTicket(int ticketId)
        {
            Ticket ticket = null;
            String sql = "SELECT Id, AccountId, Comment, DateOpened, State FROM tblTickets WHERE Id=@Id";

            using (OleDbConnection conn = this.GetConnection())
            {
                conn.Open();
                
                OleDbCommand sqlCmd = new OleDbCommand(sql, conn);
                OleDbParameter idParam = new OleDbParameter("@Id", ticketId);
                sqlCmd.Parameters.Add(idParam);

                using (OleDbDataReader reader = sqlCmd.ExecuteReader())
                {
                    if (reader.HasRows)
                    {
                        reader.Read();
                        ticket.TicketNumber = ticketId;
                        ticket.AccountId = reader.GetInt32(reader.GetOrdinal("AccountId"));
                        ticket.Comment = reader.GetString(reader.GetOrdinal("Comment"));
                        ticket.DateOpened = reader.GetDateTime(reader.GetOrdinal("DateOpened"));
                        ticket.State = (TicketState)reader.GetByte(reader.GetOrdinal("State"));
                    }
                    reader.Close();
                }
                conn.Close();
             return ticket;
            }
        }

        public List<TicketResponse> GetTicketResponses(int ticketId)
        {
            List<TicketResponse> responses = new List<TicketResponse>();
            using (OleDbConnection conn = this.GetConnection())
            {
                conn.Open();

                String sql = "SELECT Response, DateAnswered, IsClientResponse FROM tblTicketResponses WHERE TicketId = @Id";
                OleDbCommand sqlCmd = new OleDbCommand(sql, conn);
                OleDbParameter idParam = new OleDbParameter("@Id", ticketId);
                sqlCmd.Parameters.Add(idParam);

                using (OleDbDataReader reader = sqlCmd.ExecuteReader())
                {
                    if (reader.HasRows)
                    {
                        while (reader.Read())
                        {
                            TicketResponse response = new TicketResponse();
                            response.Date= reader.GetDateTime(reader.GetOrdinal("DateAnswered"));
                            response.IsClientResponse = reader.GetBoolean(reader.GetOrdinal("IsClientResponse"));
                            response.Text = reader.GetString(reader.GetOrdinal("Response"));
                            responses.Add(response);
                        }
                    }
                    reader.Close();
                }
                conn.Close();
              }
              return responses;
            }

        }

    }