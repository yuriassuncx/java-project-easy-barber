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
import models.FeedbacksDAO;
import models.Session;


public class Feedbacks extends javax.swing.JFrame {
    Session session = Session.getInstance();
    int user_id = session.getUserId();
    int barber_id;
    String userName = session.getUserName();

    /**
     * Creates new form Home
     * @param barbeiro
     */
    public Feedbacks(String barbeiro) {
        initComponents();
        
        jLabel3.setText(barbeiro);
    }

    private Feedbacks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void getIdBarbeiroPorNome(String nomeBarbeiro) throws SQLException {
        Connection con = Conexao.faz_conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = Conexao.faz_conexao();
            String sql = "SELECT id FROM barber WHERE name = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nomeBarbeiro);
            rs = stmt.executeQuery();

            if (rs.next()) {
                barber_id = rs.getInt(1); // Obtém o valor do primeiro campo (id)
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao obter o ID do barbeiro", ex);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        LogoutIcon = new javax.swing.JLabel();
        MenuText = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        NewScheduleButton1 = new javax.swing.JButton();
        UserSchedulesButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ProfileIcon = new javax.swing.JLabel();
        MyProfileButton = new javax.swing.JButton();
        SidebarBackground = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                agendamento(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Feedbacks");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ProfileIcon.png"))); // NOI18N
        jLabel3.setText("<barber>");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Você gostou da forma pela qual foi atentido?");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Sim");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Não");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Barbeiro:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("O que mais te agradou?");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Pontualidade");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Gentileza");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("Habilidade");

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setText("Rapidez");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Caso seja outro motivo, por favor, comente:");

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(221, 221, 221))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2))
                    .addComponent(jLabel4))
                .addGap(22, 22, 22))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton6))
                            .addComponent(jLabel6)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, 480));

        LogoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout-icon.png"))); // NOI18N
        jPanel1.add(LogoutIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, -1, -1));

        MenuText.setBackground(new java.awt.Color(255, 255, 255));
        MenuText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MenuText.setForeground(new java.awt.Color(255, 255, 255));
        MenuText.setText("Menu");
        jPanel1.add(MenuText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-small.png"))); // NOI18N
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

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

        SidebarBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sidebar.png"))); // NOI18N
        jPanel1.add(SidebarBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 286, -1));

        jPanel2.setBackground(new java.awt.Color(9, 9, 10));

        Title.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("Tela de Feedback");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(540, Short.MAX_VALUE)
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

    private void agendamento(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_agendamento
        // TODO add your handling code here:
    }//GEN-LAST:event_agendamento

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

    private void MyProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyProfileButtonActionPerformed
        setVisible(false);
        new Profile().setVisible(true);
    }//GEN-LAST:event_MyProfileButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FeedbacksDAO feedbacksDao = new FeedbacksDAO();
        boolean selectedOption = false;
        String avaliacao = "";
        
        if (buttonGroup1.getSelection() != null) {
            if (buttonGroup1.getSelection().equals(jRadioButton1.getModel())) {
                selectedOption = true;
            } else {
                selectedOption = false;
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma opção foi selecionada");
        }
        
        if (buttonGroup2.getSelection() != null) {
            if (buttonGroup2.getSelection().equals(jRadioButton3.getModel())) {
                avaliacao = "Pontualidade";
            } else if (buttonGroup2.getSelection().equals(jRadioButton4.getModel())) {
                avaliacao = "Gentileza";
            } else if (buttonGroup2.getSelection().equals(jRadioButton5.getModel())) {
                avaliacao = "Habilidade";
            } else if (buttonGroup2.getSelection().equals(jRadioButton6.getModel())) {
                avaliacao = "Rapidez";
            } else {
                avaliacao = jTextField1.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma opção foi selecionada");
        }
        
        try {
            getIdBarbeiroPorNome(jLabel3.getText());
            System.out.println("barber_id: " + barber_id);
        } catch (SQLException ex) {
            Logger.getLogger(Feedbacks.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            feedbacksDao.createFeedback(user_id, barber_id, selectedOption, avaliacao);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar feedback: " + ex.getMessage());
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
            java.util.logging.Logger.getLogger(Feedbacks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Feedbacks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Feedbacks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Feedbacks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Feedbacks().setVisible(true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
