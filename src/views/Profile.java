/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Agendamento;
import models.AgendamentoDAO;
import models.Session;


public class Profile extends javax.swing.JFrame {
    Session session = Session.getInstance();
    int user_id = session.getUserId();
    String userName = session.getUserName();
    
    public Profile() {
        initComponents();
        try {
            readTabela();
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            getCompletedSchedulesNumber();
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void readTabela() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtAgenda.getModel();
        modelo.setNumRows(0);
        
        AgendamentoDAO pdao = new AgendamentoDAO();
        
        if (user_id == 0) {
            JOptionPane.showMessageDialog(null, "Você precisa estar logado!");
            System.exit(0);
        }
        
        for(Agendamento p: pdao.readByUserId(user_id)){
            modelo.addRow(new Object[]{
                p.getBarbeiro(),
                p.getCliente(),
                p.getServico(),
                p.getData_agend(),
                p.getHora_agend(),
                p.getObservacao(),
                p.getPreco()
            });
        }
        
        jLabel6.setText(String.valueOf(jtAgenda.getRowCount()));
    }
    
    private void getCompletedSchedulesNumber() throws SQLException {
        Connection con = Conexao.faz_conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int count = 0;
    
        try {
            stmt = con.prepareStatement(
        """
                SELECT COUNT(*) AS total
                FROM schedule
                WHERE user_id = ? AND payment_pending = false;""");
            
            stmt.setInt(1, user_id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                count = rs.getInt("total");
            }
             
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
        
        jLabel7.setText(String.valueOf(count));
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
        LogoutIcon = new javax.swing.JLabel();
        MenuText = new javax.swing.JLabel();
        ProfileIcon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NewScheduleButton1 = new javax.swing.JButton();
        UserSchedulesButton1 = new javax.swing.JButton();
        MyProfileButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAgenda = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        SidebarBackground = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout-icon.png"))); // NOI18N
        jPanel1.add(LogoutIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, -1, -1));

        MenuText.setBackground(new java.awt.Color(255, 255, 255));
        MenuText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MenuText.setForeground(new java.awt.Color(255, 255, 255));
        MenuText.setText("Menu");
        jPanel1.add(MenuText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        ProfileIcon.setForeground(new java.awt.Color(153, 153, 153));
        ProfileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-button-icon.png"))); // NOI18N
        ProfileIcon.setText("Profile");
        jPanel1.add(ProfileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 40, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(userName);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 586, 110, 20));

        NewScheduleButton1.setBackground(new java.awt.Color(9, 9, 10));
        NewScheduleButton1.setForeground(new java.awt.Color(255, 255, 255));
        NewScheduleButton1.setText("Fazer um novo agendamento");
        NewScheduleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewScheduleButton1ActionPerformed(evt);
            }
        });
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

        MyProfileButton.setBackground(new java.awt.Color(9, 9, 10));
        MyProfileButton.setForeground(new java.awt.Color(255, 255, 255));
        MyProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyProfileButtonActionPerformed(evt);
            }
        });
        jPanel1.add(MyProfileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 190, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Histórico");

        jtAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Barbeiro", "Cliente", "Serviço", "Data", "Hora", "Observação", "Preço (R$)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtAgenda);

        jButton1.setText("Avaliar barbeiro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 730, 240));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ProfileIcon.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Nome: " + userName);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Agendamentos");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Concluídos");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(151, 151, 151))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 400, 260));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-small.png"))); // NOI18N
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        SidebarBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sidebar.png"))); // NOI18N
        jPanel1.add(SidebarBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 286, -1));

        jPanel2.setBackground(new java.awt.Color(9, 9, 10));

        Title.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("Meu Perfil");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(637, Short.MAX_VALUE)
                .addComponent(Title)
                .addGap(297, 297, 297))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Title)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 60));

        Background.setBackground(new java.awt.Color(66, 66, 71));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 0, -1, -1));

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

    private void MyProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyProfileButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MyProfileButtonActionPerformed

    private void NewScheduleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewScheduleButton1ActionPerformed
        setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_NewScheduleButton1ActionPerformed

    private void UserSchedulesButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserSchedulesButton1ActionPerformed
        setVisible(false);
        try {
            new MeusAgendamentos().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UserSchedulesButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int selectedRow = jtAgenda.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) jtAgenda.getModel();

            String barbeiro = model.getValueAt(selectedRow, 0).toString();

            Feedbacks feedbacks = new Feedbacks(barbeiro);
            setVisible(false);
            feedbacks.setVisible(true);
        } catch(Exception error) {
            JOptionPane.showMessageDialog(null, "Você precisa selecionar um agendamento!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel LogoutIcon;
    private javax.swing.JLabel MenuText;
    private javax.swing.JButton MyProfileButton;
    private javax.swing.JButton NewScheduleButton1;
    private javax.swing.JLabel ProfileIcon;
    private javax.swing.JLabel SidebarBackground;
    private javax.swing.JLabel Title;
    private javax.swing.JButton UserSchedulesButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAgenda;
    // End of variables declaration//GEN-END:variables
}
