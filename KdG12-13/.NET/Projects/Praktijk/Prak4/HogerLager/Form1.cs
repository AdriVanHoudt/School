using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace HogerLager
{
    public partial class Form1 : Form
    {
        private Random random = new Random();
        private int getal;

        public Form1()
        {
            InitializeComponent();
        }

        private void btnNieuwSpel_Click(object sender, EventArgs e)
        {
            getal = random.Next(1, 101);
            txtInput.Enabled = true;
            btnEvalueer.Enabled = true;
            txtInput.Focus();
        }

        private void btnStop_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnEvalueer_Click(object sender, EventArgs e)
        {
            int input;
            if (!int.TryParse(txtInput.Text,out input)){
                lblBoodschap.Text = "Verkeerde invoer!!";
                lblBoodschap.ForeColor=Color.Red;
            }else if (input  < getal)
            {
                lblBoodschap.Text = "Hoger";
                focusInput();
            }
            else if (input > getal)
            {
                lblBoodschap.Text = "Lager";
                focusInput();
            }
            else if (input == getal)
            {
                lblBoodschap.Text = "Gewonnen!!";
                btnEvalueer.Enabled = false;
                txtInput.Enabled = false;
            }
        }

        private void focusInput()
        {
            txtInput.Focus();
            txtInput.SelectAll();
        }

        private void txtInput_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Enter)
            {
                btnEvalueer.Focus();
            }
        }
    }
}
