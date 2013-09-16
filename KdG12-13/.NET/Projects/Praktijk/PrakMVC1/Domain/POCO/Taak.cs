using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel.DataAnnotations;

namespace Domain.POCO
{
    public class Taak
    {
        public int TaakId { get; set; }
        [Required]
        [StringLength(25)]
        public string Naam { get; set; }
        [StringLength(100)]
        public string Omschrijving { get; set; }
        public DateTime? IngeplandVanaf { get; set; }
        public DateTime? IngeplandTot { get; set; }
         [Required]
        public short Status{ get; set; }

        public int ProjectId { get; set; }
        public virtual Project Project { get; set; }


        public int PrioriteitId { get; set; }
         [Required]
        public virtual Prioriteit Prioriteit { get; set; }
    }
}
