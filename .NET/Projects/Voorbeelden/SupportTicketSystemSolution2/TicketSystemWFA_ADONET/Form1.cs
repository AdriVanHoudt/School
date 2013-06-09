using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Configuration;
using TicketSystem.DAL;
using TicketSystem.POCO;

namespace TicketSystemWFA_ADONET
{
    public partial class Form1 : Form
    {
        private IDbManager manager;
        public Form1(IDbManager dbManager)
        {
            this.manager = dbManager;
            InitializeComponent();
        }

        private void btnLoad_Click(object sender, EventArgs e)
        {
            grdTickets.DataSource = manager.GetTicketsDataSet();
            grdTickets.DataMember = "tblTickets";   

            DataGridViewTextBoxColumn clmId = new DataGridViewTextBoxColumn();
            clmId.Name = "IdColumn";
            clmId.DataPropertyName = "Id";

            DataGridViewTextBoxColumn clmAccountId = new DataGridViewTextBoxColumn();
            clmAccountId.Name = "AccountIdColumn";
            clmAccountId.DataPropertyName = "AccountId";

            DataGridViewTextBoxColumn clmDateOpened = new DataGridViewTextBoxColumn();
            clmDateOpened.Name = "DateOpenedColumn";
            clmDateOpened.DataPropertyName = "DateOpened";

            DataGridViewComboBoxColumn clmState = new DataGridViewComboBoxColumn();
            clmState.Name = "StateColumn";
            clmState.DataPropertyName = "State";

            clmState.DataSource = GetStates() ;
            clmState.DisplayMember ="Name" ;
            clmState.ValueMember="Value";

            grdTickets.Columns.Clear();
            grdTickets.Columns.Add(clmId);
            grdTickets.Columns.Add(clmAccountId);
            grdTickets.Columns.Add(clmDateOpened);
            grdTickets.Columns.Add(clmState);
        }

        private void bntSave_Click(object sender, EventArgs e)
        {
            manager.UpdateTicketsDataSet((DataSet)grdTickets.DataSource);
        }

        private List<State> GetStates()
        {
            List<State> states = new List<State>();

            foreach (byte value in Enum.GetValues(typeof(TicketState)))
            {
                State state = new State((Enum.GetName(typeof(TicketState),value)), value);
                states.Add(state);
            }

            return states;
        }

        private class State
        {
            public string Name { get; set; }
            public byte Value { get; set; }

            public State(string name, byte value)
            {
                this.Name = name;
                this.Value = value;
            }
        }

    }
}
