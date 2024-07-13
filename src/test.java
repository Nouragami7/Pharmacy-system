import java.sql.*;
import java.sql.SQLException;


public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ///// JDBC /////
      String url = "jdbc:mysql://localhost:3306/sql_intro";
      String uname = "root";
      String pass = "Powerstatus124";
      String query = "Select med_name from pharmacy where med_price = 30";

      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      
      try {
        Connection con = DriverManager.getConnection(url, uname, pass); 
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        if(rs.next())
        {
          String name = rs.getString("med_name");
          System.out.println(name);
        }

        st.close();
        con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
    


}
