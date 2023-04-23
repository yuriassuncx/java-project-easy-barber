package views;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import models.Agendamento;
import models.AgendamentoDAO;
import models.Session;


public class Home extends javax.swing.JFrame {
    Session session = Session.getInstance();
    int user_id = session.getUserId();
    String userName = session.getUserName();
    
    public Home() {
        initComponents();
        getAllBarbers();
        getAllServices();
        getDates();
    }
    
    private void getAllBarbers() {
        try {
            Connection con = Conexao.faz_conexao();
            
            String sql = "SELECT * FROM barber";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                BarberComboBox.addItem(rs.getString(2));
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não há barbeiro disponível!");
        }
    }
    
    private void getAllServices() {
        try {
            Connection con = Conexao.faz_conexao();
            
            String sql = "SELECT * FROM service";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                ServiceComboBox.addItem(rs.getString(2));
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não há serviço disponível!");
        }
    }
    
    private void getDates() {
        String[] datas = new String[32];
        
        Calendar calendar = Calendar.getInstance();
        
        datas[0] = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
        
        for (int i = 0; i <= 31; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            datas[i] = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
        }
        
        // Limpa o ComboBox de horários antes de adicioná-los novamente
        DateComboBox.removeAllItems();
        
        for (String data : datas) {
            DateComboBox.addItem(data);
        }
    }   
    
    private void getAvailableHours() throws SQLException {       
        // Horários disponíveis das 8h às 23h
        String[] horarios = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};

