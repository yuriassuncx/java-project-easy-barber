/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Painel_controle extends javax.swing.JFrame {

    /**
     * Creates new form Painel_controle
     */
    public Painel_controle() {
        initComponents();
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
        PainelButton = new javax.swing.JButton();
        ServicePanelButton = new javax.swing.JButton();
        BarberPanelButton = new javax.swing.JButton();
        SchedulesPanelButton = new javax.swing.JButton();
        FinnancesPanelButton = new javax.swing.JButton();
        MyProfileButton = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        SidebarBackground = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

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
        jLabel2.setText("EasyBarber");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 586, 110, 20));

        PainelButton.setBackground(new java.awt.Color(9, 9, 10));
        PainelButton.setForeground(new java.awt.Color(255, 255, 255));
        PainelButton.setText("Painel de Controle");
        PainelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PainelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(PainelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 220, 40));

        ServicePanelButton.setBackground(new java.awt.Color(9, 9, 10));
        ServicePanelButton.setForeground(new java.awt.Color(255, 255, 255));
        ServicePanelButton.setText("Gerenciar Serviço");
        ServicePanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServicePanelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ServicePanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 220, 40));

        BarberPanelButton.setBackground(new java.awt.Color(9, 9, 10));
        BarberPanelButton.setForeground(new java.awt.Color(255, 255, 255));
        BarberPanelButton.setText("Gerenciar Barbeiro");
        BarberPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarberPanelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(BarberPanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 220, 40));

        SchedulesPanelButton.setBackground(new java.awt.Color(9, 9, 10));
        SchedulesPanelButton.setForeground(new java.awt.Color(255, 255, 255));
        SchedulesPanelButton.setText("Agendamentos");
        SchedulesPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchedulesPanelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SchedulesPanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 220, 40));

        FinnancesPanelButton.setBackground(new java.awt.Color(9, 9, 10));
        FinnancesPanelButton.setForeground(new java.awt.Color(255, 255, 255));
        FinnancesPanelButton.setText("Finanças");
        FinnancesPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinnancesPanelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(FinnancesPanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 220, 40));

        MyProfileButton.setBackground(new java.awt.Color(9, 9, 10));
        MyProfileButton.setForeground(new java.awt.Color(255, 255, 255));
        MyProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyProfileButtonActionPerformed(evt);
            }
        });
        jPanel1.add(MyProfileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 190, 50));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-small.png"))); // NOI18N
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel1.setFont(new java.awt.Font("Javanese Text", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Painel de Controle");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 180, 60));

        Background.setBackground(new java.awt.Color(66, 66, 71));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 0, -1, -1));

        SidebarBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sidebar.png"))); // NOI18N
        jPanel1.add(SidebarBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 286, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 790, 50));

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

    private void PainelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PainelButtonActionPerformed
        
    }//GEN-LAST:event_PainelButtonActionPerformed

    private void ServicePanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServicePanelButtonActionPerformed
        setVisible(false);
        new Serviços().setVisible(true);
    }//GEN-LAST:event_ServicePanelButtonActionPerformed

    private void BarberPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarberPanelButtonActionPerformed
        setVisible(false);
        new Gerenciamento_barbeiro().setVisible(true);
    }//GEN-LAST:event_BarberPanelButtonActionPerformed

    private void FinnancesPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinnancesPanelButtonActionPerformed
        setVisible(false);
        new Finanças().setVisible(true);
    }//GEN-LAST:event_FinnancesPanelButtonActionPerformed

    private void SchedulesPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchedulesPanelButtonActionPerformed
        setVisible(false);
        try {
            new Agendamentos().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Painel_controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SchedulesPanelButtonActionPerformed

    private void MyProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyProfileButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MyProfileButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Painel_controle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Painel_controle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Painel_controle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Painel_controle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Painel_controle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton BarberPanelButton;
    private javax.swing.JButton FinnancesPanelButton;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel LogoutIcon;
    private javax.swing.JLabel MenuText;
    private javax.swing.JButton MyProfileButton;
    private javax.swing.JButton PainelButton;
    private javax.swing.JLabel ProfileIcon;
    private javax.swing.JButton SchedulesPanelButton;
    private javax.swing.JButton ServicePanelButton;
    private javax.swing.JLabel SidebarBackground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
