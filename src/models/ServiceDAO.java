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
