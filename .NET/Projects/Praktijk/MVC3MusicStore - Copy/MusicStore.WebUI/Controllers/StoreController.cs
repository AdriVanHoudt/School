using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

using MusicStore.Domain.POCO;
using MusicStore.Domain.Concrete;

namespace MusicStore.WebUI.Controllers
{
    public class StoreController : Controller
    {
      EFDbContext db = new EFDbContext();
        //
        // GET: /Store/

        public ActionResult Index()
        {
          var genres = db.Genres.ToList<Genre>();
          return View(genres);
        }

        // GET: /Store/Browse
        public ActionResult Browse(string genre)
        {
          var genreModel = db.Genres.Include("Albums").Single<Genre>(x => x.Name == genre); // er zou er maar 1 mogen bestaan, first => zouden er meerdere kunnen zijn en alleen de eerste
            //include ==> verwante albums mee inladen
          return View(genreModel);
        }

        //GET: /Store/Details
        public ActionResult Details(int id)
        {
          var album = db.Albums.Include("Artist").Single<Album>(x => x.AlbumId == id);
          return View(album);
        }

    }
}
