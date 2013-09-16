using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace TempConversion
{
  public partial class Form1 : Form
  {
    public Form1()
    {
      InitializeComponent();
    }

    private void btnCelc_Click(object sender, EventArgs e)
    {
      double fahr;
      if (Double.TryParse(txtFah.Text, out fahr))
      {
        double celc = (fahr - 32) / 1.8;
        lblCelcConv.Text = celc.ToString();
      }

    }

    private void btnToFahr_Click(object sender, EventArgs e)
    {
      double celc;
      if (Double.TryParse(txtCelc.Text, out celc))
      {
        double fahr = celc * 1.8 + 32;
        lblFahrConv.Text = fahr.ToString();
      }

    }
  }
}
