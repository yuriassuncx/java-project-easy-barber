/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;


import models.Agendamento;
import models.AgendamentoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Agendamentos extends javax.swing.JFrame {

    public Agendamentos() throws SQLException {
        initComponents();
        
        readTabela();
    }
    
    public void readTabela() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtAgenda.getModel();
        modelo.setNumRows(0);
        
        AgendamentoDAO pdao = new AgendamentoDAO();
        
        for(Agendamento p: pdao.read()){
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAgenda = new javax.swing.JTable();
        LogoutIcon = new javax.swing.JLabel();
        MenuText = new javax.swing.JLabel();
        ProfileIcon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PainelButton = new javax.swing.JButton();
        MyProfileButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        SidebarBackground = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

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
        jLabel1.setText("Agendamentos");

        jtAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel1)
                .addContainerGap(224, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, 490));

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

        MyProfileButton.setBackground(new java.awt.Color(9, 9, 10));
        MyProfileButton.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(MyProfileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 190, 50));

        jLabel3.setFont(new java.awt.Font("Javanese Text", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Agendamentos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, -1, 60));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-small.png"))); // NOI18N
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        Background.setBackground(new java.awt.Color(66, 66, 71));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 0, -1, -1));

        SidebarBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sidebar.png"))); // NOI18N
        jPanel1.add(SidebarBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 286, -1));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 790, 50));

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

    private void PainelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PainelButtonActionPerformed
        setVisible(false);
        new Painel_controle().setVisible(true);
    }//GEN-LAST:event_PainelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Agendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Agendamentos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Agendamentos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel LogoutIcon;
    private javax.swing.JLabel MenuText;
    private javax.swing.JButton MyProfileButton;
    private javax.swing.JButton PainelButton;
    private javax.swing.JLabel ProfileIcon;
    private javax.swing.JLabel SidebarBackground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAgenda;
    // End of variables declaration//GEN-END:variables
}