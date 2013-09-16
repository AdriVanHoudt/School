using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb;
using ADO_prak_1.POCO;

namespace ADO_prak_1.DAL
{
    class OleDbManager
    {
        private OleDbConnection GetConnection()
        {
            OleDbConnection conn = new OleDbConnection();
            conn.ConnectionString = "Provider=Microsoft.ACE.OLEDB.12.0;"
                                    + "Data Source=|DataDirectory|demo1.accdb;"
                                    + "Persist Security Info=True";
            return conn;
        }

        public List<Cursus> GetCursussen()
        {
            List<Cursus> Cursussen = new List<Cursus>();

            String sql = "SELECT CursusNr, CursusNaam FROM tblCursus";

            using (OleDbConnection conn = this.GetConnection())
            {
                conn.Open();
                OleDbCommand sqlCmd = new OleDbCommand(sql, conn);


                using (OleDbDataReader reader = sqlCmd.ExecuteReader())
                {
                    if (reader.HasRows)
                    {
                        while (reader.Read())
                        {
                            Cursus Cursus = new Cursus();
                            Cursus.CursusNr = reader.GetInt32(reader.GetOrdinal("CursusNr"));
                            Cursus.CursusNaam = reader.GetString(reader.GetOrdinal("CursusNaam"));

                            Cursussen.Add(Cursus);
                        }
                    }
                    reader.Close();
                }
                conn.Close();
            }
            return Cursussen;
        }
    }
}
