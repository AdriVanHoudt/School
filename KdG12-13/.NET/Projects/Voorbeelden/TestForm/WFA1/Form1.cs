using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WFA1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnJos_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Blijft is van mijne knop af!", "TETTEEEUH", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            this.Close();
        }

        private void txtInput_TextChanged(object sender, EventArgs e)
        {
            lblInfo.Text = ((TextBox)sender).Text;
        }

        private void chkSetting_CheckedChanged(object sender, EventArgs e)
        {
            lblInfo.Text = ((CheckBox)sender).Tag.ToString();
        }
    }
}
