using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TicketSystem.POCO
{
  public class TicketResponse
  {
    public string Text { get; set; }
    public DateTime Date { get; set; }
    public bool IsClientResponse { get; set; }

    public TicketResponse()
    {
    }
    public TicketResponse(string response, bool isClientResponse)
    {
      Text = response;
      Date = DateTime.Now;
      IsClientResponse = isClientResponse;
    }

    public new string ToString()
    {
      return String.Format("{0} ({1}) {2}", Date, IsClientResponse ? "client" : "helpdesk", Text);
    }
  }
}

