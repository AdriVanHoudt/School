using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MusicStore.WebUI.Controllers
{
  public class ExampleController : Controller
  {
    //
    // GET: /Error/

    public ActionResult Index()
    {
      return View();
    }

    public ActionResult Exception()
    {
      throw new ArgumentNullException();
    }

    public ActionResult DbException()
    {
      throw new MyDbException("MyDbException");
    }

    private class MyDbException : System.Data.Common.DbException
    {
      public MyDbException(string errorMessage)
        : base(errorMessage)
      {
      }
    }

  }
}
