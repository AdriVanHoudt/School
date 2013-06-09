using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MusicStore.Domain.POCO
{
  public class CartItem
  {
    [System.ComponentModel.DataAnnotations.Key]
    public int RecordId { get; set; }    
    public int AlbumId { get; set; }
    public int ShoppingCartId { get; set; }
    public int Quantity { get; set; }
    public DateTime DateCreated { get; set; }

    public virtual Album Album { get; set; }
    public virtual ShoppingCart ShoppingCart { get; set; }

  }
}
