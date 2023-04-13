/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


import java.sql.PreparedStatement;
import database.Conexao;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AgendamentoDAO {
    
    public void create(Agendamento agenda) throws SQLException{
  
      try {
        Connection con = Conexao.faz_conexao();

        String sql = "INSERT INTO agendamento (barbeiro , servico , data_agend , hora_agend , observacao) values (?,?,?,?,?)";

        PreparedStatement stmt = con.prepareStatement(sql);
            
        stmt.setString(1,agenda.getBarbeiro());
        stmt.setString(2,agenda.getServico());
        stmt.setString(3,agenda.getData_agend());
        stmt.setString(4,agenda.getHora_agend());
        stmt.setString(5,agenda.getObservacao());
            
        stmt.execute();
           
        JOptionPane.showMessageDialog(null, "Dados cadastrado com sucesso!");
        con.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
      }   
    }
    
    public List<Agendamento> read() throws SQLException{
    
        Connection con = Conexao.faz_conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Agendamento> agendas = new ArrayList<>();
    
        try {
               
            stmt = con.prepareStatement("SELECT * FROM agendamento");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Agendamento tbAgendamento = new Agendamento();

                tbAgendamento.setBarbeiro(rs.getString("barbeiro"));
                tbAgendamento.setServico(rs.getString("servico"));
                tbAgendamento.setData_agend(rs.getString("data_agend"));
                tbAgendamento.setHora_agend(rs.getString("hora_agend"));
                tbAgendamento.setObservacao(rs.getString("observacao"));
                agendas.add(tbAgendamento);
           } 
             
        stmt.close();
        rs.close();
        con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro");
        } 

        return agendas;
    
    }
    
    public void update(Agendamento agenda) throws SQLException{
  
      try {
            Connection con = Conexao.faz_conexao();
            
            String sql = "UPDATE agendamento SET barbeiro = ?,servico = ?,data_agend = ?,hora_agend = ?,observacao = ? WHERE id = ?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
           stmt.setString(1,agenda.getBarbeiro());
           stmt.setString(2,agenda.getServico());
           stmt.setString(3,agenda.getData_agend());
           stmt.setString(4,agenda.getHora_agend());
           stmt.setString(5,agenda.getObservacao());
           stmt.setInt(4,agenda.getId());
            
           stmt.execute();
            
            
           
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            con.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro");
      }   
    }
}
