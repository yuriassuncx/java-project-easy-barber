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

/**
 *
 * @author Fábio
 */
public class FeedbacksDAO {
    public List<Feedback> read() throws SQLException {        
        Connection con = Conexao.faz_conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Feedback> feedbacks = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(
        """
                SELECT b.name, COUNT(f.id) AS total_likes
                FROM feedback f
                JOIN barber b ON f.barber_id = b.id
                GROUP BY b.id, b.name
                ORDER BY total_likes DESC;"""
            );
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Feedback tbFeedback = new Feedback();
                tbFeedback.setBarbeiro(rs.getString("name"));
                tbFeedback.setTotalLikes(rs.getInt("total_likes"));
                feedbacks.add(tbFeedback);
            } 
             
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
        
        return feedbacks;
    }
    
    public void createFeedback(int user_id, int barber_id, boolean is_liked, String avaliacao) throws SQLException {
        try {
            Connection con = Conexao.faz_conexao();

            String sql = "INSERT INTO feedback (barber_id, user_id, is_liked, avaliacao) values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, barber_id);
            stmt.setInt(2, user_id);
            stmt.setBoolean(3, is_liked);
            stmt.setString(4, avaliacao);

            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Feedback cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar feedback.");
            }

            JOptionPane.showMessageDialog(null, "Feedback inserido com sucesso!");
            con.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar feedback!");
        }
    }
    
    public void deleteFeedback(int user_id, int barber_id) throws SQLException {
        try {
            Connection con = Conexao.faz_conexao();
            
            String sql = "DELETE FROM feedbacks WHERE user_id = ? AND barber_id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, user_id);
            stmt.setInt(2, barber_id);
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Feedback removido com sucesso!");
            } else {
                System.out.println("Nenhum feedback encontrado para remover.");
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover feedback.");
        }
    }
}
