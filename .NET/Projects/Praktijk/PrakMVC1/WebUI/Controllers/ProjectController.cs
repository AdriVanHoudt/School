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
    public class ProjectController : Controller
    {
        private GTDbContext db = new GTDbContext();

        //
        // GET: /Project/

        public ViewResult Index()
        {
            var projecten = db.Projecten.Include(p => p.Context);
            return View(projecten.ToList());
        }

        //
        // GET: /Project/Details/5

        public ViewResult Details(int id)
        {
            Project project = db.Projecten.Find(id);
            return View(project);
        }

        //
        // GET: /Project/Create

        public ActionResult Create()
        {
            ViewBag.ContextId = new SelectList(db.Contexten, "ContextID", "Naam");
            return View();
        } 

        //
        // POST: /Project/Create

        [HttpPost]
        public ActionResult Create(Project project)
        {
            if (ModelState.IsValid)
            {
                db.Projecten.Add(project);
                db.SaveChanges();
                return RedirectToAction("Index");  
            }

            ViewBag.ContextId = new SelectList(db.Contexten, "ContextID", "Naam", project.ContextId);
            return View(project);
        }
        
        //
        // GET: /Project/Edit/5
 
        public ActionResult Edit(int id)
        {
            Project project = db.Projecten.Find(id);
            ViewBag.ContextId = new SelectList(db.Contexten, "ContextID", "Naam", project.ContextId);
            return View(project);
        }

        //
        // POST: /Project/Edit/5

        [HttpPost]
        public ActionResult Edit(Project project)
        {
            if (ModelState.IsValid)
            {
                db.Entry(project).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.ContextId = new SelectList(db.Contexten, "ContextID", "Naam", project.ContextId);
            return View(project);
        }

        //
        // GET: /Project/Delete/5
 
        public ActionResult Delete(int id)
        {
            Project project = db.Projecten.Find(id);
            return View(project);
        }

        //
        // POST: /Project/Delete/5

        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmed(int id)
        {            
            Project project = db.Projecten.Find(id);
            db.Projecten.Remove(project);
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