        try {
            Connection con = Conexao.faz_conexao();

            String sql = "SELECT hora_agend FROM agendamento WHERE data_agend = ? AND barber_id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, (String) DateComboBox.getSelectedItem());
            stmt.setInt(2, BarberComboBox.getSelectedIndex());

            ResultSet rs = stmt.executeQuery();

            // Cria uma nova lista de horários disponíveis
            List<String> horariosDisponiveis = new ArrayList(Arrays.asList(horarios));

            // Percorre os horários já agendados para removê-los dos horários disponíveis
            while (rs.next()) {
                String horaAgendada = rs.getString("hora_agend");
                horariosDisponiveis.remove(horaAgendada);
            }

            // Limpa o ComboBox de horários antes de adicioná-los novamente
            HourComboBox.removeAllItems();

            // Adiciona os horários disponíveis no ComboBox
            for (String horario : horariosDisponiveis) {
                HourComboBox.addItem(horario);
            }

            stmt.close();
            con.close();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao buscar horários disponíveis para agendamento", ex);
        }
    }
    
    private void alterCutValueByServiceId() {        
        String serviceName = (String) ServiceComboBox.getSelectedItem();
        
        try {
            Connection con = Conexao.faz_conexao();
            
            String sql = "SELECT * FROM service WHERE cut_type=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, serviceName);
            
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                cutValueLabel.setText(rs.getString(3));
            } else {
                cutValueLabel.setText("0");
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro aconteceu!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        BarberComboBox = new javax.swing.JComboBox<>();
        HourComboBox = new javax.swing.JComboBox<>();
        DateComboBox = new javax.swing.JComboBox<>();
        ServiceComboBox = new javax.swing.JComboBox<>();
        ScissorsIcon = new javax.swing.JLabel();
        EditIcon = new javax.swing.JLabel();
        ClipboardIcon = new javax.swing.JLabel();
        WatchIcon = new javax.swing.JLabel();
        Obs = new javax.swing.JLabel();
        ObsTextArea = new javax.swing.JTextArea();
        cutValueLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        MenuText = new javax.swing.JLabel();
        NewScheduleButton1 = new javax.swing.JButton();
        UserSchedulesButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ProfileIcon = new javax.swing.JLabel();
        MyProfileButton = new javax.swing.JButton();
        LogoutIcon = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        SidebarBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(9, 9, 10));

        Title.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("Realize um agendamento");

        BarberComboBox.setBackground(new java.awt.Color(66, 66, 71));
        BarberComboBox.setForeground(new java.awt.Color(255, 255, 255));
        BarberComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolher um barbeiro" }));
        BarberComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BarberComboBoxMouseClicked(evt);
            }
        });
        BarberComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarberComboBoxActionPerformed(evt);
            }
        });

        HourComboBox.setBackground(new java.awt.Color(66, 66, 71));
        HourComboBox.setForeground(new java.awt.Color(255, 255, 255));
        HourComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolher um horário" }));
        HourComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HourComboBoxMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HourComboBoxMousePressed(evt);
            }
        });
        HourComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HourComboBoxActionPerformed(evt);
            }
        });

        DateComboBox.setBackground(new java.awt.Color(66, 66, 71));
        DateComboBox.setForeground(new java.awt.Color(255, 255, 255));
        DateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolher uma data" }));
        DateComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateComboBoxMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DateComboBoxMousePressed(evt);
            }
        });
        DateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateComboBoxActionPerformed(evt);
            }
        });

        ServiceComboBox.setBackground(new java.awt.Color(66, 66, 71));
        ServiceComboBox.setForeground(new java.awt.Color(255, 255, 255));
        ServiceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolher um serviço" }));
        ServiceComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ServiceComboBoxMouseClicked(evt);
            }
        });
        ServiceComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServiceComboBoxActionPerformed(evt);
            }
        });

        ScissorsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/scissors-icon.png"))); // NOI18N

        EditIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.png"))); // NOI18N

        ClipboardIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard-icon.png"))); // NOI18N

        WatchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/watch-icon.png"))); // NOI18N

        Obs.setBackground(new java.awt.Color(141, 141, 153));
        Obs.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Obs.setForeground(new java.awt.Color(255, 255, 255));
        Obs.setText("Observação:");

        ObsTextArea.setBackground(new java.awt.Color(66, 66, 71));
        ObsTextArea.setColumns(20);
        ObsTextArea.setForeground(new java.awt.Color(255, 255, 255));
        ObsTextArea.setRows(5);

        cutValueLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cutValueLabel.setForeground(new java.awt.Color(255, 255, 255));
        cutValueLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dollar-sign-icon.png"))); // NOI18N
        cutValueLabel.setText("0,00");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agendar");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ScissorsIcon)
                                .addGap(18, 18, 18)
                                .addComponent(BarberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ClipboardIcon)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(Obs))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(DateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(EditIcon)
                                .addGap(18, 18, 18)
                                .addComponent(ServiceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(WatchIcon)
                                .addGap(18, 18, 18)
                                .addComponent(HourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(96, 96, 96))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(ObsTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(107, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Title)
                .addGap(179, 179, 179))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cutValueLabel)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Title)
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BarberComboBox)
                        .addComponent(ScissorsIcon))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ServiceComboBox)
                        .addComponent(EditIcon)))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HourComboBox)
                    .addComponent(ClipboardIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(WatchIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateComboBox))
                .addGap(27, 27, 27)
                .addComponent(Obs)
                .addGap(18, 18, 18)
                .addComponent(ObsTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cutValueLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 720, 570));

        MenuText.setBackground(new java.awt.Color(255, 255, 255));
        MenuText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MenuText.setForeground(new java.awt.Color(255, 255, 255));
        MenuText.setText("Menu");
        jPanel1.add(MenuText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        NewScheduleButton1.setBackground(new java.awt.Color(9, 9, 10));
        NewScheduleButton1.setForeground(new java.awt.Color(255, 255, 255));
        NewScheduleButton1.setText("Fazer um novo agendamento");
        jPanel1.add(NewScheduleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 220, 40));

        UserSchedulesButton1.setBackground(new java.awt.Color(9, 9, 10));
        UserSchedulesButton1.setForeground(new java.awt.Color(255, 255, 255));
        UserSchedulesButton1.setText("Meus Agendamentos");
        UserSchedulesButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserSchedulesButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(UserSchedulesButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 220, 40));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(userName);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 586, 110, 20));

        ProfileIcon.setForeground(new java.awt.Color(153, 153, 153));
        ProfileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-button-icon.png"))); // NOI18N
        ProfileIcon.setText("Profile");
        jPanel1.add(ProfileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 40, -1));

        MyProfileButton.setBackground(new java.awt.Color(9, 9, 10));
        MyProfileButton.setForeground(new java.awt.Color(255, 255, 255));
        MyProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyProfileButtonActionPerformed(evt);
            }
        });
        jPanel1.add(MyProfileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 190, 50));

        LogoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout-icon.png"))); // NOI18N
        jPanel1.add(LogoutIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, -1, -1));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-small.png"))); // NOI18N
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        Background.setBackground(new java.awt.Color(66, 66, 71));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 0, -1, -1));

        SidebarBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sidebar.png"))); // NOI18N
        jPanel1.add(SidebarBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 286, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BarberComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarberComboBoxActionPerformed
        if (DateComboBox.getSelectedItem() != null || BarberComboBox.getSelectedItem() != null) {
            try {
                getAvailableHours();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BarberComboBoxActionPerformed

    private void ServiceComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServiceComboBoxActionPerformed
        alterCutValueByServiceId();
    }//GEN-LAST:event_ServiceComboBoxActionPerformed

    private void BarberComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarberComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BarberComboBoxMouseClicked

    private void ServiceComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ServiceComboBoxMouseClicked

    }//GEN-LAST:event_ServiceComboBoxMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Agendamento agenda = new Agendamento();
        AgendamentoDAO dao = new AgendamentoDAO();
        
        if (user_id == 0) {
            JOptionPane.showMessageDialog(null, "Você precisa estar logado para agendar!");
            
            return;
        }
        
        if ((String) BarberComboBox.getSelectedItem() == "Escolher um barbeiro") {
            JOptionPane.showMessageDialog(null, "Você precisa escolher um barbeiro!");
            
            return;
        }
        
        if ((String) ServiceComboBox.getSelectedItem() == "Escolher um serviço") {
            JOptionPane.showMessageDialog(null, "Você precisa escolher um serviço!");
            
            return;
        }
        
        agenda.setBarberId(BarberComboBox.getSelectedIndex());
        agenda.setClienteId(user_id);
        agenda.setServico((String) ServiceComboBox.getSelectedItem());
        agenda.setData_agend((String) DateComboBox.getSelectedItem());
        agenda.setHora_agend((String) HourComboBox.getSelectedItem());
        agenda.setObservacao(ObsTextArea.getText());
        agenda.setPreco(Integer.parseInt(cutValueLabel.getText()));
        
        try {
            dao.create(agenda);
            
            BarberComboBox.setSelectedItem(null);
            ServiceComboBox.setSelectedItem(null);
            DateComboBox.setSelectedItem(null);
            HourComboBox.setSelectedItem(null);
            ObsTextArea.setText("");
            cutValueLabel.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UserSchedulesButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserSchedulesButton1ActionPerformed
        setVisible(false);
        try {
            new MeusAgendamentos().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UserSchedulesButton1ActionPerformed

    private void MyProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyProfileButtonActionPerformed
        setVisible(false);
        new Profile().setVisible(true);
    }//GEN-LAST:event_MyProfileButtonActionPerformed

    private void HourComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HourComboBoxActionPerformed
        
    }//GEN-LAST:event_HourComboBoxActionPerformed

    private void HourComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HourComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_HourComboBoxMouseClicked

    private void HourComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HourComboBoxMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_HourComboBoxMousePressed

    private void DateComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DateComboBoxMouseClicked

    private void DateComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateComboBoxMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateComboBoxMousePressed

    private void DateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateComboBoxActionPerformed
        if (DateComboBox.getSelectedItem() != null || BarberComboBox.getSelectedItem() != null) {
            try {
                getAvailableHours();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DateComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JComboBox<String> BarberComboBox;
    private javax.swing.JLabel ClipboardIcon;
    private javax.swing.JComboBox<String> DateComboBox;
    private javax.swing.JLabel EditIcon;
    private javax.swing.JComboBox<String> HourComboBox;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel LogoutIcon;
    private javax.swing.JLabel MenuText;
    private javax.swing.JButton MyProfileButton;
    private javax.swing.JButton NewScheduleButton1;
    private javax.swing.JLabel Obs;
    private javax.swing.JTextArea ObsTextArea;
    private javax.swing.JLabel ProfileIcon;
    private javax.swing.JLabel ScissorsIcon;
    private javax.swing.JComboBox<String> ServiceComboBox;
    private javax.swing.JLabel SidebarBackground;
    private javax.swing.JLabel Title;
    private javax.swing.JButton UserSchedulesButton1;
    private javax.swing.JLabel WatchIcon;
    private javax.swing.JLabel cutValueLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
