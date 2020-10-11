package projet_tda_partie_2;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime ;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Acheteur extends javax.swing.JFrame {
    
    public Acheteur(){
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        marque = new javax.swing.JComboBox<>();
        ecran = new javax.swing.JComboBox<>();
        ram = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        processeur = new javax.swing.JComboBox<>();
        disque_dur = new javax.swing.JComboBox<>();
        prix_min = new javax.swing.JComboBox<>();
        prix_max = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Marque", "Processeur", "RAM", "Disque dur", "ecran", "prix"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Lancer la recherche");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Marque");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 11, 58, 35));

        marque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hp", "acer", "toshiba", "dell", "apple", "asus", "lenovo", "anyone" }));
        marque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marqueActionPerformed(evt);
            }
        });
        jPanel1.add(marque, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 11, 167, 35));

        ecran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10.5", "11.6", "12.3", "13.3", "Anyone" }));
        jPanel1.add(ecran, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 223, 167, 35));

        ram.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2Go", "4Go", "6Go", "8Go", "10Go", "12Go", "anyone" }));
        jPanel1.add(ram, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 117, 167, 35));

        jLabel1.setText("Processeur");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 64, 58, 35));

        jLabel2.setText("RAM");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 117, 58, 35));

        processeur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "i3", "i5", "i7", "i9", "anyone" }));
        jPanel1.add(processeur, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 64, 167, 35));

        disque_dur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500Go", "1000Go", "1500Go", "2000Go", "Anyone" }));
        jPanel1.add(disque_dur, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 167, 35));

        prix_min.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10000", "20000", "30000", "50000", "70000", "90000", "150000", "Anyone" }));
        jPanel1.add(prix_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 276, 167, 35));

        prix_max.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10000", "20000", "30000", "50000", "70000", "90000", "150000", "Anyone" }));
        jPanel1.add(prix_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 329, 167, 35));

        jLabel3.setText("Disque dur");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 170, 58, 35));

        jLabel4.setText("Ecran");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 58, 35));

        jLabel5.setText("Prix Min");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 58, 35));

        jLabel7.setText("Prix Max");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 58, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void marqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marqueActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.GUI, "true");
        ContainerController cc = rt.createMainContainer(p);
        
        String marque = (String) Acheteur.marque.getSelectedItem();
        String agentAnnexe = null ;
        if (marque.equals("hp"))
            agentAnnexe = "projet_tda_partie_2.AgentAnnexeHP"; 
        else if (marque.equals("acer"))
            agentAnnexe = "projet_tda_partie_2.AgentAnnexeAcer" ;
        else if (marque.equals("toshiba"))
            agentAnnexe = "projet_tda_partie_2.AgentAnnexeToshiba" ;
        else if (marque.equals("dell"))
            agentAnnexe = "projet_tda_partie_2.AgentAnnexeDell" ;
        else if (marque.equals("apple"))
            agentAnnexe = "projet_tda_partie_2.AgentAnnexeApple" ;
        else if (marque.equals("asus"))
            agentAnnexe = "projet_tda_partie_2.AgentAnnexeAsus" ;
        else if (marque.equals("lenovo"))
            agentAnnexe = "projet_tda_partie_2.AgentAnnexeLenovo" ;
        AgentController ac ;
        try {
            ac = cc.createNewAgent("principal", "projet_tda_partie_2.AgentPrincipal", null) ;
            ac.start();
            ac = cc.createNewAgent("annexe", agentAnnexe , null) ;
            ac.start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Acheteur.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Acheteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acheteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acheteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acheteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acheteur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> disque_dur;
    public static javax.swing.JComboBox<String> ecran;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable2;
    public static javax.swing.JComboBox<String> marque;
    public static javax.swing.JComboBox<String> prix_max;
    public static javax.swing.JComboBox<String> prix_min;
    public static javax.swing.JComboBox<String> processeur;
    public static javax.swing.JComboBox<String> ram;
    // End of variables declaration//GEN-END:variables

}
