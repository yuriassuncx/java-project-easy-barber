/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ServiceDAO {
    public void create(Service service) throws SQLException {
      try {
        Connection con = Conexao.faz_conexao();        

        // Cria o barbeiro
        String query = "INSERT INTO service (cut_type, price) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, service.getService());
        stmt.setInt(2, service.getPrice());
        stmt.executeUpdate();
           
        JOptionPane.showMessageDialog(null, "Dados cadastrado com sucesso!");
        con.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
      }   
    }
    
    public List<Service> read() throws SQLException {        
        Connection con = Conexao.faz_conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Service> services = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM SERVICE;");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Service tbService = new Service();
                tbService.setId(rs.getInt("id"));
                tbService.setService(rs.getString("cut_type"));
                tbService.setPrice(rs.getInt("price"));
                services.add(tbService);
            } 
             
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
        
        return services;
    }    
}
