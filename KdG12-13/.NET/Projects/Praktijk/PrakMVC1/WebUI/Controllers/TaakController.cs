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
    public class TaakController : Controller
    {
        private GTDbContext db = new GTDbContext();

        //
        // GET: /Taak/

        public ViewResult Index()
        {
            var taken = db.Taken.Include(t => t.Project).Include(t => t.Prioriteit);
            return View(taken.ToList());
        }

        //
        // GET: /Taak/Details/5

        public ViewResult Details(int id)
        {
            Taak taak = db.Taken.Find(id);
            return View(taak);
        }

        //
        // GET: /Taak/Create

        public ActionResult Create()
        {
            ViewBag.ProjectId = new SelectList(db.Projecten, "ProjectId", "Naam");
            ViewBag.PrioriteitId = new SelectList(db.Prioriteiten, "PrioriteitID", "Naam");
            return View();
        } 

        //
        // POST: /Taak/Create

        [HttpPost]
        public ActionResult Create(Taak taak)
        {
            if (ModelState.IsValid)
            {
                db.Taken.Add(taak);
                db.SaveChanges();
                return RedirectToAction("Index");  
            }

            ViewBag.ProjectId = new SelectList(db.Projecten, "ProjectId", "Naam", taak.ProjectId);
            ViewBag.PrioriteitId = new SelectList(db.Prioriteiten, "PrioriteitID", "Naam", taak.PrioriteitId);
            return View(taak);
        }
        
        //
        // GET: /Taak/Edit/5
 
        public ActionResult Edit(int id)
        {
            Taak taak = db.Taken.Find(id);
            ViewBag.ProjectId = new SelectList(db.Projecten, "ProjectId", "Naam", taak.ProjectId);
            ViewBag.PrioriteitId = new SelectList(db.Prioriteiten, "PrioriteitID", "Naam", taak.PrioriteitId);
            return View(taak);
        }

        //
        // POST: /Taak/Edit/5

        [HttpPost]
        public ActionResult Edit(Taak taak)
        {
            if (ModelState.IsValid)
            {
                db.Entry(taak).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.ProjectId = new SelectList(db.Projecten, "ProjectId", "Naam", taak.ProjectId);
            ViewBag.PrioriteitId = new SelectList(db.Prioriteiten, "PrioriteitID", "Naam", taak.PrioriteitId);
            return View(taak);
        }

        //
        // GET: /Taak/Delete/5
 
        public ActionResult Delete(int id)
        {
            Taak taak = db.Taken.Find(id);
            return View(taak);
        }

        //
        // POST: /Taak/Delete/5

        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmed(int id)
        {            
            Taak taak = db.Taken.Find(id);
            db.Taken.Remove(taak);
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