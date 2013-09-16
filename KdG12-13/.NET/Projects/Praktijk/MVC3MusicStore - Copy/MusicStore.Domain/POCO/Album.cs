﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Web.Mvc;

namespace MusicStore.Domain.POCO
{
    public class Album
    {
        [ScaffoldColumn(false)]
        public int AlbumId { get; set; }
        
        [Required(ErrorMessage = "An Album Title is required")]
        [StringLength(160)]
        public string Title { get; set; }
        
        [Required(ErrorMessage = "Price is required")]
        [Range(0.01, 100.00, ErrorMessage= "Price must be between 0.01 and 100.00")]
        public decimal Price { get; set; }
        
        [DisplayName("Album Art Url")]
        [StringLength(1024)]
        public string AlbumArtUrl { get; set; }
       
        [DisplayName("Artist")]
        public int ArtistId { get; set; }
        public virtual Artist Artist { get; set; }
        
        [DisplayName("Genre")]
        public int GenreId { get; set; }
        public virtual Genre Genre { get; set; } //Property mag normaal niet naam van klasse hebben      
    }
}
