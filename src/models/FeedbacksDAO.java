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
}
