using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ADOPrak2WFA.POCO
{
    class Klant
    {
        public Int16 klant_id {set; get;}
        public string naam { set; get; }
        public string voornaam { set; get; }
        public string woonplaats { set; get; }
        public DateTime geboortedatum { set; get; }
        public string gebruikersnaam { set; get; }
        public string pwd { set; get; }
    }
}
