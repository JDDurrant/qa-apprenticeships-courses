using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Text;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Script.Services;
using System.Web.Services;

namespace Orders
{
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    [ScriptService]
    public class OrdersService : System.Web.Services.WebService
    {
        private string getConnectionString()
        {
            return @"Data Source=.\sqlexpress;Initial Catalog=Northwind;Integrated Security=True";
        }

        private DataSet getData(SqlCommand cmd)
        {
            cmd.Connection = new SqlConnection(getConnectionString());
            SqlDataAdapter adapter = new SqlDataAdapter(cmd);
            DataSet dataset = new DataSet("Northwind");
            adapter.Fill(dataset, "data");
            return dataset;
        }

        private string toJson(DataSet ds)
        {
            DataTable dt = ds.Tables[0];
            JavaScriptSerializer serializer = new JavaScriptSerializer();
            List<Dictionary<string, object>> rows = new List<Dictionary<string, object>>();
            Dictionary<string, object> row;
            foreach (DataRow dr in dt.Rows)
            {
                row = new Dictionary<string, object>();
                foreach (DataColumn col in dt.Columns)
                {
                    row.Add(col.ColumnName, dr[col]);
                }
                rows.Add(row);
            }
            return serializer.Serialize(rows);
        }

        // The web methods

        [WebMethod]
        [ScriptMethod(UseHttpGet =true, ResponseFormat = ResponseFormat.Json)]
        public void getOrders()
        {
            SqlCommand cmd = new SqlCommand("SELECT * FROM Orders");
            string s = toJson(getData(cmd));
            
            HttpContext.Current.Response.Write(s);
            HttpContext.Current.Response.End();
        }

        [WebMethod]
        [ScriptMethod(UseHttpGet = true, ResponseFormat = ResponseFormat.Json)]
        public void getOrderDetails(long orderId)
        {
            SqlCommand cmd = new SqlCommand(@"SELECT OD.OrderId,
                                                     OD.UnitPrice AS OrderUnitPrice,
                                                     OD.Quantity,
                                                     OD.Discount,
                                                     P.*
                                              FROM [Order Details] OD
                                              JOIN Products P ON OD.ProductId = P.ProductId
                                              WHERE OD.OrderId = @id");
            cmd.Parameters.Add(new SqlParameter("@id", orderId));

            string s = toJson(getData(cmd));

            HttpContext.Current.Response.Write(s);
            HttpContext.Current.Response.End();
        }
    }
}
