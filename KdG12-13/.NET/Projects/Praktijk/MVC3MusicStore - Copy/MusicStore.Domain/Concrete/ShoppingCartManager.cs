using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using MusicStore.Domain.POCO;

namespace MusicStore.Domain.Concrete
{
  public class ShoppingCartManager
  {
    private EFDbContext db;


    public ShoppingCartManager()
    {
      db = new EFDbContext();
    }

    public void AddToCart(int albumIdToAdd, string userName)
    {
      // Get the matching cart and album instances
      ShoppingCart shoppingCartOnWhichTheAlbumNeedsToBeAdded = GetShoppingCartWithCartItems(userName);

      if (shoppingCartOnWhichTheAlbumNeedsToBeAdded == null)
      {
        shoppingCartOnWhichTheAlbumNeedsToBeAdded = new ShoppingCart();
        shoppingCartOnWhichTheAlbumNeedsToBeAdded.User = userName;
        shoppingCartOnWhichTheAlbumNeedsToBeAdded.CartItems = new List<CartItem>();
        db.ShoppingCarts.Add(shoppingCartOnWhichTheAlbumNeedsToBeAdded);
      }


      CartItem itemToAdd = shoppingCartOnWhichTheAlbumNeedsToBeAdded.CartItems.Find(c => c.AlbumId == albumIdToAdd);

      if (itemToAdd != null)
      {
        itemToAdd.Quantity++;
      }
      else
      {
        itemToAdd = new CartItem();
        itemToAdd.AlbumId = albumIdToAdd;
        itemToAdd.DateCreated = System.DateTime.Now;
        itemToAdd.Quantity = 1;
        itemToAdd.ShoppingCart = shoppingCartOnWhichTheAlbumNeedsToBeAdded;
        itemToAdd.ShoppingCartId = shoppingCartOnWhichTheAlbumNeedsToBeAdded.ShoppingCartId;
        shoppingCartOnWhichTheAlbumNeedsToBeAdded.CartItems.Add(itemToAdd);
      }

      // Save changes
      db.SaveChanges();
    }

    public int RemoveFromCart(int albumIdToRemove, string userName)
    {
      // Get the matching ShoppingCart
      ShoppingCart matchingShoppingCart = GetShoppingCartWithCartItems(userName);

      if (matchingShoppingCart == null)
        throw new InvalidOperationException("Cannot retrieve the shoppingCart of user " + userName);

      //Find the matching ShoppingCartItem
      CartItem itemToRemove = matchingShoppingCart.CartItems.Find(ci => ci.AlbumId == albumIdToRemove);
      int itemCount = 0;

      if (itemToRemove != null)
      {
        if (itemToRemove.Quantity > 1)
        {
          itemToRemove.Quantity--;
          itemCount = itemToRemove.Quantity;
        }
        else
          db.CartItems.Remove(itemToRemove);

        // Save changes
        db.SaveChanges();
      }

      return itemCount;
    }

    public void EmptyCart(string userName)
    {
      ShoppingCart shoppingCartToEmpty = GetShoppingCartWithCartItems(userName);

      foreach (var cartItem in shoppingCartToEmpty.CartItems)
        db.CartItems.Remove(cartItem);

      // Save changes
      db.SaveChanges();
    }

    public ShoppingCart GetShoppingCartWithCartItems(string userName)
    {
      return db.ShoppingCarts.Include(sc => sc.CartItems).SingleOrDefault<ShoppingCart>(sc => sc.User == userName);
    }

    public int GetTotalQuantity(string userName)
    {
      ShoppingCart shoppingCartOfUser = GetShoppingCartWithCartItems(userName);

      int? result = db.CartItems
                        .Include(ci => ci.ShoppingCart)
                        .Where<CartItem>(ci => ci.ShoppingCart.User == userName)
                        .Sum<CartItem>(ci => (int?)ci.Quantity);

      return result ?? 0;
    }


    public decimal GetTotalPrice(string userName)
    {
      decimal? result = db.CartItems
                        .Include(ci => ci.ShoppingCart)
                        .Where<CartItem>(ci => ci.ShoppingCart.User == userName)
                        .Sum<CartItem>(ci => (int?)ci.Quantity * ci.Album.Price);
           
      return result ?? Decimal.Zero;
    }

    // When a user has logged in, migrate their shopping cart to
    // be associated with their username
    //enkel nodig op eind bij Checkout
    public void MigrateCart(string oldUserGuid, string newUserName)
    {
      ShoppingCart cartToChange = GetShoppingCartWithCartItems(oldUserGuid);
      cartToChange.User = newUserName;      
      db.SaveChanges();
    }

    public void FillOrder(ref Order newOrder)
    {
       
        ShoppingCart shoppingCartToOrder = GetShoppingCartWithCartItems(newOrder.Username);
        decimal orderTotal = 0;

        
        // Iterate over the items in the cart, adding the order details for each
        foreach (var item in shoppingCartToOrder.CartItems)
        {
            var orderDetail = new OrderDetail
            {
                AlbumId = item.AlbumId,
                OrderId = newOrder.OrderId,
                UnitPrice = item.Album.Price,
                Quantity = item.Quantity
            };

            // Set the order total of the shopping cart
            orderTotal += (item.Quantity * item.Album.Price);

            newOrder.OrderDetails.Add(orderDetail);

        }

        // Set the order's total to the orderTotal count
        newOrder.Total = orderTotal;

        // Empty the shopping cart
        //this.EmptyCart(newOrder.Username);

        // Return the OrderId as the confirmation number
        //return newOrder.OrderId;
    }
  }
}
