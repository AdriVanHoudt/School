using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using ADOPrak2WFA.POCO;
using ADOPrak2WFA.DAL;

namespace ADOPrak2WFA
{
    public partial class Form1 : Form
    {
        private IDbManager dbManager;
        public Form1(IDbManager manager)
        {
            this.dbManager = manager;
            InitializeComponent();
        }

        private void btnLoad_Click(object sender, EventArgs e)
        {
            grdView1.DataSource = this.dbManager.GetKlantenDataSet();
            grdView1.DataMember = "klant";

            DataGridViewTextBoxColumn clmId = new DataGridViewTextBoxColumn();
            clmId.Name = "klant_id";
            clmId.DataPropertyName = "klant_id";

            DataGridViewTextBoxColumn clmnaam = new DataGridViewTextBoxColumn();
            clmnaam.Name = "naam";
            clmnaam.DataPropertyName = "naam";

            DataGridViewTextBoxColumn clmvoornaam = new DataGridViewTextBoxColumn();
            clmvoornaam.Name = "voornaam";
            clmvoornaam.DataPropertyName = "voornaam";

            DataGridViewTextBoxColumn clmwoonplaats = new DataGridViewTextBoxColumn();
            clmwoonplaats.Name = "woonplaats";
            clmwoonplaats.DataPropertyName = "woonplaats";

            DataGridViewTextBoxColumn clmgeboortedatum = new DataGridViewTextBoxColumn();
            clmgeboortedatum.Name = "geboortedatum";
            clmgeboortedatum.DataPropertyName = "geboortedatum";

            DataGridViewTextBoxColumn clmgebruikersnaam = new DataGridViewTextBoxColumn();
            clmgebruikersnaam.Name = "gebruikersnaam";
            clmgebruikersnaam.DataPropertyName = "gebruikersnaam";

            DataGridViewTextBoxColumn clmpwd = new DataGridViewTextBoxColumn();
            clmpwd.Name = "pwd";
            clmpwd.DataPropertyName = "pwd";
         
            grdView1.Columns.Clear();
            grdView1.Columns.Add(clmId);
            grdView1.Columns.Add(clmnaam);
            grdView1.Columns.Add(clmvoornaam);
            grdView1.Columns.Add(clmwoonplaats);
            grdView1.Columns.Add(clmgeboortedatum);
            grdView1.Columns.Add(clmgebruikersnaam);
            grdView1.Columns.Add(clmpwd);
        }

        private void btnLoad2_Click(object sender, EventArgs e)
        {

        }
    }
}
