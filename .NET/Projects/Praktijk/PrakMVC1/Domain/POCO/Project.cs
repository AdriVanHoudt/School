using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel.DataAnnotations;

namespace Domain.POCO
{
    public class Project
    {
        public int ProjectId { get; set; }
        [Required]
        [StringLength(25)]
        public string Naam { get; set; }
        [StringLength(100)]
        public string Omschrijving { get; set; }

        public int ContextId { get; set; }
        public virtual Context Context{ get; set; }
        
        public virtual List<Taak> Taken{ get; set; }
    }
}
