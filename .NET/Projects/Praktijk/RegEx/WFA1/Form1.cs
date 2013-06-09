using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Text.RegularExpressions;

namespace WFA1
{
    public partial class Form1 : Form
    {
        private Regex regexName = new Regex("@[a-zA-Z ]{10,}");
        private Regex regexPassword = new Regex(@"[A-Z0-9-//]{5,10}$");
        private Regex regexEmail = new Regex(@"[\.a-z]+[@]+[a-z\.]+[a-z]{2,}");
        private Regex regexRRN = new Regex(@"[0-9]{2,2}[\.][0-9]{2,2}[\.][0-9]{2,2}[ ][0-9]{3,3}[ ][0-9]{2,2}$");
        private Regex regexa = new Regex(@"[a]");
        private Regex regexA = new Regex(@"[A]");


        public Form1()
        {
            InitializeComponent();
        }

        private void btnControle_Click(object sender, EventArgs e)
        {
            if (regexName.IsMatch(txtName.Text))
            {
                txtName.BackColor = Color.Green;
            }
            else
            {
                txtName.BackColor = Color.Red;
            }

            if (regexPassword.IsMatch(txtPassword.Text))
            {
                txtPassword.BackColor = Color.Green;
            }
            else
            {
                txtPassword.BackColor = Color.Red;
            }

            if (regexEmail.IsMatch(txtEmail.Text))
            {
                txtEmail.BackColor = Color.Green;
            }
            else
            {
                txtEmail.BackColor = Color.Red;
            }

            if (regexRRN.IsMatch(txtRRN.Text))
            {
                txtRRN.BackColor = Color.Green;
            }
            else
            {
                txtRRN.BackColor = Color.Red;
            }

            txtReplaceText.Text = regexa.Replace(txtReplaceText.Text, "z");
            txtReplaceText.Text = regexA.Replace(txtReplaceText.Text, "Z");
        }
    }
}
