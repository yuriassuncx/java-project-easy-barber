package models;


import java.sql.PreparedStatement;
import database.Conexao;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BarbeiroDAO {
    public void create(Barber barber) throws SQLException {
      try {
        Connection con = Conexao.faz_conexao();        

        // Cria o barbeiro
        String query = "INSERT INTO barber (name) VALUES (?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, barber.getBarberName());
        stmt.executeUpdate();
           
        JOptionPane.showMessageDialog(null, "Dados cadastrado com sucesso!");
        con.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
      }   
    }
    
    public List<Barber> read() throws SQLException {
        Connection con = Conexao.faz_conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Barber> barbeiros = new ArrayList<>();
    
        try {
            stmt = con.prepareStatement(
        """
                SELECT barber.name AS barbeiro, COALESCE(COUNT(feedback.id), 0) AS total_likes
                FROM barber
                LEFT JOIN feedback ON barber.id = feedback.barber_id
                GROUP BY barber.name;""");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Barber tbBarbeiro = new Barber();

                tbBarbeiro.setBarbeiro(rs.getString("barbeiro"));
                tbBarbeiro.setTotalLikes(rs.getInt("total_likes"));
                barbeiros.add(tbBarbeiro);
           } 
             
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro");
        } 

        return barbeiros;
    }
}
