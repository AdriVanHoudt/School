﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Office.Tools.Ribbon;


namespace Test
{
    public partial class Ribbon1
    {
        private void Ribbon1_Load(object sender, RibbonUIEventArgs e)
        {
           
        }

        private void button1_Click(object sender, RibbonControlEventArgs e)
        {
            ThisAddIn t = Globals.ThisAddIn;
            t.calculateBTW(dbBTW.SelectedItemIndex);
        }
    }
}
