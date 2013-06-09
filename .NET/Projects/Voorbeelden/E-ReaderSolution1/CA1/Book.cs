using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CA1
{
    class Book
    {
        #region fields
        private string text;
        private ushort pageLength = 10;
        #endregion

        #region properties
        public string Title { get; private set; }
        public string Author { get; private set; }
        #endregion

        #region constructor
        public Book(string title, string author, string text)
        {
            this.Title = title;
            this.Author = author;
            this.text = text;
        } 
        #endregion

        #region methods
        public string GetPage(ushort pagenumber, ushort pageLenght = 10)
        {
            if (pagenumber != Math.Ceiling((double)this.text.Length / this.pageLength))
            {
                return text.Substring((pagenumber - 1) * pageLength, pageLength);
            }
            else
            {
                return text.Substring((pagenumber - 1) * pageLength);
            }
        }

        public override string ToString()
        {
            return String.Format("{0}, by {1} <{2}>",this.Title, this.Author, Math.Ceiling((double)this.text.Length/this.pageLength));
        }
        #endregion
    }
}
