
package bd.com.dipti.accounting.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
    private Connection con;
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/accounting";
    
    public DButil() throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
    }
    
    public Connection getCon() throws SQLException{
       con = DriverManager.getConnection(url,user,password);
       return con;
    }
    
    

}