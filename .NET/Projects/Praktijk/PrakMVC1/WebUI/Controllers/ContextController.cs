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
    public class ContextController : Controller
    {
        private GTDbContext db = new GTDbContext();

        //
        // GET: /Context/

        public ViewResult Index()
        {
            return View(db.Contexten.ToList());
        }

        //
        // GET: /Context/Details/5

        public ViewResult Details(int id)
        {
            Context context = db.Contexten.Find(id);
            return View(context);
        }

        //
        // GET: /Context/Create

        public ActionResult Create()
        {
            return View();
        } 

        //
        // POST: /Context/Create

        [HttpPost]
        public ActionResult Create(Context context)
        {
            if (ModelState.IsValid)
            {
                db.Contexten.Add(context);
                db.SaveChanges();
                return RedirectToAction("Index");  
            }

            return View(context);
        }
        
        //
        // GET: /Context/Edit/5
 
        public ActionResult Edit(int id)
        {
            Context context = db.Contexten.Find(id);
            return View(context);
        }

        //
        // POST: /Context/Edit/5

        [HttpPost]
        public ActionResult Edit(Context context)
        {
            if (ModelState.IsValid)
            {
                db.Entry(context).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(context);
        }

        //
        // GET: /Context/Delete/5
 
        public ActionResult Delete(int id)
        {
            Context context = db.Contexten.Find(id);
            return View(context);
        }

        //
        // POST: /Context/Delete/5

        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmed(int id)
        {            
            Context context = db.Contexten.Find(id);
            db.Contexten.Remove(context);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            db.Dispose();
            base.Dispose(disposing);
        }
    }
}