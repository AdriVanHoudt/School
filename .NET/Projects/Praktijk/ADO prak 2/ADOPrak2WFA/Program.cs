using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using ADOPrak2WFA.DAL;

namespace ADOPrak2WFA
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            IDbManager dbManager = new SqlClientManager();
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1(dbManager));
        }
    }
}
