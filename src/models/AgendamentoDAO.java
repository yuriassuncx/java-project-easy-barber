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
    public void create(Agendamento agenda) throws SQLException {
      try {
        Connection con = Conexao.faz_conexao();
        
        // Verifica se já existe um agendamento com a mesma data e hora
        String query = "SELECT COUNT(*) FROM agendamento WHERE data_agend = ? AND hora_agend = ? AND barber_id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, agenda.getData_agend());
        stmt.setString(2, agenda.getHora_agend());
        stmt.setInt(3, agenda.getBarberId());
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        
        if (count > 0) {
            JOptionPane.showMessageDialog(null, "Essa data e hora já estão ocupadas!");
            return;
        }

        // Cria o agendamento
        query = "INSERT INTO agendamento (barber_id, user_id, servico, data_agend, hora_agend, observacao, preco) VALUES (?, ?, ?, ?, ?, ?, ?)";
        stmt = con.prepareStatement(query);
        stmt.setInt(1, agenda.getBarberId());
        stmt.setInt(2, agenda.getClienteId());
        stmt.setString(3, agenda.getServico());
        stmt.setString(4, agenda.getData_agend());
        stmt.setString(5, agenda.getHora_agend());
        stmt.setString(6, agenda.getObservacao());
        stmt.setInt(7, agenda.getPreco());
        stmt.executeUpdate();
           
        JOptionPane.showMessageDialog(null, "Dados cadastrado com sucesso!");
        con.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
      }   
    }
    
    public List<Agendamento> read() throws SQLException {
        Connection con = Conexao.faz_conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Agendamento> agendas = new ArrayList<>();
    
        try {
            stmt = con.prepareStatement(
        """
                SELECT barber.name AS barbeiro, user.name AS cliente, servico, data_agend, hora_agend, observacao, preco 
                FROM agendamento
                JOIN barber ON barber.id = agendamento.barber_id
                JOIN user ON user.id = agendamento.user_id;""");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Agendamento tbAgendamento = new Agendamento();

                tbAgendamento.setBarbeiro(rs.getString("barbeiro"));
                tbAgendamento.setCliente(rs.getString("cliente"));
                tbAgendamento.setServico(rs.getString("servico"));
                tbAgendamento.setData_agend(rs.getString("data_agend"));
                tbAgendamento.setHora_agend(rs.getString("hora_agend"));
                tbAgendamento.setObservacao(rs.getString("observacao"));
                tbAgendamento.setPreco(rs.getInt("preco"));
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
    
    public List<Agendamento> readByUserId(int user_id) throws SQLException {
        Connection con = Conexao.faz_conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Agendamento> agendas = new ArrayList<>();
    
        try {
            stmt = con.prepareStatement(
        """
                SELECT barber.name AS barbeiro, user.name AS cliente, servico, data_agend, hora_agend, observacao, preco 
                FROM agendamento
                JOIN barber ON barber.id = agendamento.barber_id
                JOIN user ON user.id = agendamento.user_id
                WHERE user_id = ?;""");
            
            stmt.setInt(1, user_id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Agendamento tbAgendamento = new Agendamento();

                tbAgendamento.setBarbeiro(rs.getString("barbeiro"));
                tbAgendamento.setCliente(rs.getString("cliente"));
                tbAgendamento.setServico(rs.getString("servico"));
                tbAgendamento.setData_agend(rs.getString("data_agend"));
                tbAgendamento.setHora_agend(rs.getString("hora_agend"));
                tbAgendamento.setObservacao(rs.getString("observacao"));
                tbAgendamento.setPreco(rs.getInt("preco"));
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
            
        String sql = "UPDATE agendamento SET barber_id = ?, user_id = ?, servico = ?, data_agend = ?, hora_agend = ?, observacao = ? WHERE id = ?)";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1,agenda.getBarberId());
        stmt.setInt(2,agenda.getClienteId());
        stmt.setString(3,agenda.getServico());
        stmt.setString(4,agenda.getData_agend());
        stmt.setString(5,agenda.getHora_agend());
        stmt.setString(6,agenda.getObservacao());
        stmt.setInt(7,agenda.getId());

        stmt.execute();

        JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        con.close();
        stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }   
    }
}
