using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.SqlClient;
using ADOPrak2WFA.POCO;
using System.Data;

namespace ADOPrak2WFA.DAL
{
    public interface IDbManager
    {
        DataSet GetKlantenDataSet();      
    }
}
