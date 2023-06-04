package views;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Service;
import models.ServiceDAO;


public class Serviços extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Serviços() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtAgenda.getModel();
        
        try {
            readServicesTable();
        } catch (SQLException ex) {
            Logger.getLogger(Serviços.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void readServicesTable() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtAgenda.getModel();
        modelo.setNumRows(0);
        
        ServiceDAO pdao = new ServiceDAO();
        
        for(Service s: pdao.read()){
            modelo.addRow(new Object[] {
                s.getId(),
                s.getService(),
                s.getPrice()
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ProfileIcon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAgenda = new javax.swing.JTable();
        ServiceLabel = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        ServiceTextField = new javax.swing.JTextField();
        PriceTextField = new javax.swing.JTextField();
        ConfirmButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        PainelButton = new javax.swing.JButton();
        MyProfileButton = new javax.swing.JButton();
        LogoutIcon = new javax.swing.JLabel();
        MenuText = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        SidebarBackground = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Javanese Text", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciamento de Serviços");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, 60));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EasyBarber");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 586, 110, 20));

        ProfileIcon.setForeground(new java.awt.Color(153, 153, 153));
        ProfileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-button-icon.png"))); // NOI18N
        ProfileIcon.setText("Profile");
        jPanel1.add(ProfileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 40, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jtAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Serviço", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtAgenda);

        ServiceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ServiceLabel.setForeground(new java.awt.Color(255, 255, 255));
        ServiceLabel.setText("Serviço:");

        PriceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        PriceLabel.setText("Preço:");

        ConfirmButton.setText("Adicionar");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        RemoveButton.setText("Remover");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ServiceLabel)
                    .addComponent(ServiceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PriceLabel)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(ConfirmButton)
                        .addGap(18, 18, 18)
                        .addComponent(RemoveButton)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(ServiceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ServiceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(PriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 640, 490));

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

        LogoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout-icon.png"))); // NOI18N
        jPanel1.add(LogoutIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, -1, -1));

        MenuText.setBackground(new java.awt.Color(255, 255, 255));
        MenuText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MenuText.setForeground(new java.awt.Color(255, 255, 255));
        MenuText.setText("Menu");
        jPanel1.add(MenuText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-small.png"))); // NOI18N
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

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
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 700, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PainelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PainelButtonActionPerformed
        setVisible(false);
        new Painel_controle().setVisible(true);
    }//GEN-LAST:event_PainelButtonActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        Service service = new Service();
        ServiceDAO serviceDao = new ServiceDAO();
        
        if (ServiceTextField.getText().isEmpty() || PriceTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente!");
            return;
        }
        
        service.setService(ServiceTextField.getText());
        service.setPrice(Integer.parseInt(PriceTextField.getText()));
        
        try {
            serviceDao.create(service);
            
            ServiceTextField.setText("");
            PriceTextField.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                readServicesTable();
            } catch (SQLException ex) {
                Logger.getLogger(Gerenciamento_barbeiro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ConfirmButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Serviços.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Serviços.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Serviços.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Serviços.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Serviços().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel LogoutIcon;
    private javax.swing.JLabel MenuText;
    private javax.swing.JButton MyProfileButton;
    private javax.swing.JButton PainelButton;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JTextField PriceTextField;
    private javax.swing.JLabel ProfileIcon;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JLabel ServiceLabel;
    private javax.swing.JTextField ServiceTextField;
    private javax.swing.JLabel SidebarBackground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtAgenda;
    // End of variables declaration//GEN-END:variables
}
