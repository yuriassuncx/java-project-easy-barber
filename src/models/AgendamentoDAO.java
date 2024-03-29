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
        String query = "SELECT COUNT(*) FROM schedule WHERE scheduled_data = ? AND scheduled_hour = ? AND barber_id = ?";
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
        query = "INSERT INTO schedule (barber_id, user_id, service_id, scheduled_data, scheduled_hour, description, payment_pending) VALUES (?, ?, ?, ?, ?, ?, ?)";
        stmt = con.prepareStatement(query);
        stmt.setInt(1, agenda.getBarberId());
        stmt.setInt(2, agenda.getClienteId());
        stmt.setInt(3, agenda.getServiceId());
        stmt.setString(4, agenda.getData_agend());
        stmt.setString(5, agenda.getHora_agend());
        stmt.setString(6, agenda.getObservacao());
        stmt.setBoolean(7, true);
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
            SELECT barber.name AS barber, user.name AS client, service.cut_type AS service, service.price AS price, scheduled_data, scheduled_hour, description
            FROM schedule
            JOIN barber ON barber.id = schedule.barber_id
            JOIN user ON user.id = schedule.user_id
            JOIN service ON service.id = schedule.service_id;""");
            
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Agendamento tbAgendamento = new Agendamento();

                tbAgendamento.setBarbeiro(rs.getString("barber"));
                tbAgendamento.setCliente(rs.getString("client"));
                tbAgendamento.setServico(rs.getString("service"));
                tbAgendamento.setData_agend(rs.getString("scheduled_data"));
                tbAgendamento.setHora_agend(rs.getString("scheduled_hour"));
                tbAgendamento.setObservacao(rs.getString("description"));
                tbAgendamento.setPreco(rs.getInt("price"));
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
                SELECT barber.name AS barber, user.name AS client, service.cut_type AS service, schedule.scheduled_data, schedule.scheduled_hour, schedule.description, service.price AS price 
                FROM schedule
                JOIN barber ON barber.id = schedule.barber_id
                JOIN user ON user.id = schedule.user_id
                JOIN service ON service.id = schedule.service_id
                WHERE schedule.user_id = ?;
                """
            );
            
            stmt.setInt(1, user_id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Agendamento tbAgendamento = new Agendamento();

                tbAgendamento.setBarbeiro(rs.getString("barber"));
                tbAgendamento.setCliente(rs.getString("client"));
                tbAgendamento.setServico(rs.getString("service"));
                tbAgendamento.setData_agend(rs.getString("scheduled_data"));
                tbAgendamento.setHora_agend(rs.getString("scheduled_hour"));
                tbAgendamento.setObservacao(rs.getString("description"));
                tbAgendamento.setPreco(rs.getInt("price"));
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
            
        String sql = "UPDATE schedule SET barber_id = ?, user_id = ?, service_id = ?, scheduled_data = ?, scheduled_hour = ?, description = ? WHERE id = ?)";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1,agenda.getBarberId());
        stmt.setInt(2,agenda.getClienteId());
        stmt.setInt(3,agenda.getServiceId());
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
    
    public List<Pending> getPendingSchedulesWithPrice() throws SQLException {
        Connection con = Conexao.faz_conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pending> scheduleList = new ArrayList();

        try {
            stmt = con.prepareStatement(
                "SELECT user.name AS user_name, service.price " +
                "FROM schedule " +
                "JOIN user ON schedule.user_id = user.id " +
                "JOIN service ON schedule.service_id = service.id " +
                "WHERE schedule.payment_pending = true"
            );
            rs = stmt.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("user_name");
                int price = rs.getInt("price");

                Pending scheduleInfo = new Pending(userName, price);
                scheduleList.add(scheduleInfo);
            }

            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }

        return scheduleList;
    }
}
