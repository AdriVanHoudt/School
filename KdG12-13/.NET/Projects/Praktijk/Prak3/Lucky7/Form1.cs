using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Lucky7
{
    public partial class Form1 : Form
    {
        Random random = new Random();
        private const string SEVEN = "7";

        public Form1()
        {
            InitializeComponent();
        }

        private void btnStart_Click(object sender, EventArgs e)
        {
            LuckySeven(false);

            lbl1.Text = random.Next(0, 10).ToString();
            lbl2.Text = random.Next(0, 10).ToString();
            lbl3.Text = random.Next(0, 10).ToString();

            if (lbl1.Text == SEVEN || lbl2.Text == SEVEN || lbl3.Text == SEVEN)
            {
                LuckySeven(true);
            }
        }

        private void btnEnd_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void LuckySeven(bool b ){
            picGeldGewonnen.Visible = b;
            label1.Visible = b;
        }
    }
}
