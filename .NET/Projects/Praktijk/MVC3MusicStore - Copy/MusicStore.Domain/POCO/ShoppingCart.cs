using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel.DataAnnotations;

namespace MusicStore.Domain.POCO
{
    public class ShoppingCart
    {
        public int ShoppingCartId { get; set; }

        [Required]
        [StringLength(255)]
        public string User { get; set; }

        public List<CartItem> CartItems { get; set; }


    }
}