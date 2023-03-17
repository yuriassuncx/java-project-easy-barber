package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mathe
 */
public class Conexao {
    
       /*private static String caminho = "jdbc:mysql://localhost/db_senhas";
       private static String usuario = "root";
       private static String senha = "Agape123@";*/

    public static Connection faz_conexao() throws SQLException{
        
        try {
            //ativando o drive de conexao
            Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection("jdbc:mysql://localhost/easybarber?autoReconnect=true&useSSL=false","root","unipe");
            //return DriverManager.getConnection(caminho,usuario,senha);
                    
        } catch (ClassNotFoundException e) {
            //mensagem caso não encontre a classe
            throw new SQLException(e.getException());
        }
           
    }
    
   
    
}
