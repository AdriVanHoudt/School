using System;
using System.Collections.Generic;
using Excel = Microsoft.Office.Interop.Excel;
using System.Windows.Forms;

namespace Test
{
    public partial class ThisAddIn
    {
        private bool btnPressed = false;
        private List<double> results = new List<double>();

        private void ThisAddIn_Startup(object sender, System.EventArgs e)
        {
          
        }

        private void ThisAddIn_Shutdown(object sender, System.EventArgs e)
        {
        }

        public void calculateBTW(int dbIndex)
        {
            
            double btw = 0;

            //determine the active workscheet and the 
            Excel.Worksheet activeWorksheet = getActiveWorksheet();
            Excel.Range range = (Excel.Range)Application.Selection;
           
            //determine btw value based on the dropdown box
            switch (dbIndex)
            {
                case 0:
                    btw = 1.21;
                    break;
                case 1:
                    btw = 1.12;
                    break;
                case 2:
                    btw = 1.06;
                    break;
            }

            // Go through each column un the range
            foreach (Excel.Range columns in range.Columns)
            {
                //Go through each row in the column
                foreach (Excel.Range cell in columns.Rows)
                {
                    //get value from cell and store the result after calculation in an array
                    double p;
                    double.TryParse(cell.Text, out p);
                    p *= btw;
                    results.Add(p);
                }
            }
            btnPressed = true;
            MessageBox.Show("Select the starting cell to output the results to", "Select...", MessageBoxButtons.OK);
            getActiveWorksheet().SelectionChange += new Excel.DocEvents_SelectionChangeEventHandler(ThisAddIn_SelectionChange);
           
        }

        private void fillRangeWithArray(Excel.Range targetRange, List<double> results)
        {
            //put all the results in the column right of the original selected range
            for (int i = 1; i <= results.Count; i++)
            {
                Excel.Range r =  getActiveWorksheet().Cells[targetRange.Row + (i - 1), targetRange.Column];
                r.Value = results[i - 1];
                //optional: change the border color
                r.Borders.Color = System.Drawing.ColorTranslator.ToOle(System.Drawing.Color.Blue);
            }
        }

        private void ThisAddIn_SelectionChange(Excel.Range target)
        {
            if (btnPressed)
            { 
                fillRangeWithArray(target, results);
                btnPressed = false;
            }
        }

        private Excel.Worksheet getActiveWorksheet()
        {
            return (Excel.Worksheet)Application.ActiveSheet;
        }

        #region VSTO generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InternalStartup()
        {
            this.Startup += new System.EventHandler(ThisAddIn_Startup);
            this.Shutdown += new System.EventHandler(ThisAddIn_Shutdown);
        }
        
        #endregion

    }
}
