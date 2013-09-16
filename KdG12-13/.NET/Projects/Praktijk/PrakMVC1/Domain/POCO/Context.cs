using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel.DataAnnotations;

namespace Domain.POCO
{
    public class Context
    {
        public int ContextID { get; set; }
        [Required]
        [StringLength(25)]
        [RegularExpression("[a-zA-Z]")]
        public String Naam { get; set; }
        [StringLength(100)]
        public string Omschrijving { get; set; }

       
        public virtual List<Project> Projecten { get; set; }
    }
}
