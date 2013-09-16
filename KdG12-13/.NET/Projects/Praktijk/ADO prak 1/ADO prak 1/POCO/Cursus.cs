using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ADO_prak_1.POCO
{
    class Cursus
    {
        public int CursusNr{get; set ;}
        public String CursusNaam { get; set; }
        public double CursusPrijs { get; set; }

        public string toString()
        {
            return String.Format("{0} ({1})", CursusNaam, CursusNr);
        }
    }
}
