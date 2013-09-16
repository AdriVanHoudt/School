using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MusicStore.Domain.POCO
{
    //Opgelet! Naar public veranderen. Standaard = internal
    public class Genre
    {
        public int GenreId { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }

        public virtual List<Album> Albums { get; set; } // virtual --> gebruik maken van lazy loading (enkel hetgeen we nodig hebben)
    }
}
