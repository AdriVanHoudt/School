using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Domain.POCO;
using Domain.DB;

namespace WebUI.Controllers
{
    public class HomeController : Controller
    {

        private GTDbContext db = new GTDbContext();
        //
        // GET: /Home/

        public ActionResult Index()
        {
            var model = db.Taken.Where(x => x.Status!=3 && x.PrioriteitId==1);
            return View(model);
        }

    }
}
