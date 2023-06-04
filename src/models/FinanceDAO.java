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


public class FinanceDAO {    
    public List<Finance> read() throws SQLException {        
        Connection con = Conexao.faz_conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Finance> finance = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT profit, sales, expenses FROM finance;");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Finance tbFinance = new Finance();
                tbFinance.setLucros(rs.getFloat("profit"));
                tbFinance.setSaldos(rs.getFloat("sales"));
                tbFinance.setDespesas(rs.getFloat("expenses"));
                finance.add(tbFinance);
            } 
             
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
        
        return finance;
    }    
}
