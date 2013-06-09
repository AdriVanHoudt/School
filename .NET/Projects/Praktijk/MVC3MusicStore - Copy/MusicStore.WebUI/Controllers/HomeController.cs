using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

using MusicStore.Domain.Concrete;

namespace MusicStore.WebUI.Controllers
{
    public class HomeController : Controller
    {
        EFDbContext db = new EFDbContext();
        //
        // GET: /Home/

        public ViewResult Index()
        {
          var lijst = db.Albums.ToList();
          return View();
        }

    }
}
