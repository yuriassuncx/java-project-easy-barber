package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection mycon() {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/`nome do schema`", "root", "`senha do usuário`");
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println(error);
        }
        
        return con;
    }
}
