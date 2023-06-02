package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection faz_conexao() throws SQLException{
        
        try {
            //ativando o drive de conexao
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/barbearia?autoReconnect=true&useSSL=false","root","@Yuri123");
            //return DriverManager.getConnection(caminho,usuario,senha);
                    
        } catch (ClassNotFoundException e) {
            //mensagem caso não encontre a classe
            throw new SQLException(e.getException());
        }      
    }   
}
