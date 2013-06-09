using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using TicketSystem.DAL;

namespace TicketSystemWFA_ADONET
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            IDbManager dbManager = new OleDbManager();
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1(dbManager));
        }
    }
}
