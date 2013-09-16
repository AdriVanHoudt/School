using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Rakenmachine
{
    public partial class Form1 : Form
    {
        Button btnNumber, btnAction;
        double result, number1, number2;
        bool actionSelected = false;

        public Form1(){
        InitializeComponent();
        }

        private void btnNumber_Click(object sender, EventArgs e)
        {
            btnNumber = (Button)sender;
            if (!actionSelected)
            {
                number1 = double.Parse(btnNumber.Text);
                setDisplay(number1);
            }
            else
            {
                number2 = double.Parse(btnNumber.Text);
                setDisplay(number2);
            }
        }

        private void btnAction_Click(object sender, EventArgs e)
        {
            btnAction = (Button)sender;
            actionSelected = true;
        }

        private void setDisplay(double number)
        {
            lblDisplay.Text = number.ToString();
        }

        private void btnCalculate_Click(object sender, EventArgs e)
        {
            if (actionSelected)
            {
                switch (int.Parse(btnAction.Tag.ToString()))
                {
                    case 1:
                        result = number1 + number2;
                        setDisplay(result);
                        number1 = result;
                        break;
                    case 2:
                        result = number1 - number2;
                        setDisplay(result);
                        number1 = result;
                        break;
                    case 3:
                        result = number1 * number2;
                        setDisplay(result);
                        number1 = result;
                        break;
                    case 4:
                        result = number1 / number2;
                        setDisplay(result);
                        number1 = result;
                        break;
                    default:
                        MessageBox.Show("ERROR switch case calculate");
                        break;
                }
            }

        }
    }
}
