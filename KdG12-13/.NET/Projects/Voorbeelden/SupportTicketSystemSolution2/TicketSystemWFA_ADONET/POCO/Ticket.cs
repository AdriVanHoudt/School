using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TicketSystem.POCO
{
  public class Ticket
  {
    public int TicketNumber { get; set; }
    public int AccountId { get; set; }
    public string Comment { get; set; }
    public DateTime DateOpened { get; set; }
    public TicketState State { get; set; }
    public List<TicketResponse> Responses { get; set; }

    public Ticket()
    {
    }
    public Ticket(int id, int accountId, string question)
    {
      TicketNumber = id;
      AccountId = accountId;
      Comment = question;
      DateOpened = DateTime.Now;
      State = TicketState.Open;
      Responses = new List<TicketResponse>();
    }

    public new string ToString()
    {
      return "Ticket no.: " + TicketNumber.ToString()
        + "\nDate: " + DateOpened.ToString()
        + "\nAccount no.: " + AccountId
        + "\nQuestion: " + Comment
        + "\nState: " + State + "\n";
    }

    public void CloseTicket()
    {
      State = TicketState.Closed;
    }

    public void AddResponse(string response, bool isClientResponse)
    {
      Responses.Add(new TicketResponse(response, isClientResponse));
      if (isClientResponse) State = TicketState.ClientAnswer;
      else State = TicketState.Answered;
    }

    public string GetResponseOverview()
    {
      StringBuilder overview = new StringBuilder();
      foreach (TicketResponse response in Responses)
      {
        overview.AppendLine(response.ToString());
      }
      return overview.ToString();
    }
  }
}

