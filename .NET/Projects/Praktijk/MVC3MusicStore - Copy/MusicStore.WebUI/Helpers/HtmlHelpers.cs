using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Threading;

namespace MusicStore.WebUI.Helpers
{
  public static class HtmlHelpers
  {
    public static string Truncate(this HtmlHelper helper, string input, int length) //eerste parameter is verwijzing naar type dat je wilt uitbreiden
    {
      if (input.Length > length) {
        return input.Substring(0, length-3) + "...";
      }
      else return input;
    }

    public static IHtmlString MetaAcceptLanguage(this HtmlHelper html)
    {
        var acceptLanguage = HttpUtility.HtmlAttributeEncode(Thread.CurrentThread.CurrentUICulture.ToString());
        return new HtmlString(string.Format("<meta name\"{0}\" ContentResult=\"{1}\"/>","accept language", acceptLanguage));
    }

  }
}