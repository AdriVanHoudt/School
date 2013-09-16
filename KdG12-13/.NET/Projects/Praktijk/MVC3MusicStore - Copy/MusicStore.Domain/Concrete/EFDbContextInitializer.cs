using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using System.Data.Entity;
using MusicStore.Domain.POCO;

namespace MusicStore.Domain.Concrete
{
    public class EFDbContextInitializer : DropCreateDatabaseIfModelChanges<EFDbContext> //normaal ifmodelchanges
    {
        protected override void Seed(EFDbContext context)
        {
            //create artists
            Artist artist1 = new Artist { Name = "AC/DC" };
            context.Artists.Add(artist1);
            Artist artist2 = new Artist { Name = "Iron Maiden" };
            context.Artists.Add(artist2);
            context.SaveChanges();

            //Create genres
            Genre genre1 = new Genre { Name = "Rock" };
            context.Genres.Add(genre1);
            context.SaveChanges();

            //Add Album
            Artist acdc = context.Artists.First<Artist>(a => a.Name == "AC/DC");
            Genre rock = context.Genres.First<Genre>(g => g.Name == "Rock");
            Album album1 = new Album { Title = "For Those About To Rock We Salute You", Price = (decimal)8.99, Artist = acdc, Genre = rock };
            context.Albums.Add(album1);

            Artist IronMaiden = context.Artists.First<Artist>(a => a.Name =="Iron Maiden");
            Album album2 = new Album { Title = "Flight 666", Price = (decimal)8.99, Artist = IronMaiden, Genre = rock };
            context.Albums.Add(album2);

            Album album3 = new Album { Title = "Hell Bells", Price = (decimal)10.05, Artist = acdc, Genre = rock };
            context.Albums.Add(album3);

            context.SaveChanges();

        }
    }
}
