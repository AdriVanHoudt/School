using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using System.Data;
using System.Data.SqlClient;
using System.Configuration;
using ADOPrak2WFA.POCO;

namespace ADOPrak2WFA.DAL
{
    public class SqlClientManager : IDbManager
    {
        private SqlDataAdapter daKlanten;
        private SqlDataAdapter daArtikels;

        public SqlClientManager()
        {
            BuildDataAdapterKlanten();
            BuildDataAdapterArtikels();
        }

        public void BuildDataAdapterKlanten()
        {
            daKlanten = new SqlDataAdapter();
            string selectSql = "SELECT klant_id, naam, voornaam, woonplaats, geboortedatum, gebruikersnaam, pwd FROM klant";
            SqlCommand selectCmd = new SqlCommand(selectSql, GetConnection());
            daKlanten.SelectCommand = selectCmd;
            SqlCommandBuilder cb = new SqlCommandBuilder(daKlanten);
        }

        public void BuildDataAdapterArtikels()
        {
            daArtikels = new SqlDataAdapter();
            string selectSql = "SELECT klant_id, naam, voornaam, woonplaats, geboortedatum, gebruikersnaam, pwd FROM klant";
            SqlCommand selectCmd = new SqlCommand(selectSql, GetConnection());
            daArtikels.SelectCommand = selectCmd;
            SqlCommandBuilder cb = new SqlCommandBuilder(daArtikels);
        }

        public DataSet GetKlantenDataSet()
        {
            DataSet dsKlanten = new DataSet();
            daArtikels.Fill(dsKlanten, "klant");
            return dsKlanten;
        }

        public DataSet GetArtikelDataset()
        {
            DataSet dsArtikels = new DataSet();
            daArtikels.Fill(dsArtikels, "Artikel");
            return dsArtikels;
        }

        private SqlConnection GetConnection()
        {
            SqlConnection conn = new SqlConnection();
            conn.ConnectionString = ConfigurationManager.ConnectionStrings["Spionshop.mdf"].ConnectionString;
            return conn;
        }
    }
}