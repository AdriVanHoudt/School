using System.Collections.Generic;
using MusicStore.Domain.POCO;

namespace MusicStore.WebUI.ViewModels
{
    public class ShoppingCartViewModel
    {
        public List<CartItem> CartItems { get; set; }
        public decimal CartTotal { get; set; }
    }
}