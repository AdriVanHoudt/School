using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Domain.POCO;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace Domain.DB
{
    public class GTDbContext : DbContext
    {
        public DbSet<Prioriteit> Prioriteiten { get; set; }
        public DbSet<Project> Projecten { get; set; }
       
        public DbSet<Taak> Taken { get; set; }
        public DbSet<Context> Contexten { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }

    }
}
