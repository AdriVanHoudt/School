using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

using System.Threading;

using MusicStore.Domain.POCO;
using MusicStore.WebUI.ViewModels;

namespace MusicStore.WebUI.Controllers
{
  public class ShoppingCartController : Controller
  {
    private MusicStore.Domain.Concrete.ShoppingCartManager manager = new MusicStore.Domain.Concrete.ShoppingCartManager();


    #region State management
    private const string CTE_Session_UserName = "UserName";

    private string CurrentUserName
    {
      get
      {
        string userName = String.Empty;

        //Check if the session already contains a userName
        if (Session[CTE_Session_UserName] == null)
        {
          //Create a username on, based on the current logged in user 
          // of if no user has logged in, create an unique number for this session
          if (Thread.CurrentPrincipal != null
                && Thread.CurrentPrincipal.Identity != null
                && !String.IsNullOrEmpty(Thread.CurrentPrincipal.Identity.Name))
          {
            userName = Thread.CurrentPrincipal.Identity.Name;
          }
          else
            userName = Guid.NewGuid().ToString();

          Session[CTE_Session_UserName] = userName;

        }
        else
          userName = Session[CTE_Session_UserName].ToString();

        return userName;
      }
    }
    #endregion

    //
    // GET: /ShoppingCart/
    public ActionResult Index()
    {
      ShoppingCart currentShoppingCart = manager.GetShoppingCartWithCartItems(this.CurrentUserName);
      if (currentShoppingCart == null) return RedirectToAction("Index", "Home");
      
      // Set up our ViewModel
      var viewModel = new ShoppingCartViewModel() 
                            {
                              CartItems = currentShoppingCart.CartItems,
                              CartTotal = manager.GetTotalPrice(CurrentUserName)
                            };

      // Return the view
      return View(viewModel);
    }

    //
    // GET: /ShoppingCart/AddToCart/5
    
    public ActionResult AddToCart(int albumIdToAdd)
    {
      manager.AddToCart(albumIdToAdd, this.CurrentUserName);

      // Go back to the main store page for more shopping
      return RedirectToAction("Index");
    }

    //
    // AJAX: /ShoppingCart/RemoveFromCart/5

    [HttpPost]
    public ActionResult RemoveFromCart(int albumIdToRemove)
    {
      // Remove the item from the cart
      var currentShoppingCart = manager.GetShoppingCartWithCartItems(this.CurrentUserName);


      // Get the name of the album to display confirmation
      string albumName = currentShoppingCart
                                          .CartItems
                                          .Find(ci => ci.AlbumId == albumIdToRemove)
                                          .Album.Title;
      
      // Remove from cart
      int itemsLeft = manager.RemoveFromCart(albumIdToRemove, this.CurrentUserName);

      // Display the confirmation message
      ShoppingCartRemoveViewModel dataToShow = new ShoppingCartRemoveViewModel()
      {
        Message = Server.HtmlEncode(albumName) +
            " has been removed from your shopping cart.",
        CartTotal = manager.GetTotalPrice(this.CurrentUserName),
        CartCount = manager.GetTotalQuantity(this.CurrentUserName),
        ItemCount = itemsLeft,
        DeleteId = albumIdToRemove
      };

      return Json(dataToShow);
    }

    //
    // GET: /ShoppingCart/CartSummary

    [ChildActionOnly]
    public ActionResult CartSummary()
    {
      ViewData["CartCount"] = manager.GetTotalQuantity(this.CurrentUserName);
      return PartialView("CartSummary");
    }
  }
}
