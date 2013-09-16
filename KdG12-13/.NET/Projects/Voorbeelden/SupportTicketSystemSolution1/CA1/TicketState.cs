using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CA1
{
    enum TicketState : byte 
    {
        Open = 1,
        Answered,
        ClientAnswer,
        Closed
        //waarde word automatisch verhoogd met 1 e.g. closed = 4
    }
}
