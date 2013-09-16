using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using ADO_prak_1.POCO;
using ADO_prak_1.DAL;

namespace ADO_prak_1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            OleDbManager manager = new OleDbManager();

            List<Cursus> lijst = manager.GetCursussen();
            int getal = 0;
            foreach(Cursus c in lijst){
            lst1.Items.Add(lijst[getal].toString());
            getal++;
            }
        }
    }
}
