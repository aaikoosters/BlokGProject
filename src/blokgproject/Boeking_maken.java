/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokgproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Aaik
 */
public class Boeking_maken extends javax.swing.JFrame {

    private final DefaultTableModel table = new DefaultTableModel();

    /**
     * Creates new form Locatie_main
     */
    public Boeking_maken() {
        initComponents();
        setLocationRelativeTo(null);

        locatieTable.setModel(table);
        String[] Kolomnaam = {"id", "Birthdate", "Seks", "IBAN", "Date", "Reis"};
        
        table.setColumnIdentifiers(Kolomnaam);
        table.setRowCount(0);
        table.setColumnCount(6);

        tabelVullen();
        tableEigenschappen();
    }
    
    public void setLocatieToernooi()
    {
        
    }
    public String removeLastChar(String s) {
        if (s != null && s.length() > 0) {
            if (s.substring(s.length() - 1).equals(" ")) {
                return s.substring(0, s.length() - 1);
            } else {
                return s;
            }
        }
        return s;
    }
    public void tabelVullen() {
     
        String id, locatie, duur, hotel, transport, prijs;
        
        try {
            SQL_connect.doConnect();
            
            String prepSqlStatement = "select * from boeking;";
                PreparedStatement stat = SQL_connect.getConnection().prepareStatement(prepSqlStatement);
//                stat.setString(1, "%" + zoekVeld + "%");
//                stat.setString(2, "%" + zoekVeld + "%");
                ResultSet result = stat.executeQuery();

                // rijen
                int i = 0;

                while (result.next()) {
                    i++;

                }
                table.setRowCount(i);
                result.beforeFirst();

                int d = 0;
                while (result.next()) {
                    //Stop de variable in een rs
                    id = result.getString("boeking_id");
                    locatie = result.getString("geboortedatum");
                    duur = result.getString("geslacht");
                    hotel = result.getString("iban");
                    transport = result.getString("datum");
                    prijs = result.getString("reis_id");
                    

                    // vul vervolgens in de tabel de waardes in als volgt: resultset, aantal, plaats
                    table.setValueAt(id, d, 0);
                    table.setValueAt(locatie, d, 1);
                    table.setValueAt(duur, d, 2);
                    table.setValueAt(hotel, d, 3);
                    table.setValueAt(transport, d, 4);
                    table.setValueAt(prijs, d, 5);
                    // verhoog aantal totdat alles was je hebt opgevraagd is geweest
                    d++;

                }

                result.last();
                System.out.println(result.getRow());

                result.close();
                stat.close();
                System.out.println("gaat goed");
        } catch (Exception e) {
            System.out.println("ergens gaat het fou: " + e);
        }
        
    }
    
    /*public void tabelVullen() {

        // TODO add your handling code here:
        Sql_connect.doConnect();
        // declareer de variable voor in de rs
        String id;
        String naam;
        String plaats;
        String Straat;
        String Huisnummer;
        String Telefoonnummer;

        try {
            // connect 
            Sql_connect.doConnect();

            String zoekVeld = removeLastChar(zoekTxt.getText());

            
                // statement maken
                String prepSqlStatement = "select * from locatie where Naam_locatie like ? OR Plaats like ?;";
                PreparedStatement stat = Sql_connect.getConnection().prepareStatement(prepSqlStatement);
                stat.setString(1, "%" + zoekVeld + "%");
                stat.setString(2, "%" + zoekVeld + "%");
                ResultSet result = stat.executeQuery();

                // rijen
                int i = 0;

                while (result.next()) {
                    i++;

                }
                table.setRowCount(i);
                result.beforeFirst();

                int d = 0;
                while (result.next()) {
                    //Stop de variable in een rs
                    id = result.getString("Id_locatie");
                    naam = result.getString("Naam_locatie");
                    plaats = result.getString("plaats");
                    Straat = result.getString("Straat");
                    Huisnummer = result.getString("Huisnummer");
                    Telefoonnummer = result.getString("Telefoonnummer");

                    // vul vervolgens in de tabel de waardes in als volgt: resultset, aantal, plaats
                    table.setValueAt(id, d, 0);
                    table.setValueAt(naam, d, 1);
                    table.setValueAt(plaats, d, 2);
                    table.setValueAt(Straat, d, 3);
                    table.setValueAt(Huisnummer, d, 4);
                    table.setValueAt(Telefoonnummer, d, 5);
                    // verhoog aantal totdat alles was je hebt opgevraagd is geweest
                    d++;

                }

                result.last();
                System.out.println(result.getRow());

                result.close();
                stat.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }*/

    private void tableEigenschappen() {

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
//        locatieTable.getColumn("Locatie id").setCellRenderer(rightRenderer);
//        locatieTable.getColumn("Naam").setCellRenderer(rightRenderer);
//        locatieTable.getColumn("Plaats").setCellRenderer(rightRenderer);
//        locatieTable.getColumn("Straat").setCellRenderer(rightRenderer);
//        locatieTable.getColumn("Huisnummer").setCellRenderer(rightRenderer);
//        locatieTable.getColumn("Telefoonnummer").setCellRenderer(rightRenderer);

        TableCellRenderer rendererFromHeader = locatieTable.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        locatieTable = new javax.swing.JTable();
        terugButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jButton2.setText("Terug");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        locatieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Locatie Id", "Naam", "Plaats", "Straat", "Huisnummer", "Telefoonnumer", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        locatieTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locatieTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(locatieTable);

        terugButton.setText("Terug");
        terugButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terugButtonActionPerformed(evt);
            }
        });

        jButton3.setText("Opslaan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(terugButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(terugButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void locatieTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locatieTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_locatieTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void terugButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terugButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Home home = new Home();
        home.setVisible(rootPaneCheckingEnabled);
        
        
    }//GEN-LAST:event_terugButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Boeking_maken maken = new Boeking_maken();
        maken.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Boeking_maken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Boeking_maken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Boeking_maken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Boeking_maken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Boeking_maken().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable locatieTable;
    private javax.swing.JButton terugButton;
    // End of variables declaration//GEN-END:variables
}
