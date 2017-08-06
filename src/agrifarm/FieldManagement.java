/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IP
 */
public class FieldManagement extends javax.swing.JFrame {

    private static final String farmDB = "farmDB.ser";
    private static final String fieldDB = "fieldDB.ser";
    
    Vector fieldVector = new Vector<Field>();
    String farmId, farmName;
    private String assignFieldId, assignFieldName;
    /**
     * Creates new form AddField
     */
    public FieldManagement() {
        initComponents();
    }
    
    public FieldManagement(String Id, String name) {
        this.farmId = Id;
        this.farmName = name;
        initComponents();
        getFields();
        searchFields(Id);
    }
    
    private void enableButtons() {
        btnAddPlot.setEnabled(true);
        btnViewPlots.setEnabled(true);
    }
    public void setFieldsTable(Vector<Field> vb)
    {
        DefaultTableModel fieldTable = new DefaultTableModel();
        Vector columnName = new Vector();
        columnName.addElement("ID");
        columnName.addElement("Field Name");
        columnName.addElement("Location");
        columnName.addElement("Farm Name");
        fieldTable.setColumnIdentifiers(columnName);
        try
        {
            for(int i=0;i<vb.size();i++)
            {
                Field ff = (Field)vb.get(i);
                Vector tableData = new Vector();
                tableData.addElement(ff.getFarmId());
                tableData.addElement(ff.getName());
                tableData.addElement(ff.getLocation());
                tableData.addElement(ff.getFarmName());
                
                fieldTable.addRow(tableData);
            }
            tblFields.setModel(fieldTable);
        }
        catch(Exception e)
        {}
    }
    
    private void getFields(){
        try{

            FileInputStream in = new FileInputStream(fieldDB);
            ObjectInputStream oi;  
                try{             
                    while(true){
                        oi = new ObjectInputStream(in);
                        Field allFields = (Field) oi.readObject();
                        fieldVector.add(allFields);
                    }                
                } catch(EOFException e){

                }

            in.close();

        } catch(IOException e){} 
        catch (ClassNotFoundException ex) {}
  }
   
    
    public void searchFields(String Id){
        String searchInput = Id;
        Vector fieldSearchVector = new Vector<Field>();
        
        for(int i=0; i<fieldVector.size(); i++){
            Field fields = (Field) fieldVector.get(i);
            
            if(fields.getFarmId().equals(searchInput)){
                fieldSearchVector.add(fields);
            }
        }  
        setFieldsTable(fieldSearchVector);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFields = new javax.swing.JTable();
        btnAddPlot = new javax.swing.JButton();
        btnViewPlots = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        tblFields.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        tblFields.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Location", "Farm"
            }
        ));
        tblFields.setToolTipText("");
        tblFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFieldsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFields);

        btnAddPlot.setBackground(new java.awt.Color(204, 255, 255));
        btnAddPlot.setFont(new java.awt.Font("Hoefler Text", 0, 18)); // NOI18N
        btnAddPlot.setText("Add Plot");
        btnAddPlot.setToolTipText("Please select a row");
        btnAddPlot.setEnabled(false);
        btnAddPlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPlotActionPerformed(evt);
            }
        });

        btnViewPlots.setBackground(new java.awt.Color(204, 255, 255));
        btnViewPlots.setFont(new java.awt.Font("Hoefler Text", 0, 18)); // NOI18N
        btnViewPlots.setText("View Plots");
        btnViewPlots.setToolTipText("Please select a row");
        btnViewPlots.setEnabled(false);
        btnViewPlots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPlotsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewPlots, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPlot, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnAddPlot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnViewPlots, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Bodoni Ornaments", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("[");

        jLabel1.setFont(new java.awt.Font("Hoefler Text", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Field Management");

        jLabel3.setFont(new java.awt.Font("Bodoni Ornaments", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("\\");

            btnLogout.setBackground(new java.awt.Color(255, 255, 255));
            btnLogout.setFont(new java.awt.Font("Hoefler Text", 0, 18)); // NOI18N
            btnLogout.setForeground(new java.awt.Color(51, 204, 0));
            btnLogout.setText("Logout");
            btnLogout.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnLogoutActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(101, 101, 101)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(100, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(245, 245, 245)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnAddPlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlotActionPerformed
        System.out.println("Field selected : " + assignFieldId + ", name: " + assignFieldName);
        
        AddPlot obj = new AddPlot(assignFieldId, assignFieldName);
        
        obj.fieldId = assignFieldId;
        obj.fieldName= assignFieldName;
        obj.setVisible(true); 
    }//GEN-LAST:event_btnAddPlotActionPerformed

    private void btnViewPlotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPlotsActionPerformed
        System.out.println("Field selected : " + assignFieldId + ", name: " + assignFieldName);
        
        PlotManagement obj = new PlotManagement(assignFieldId, assignFieldName);
        
        obj.fieldId = assignFieldId;
        obj.fieldName= assignFieldName;
        obj.setVisible(true);
    }//GEN-LAST:event_btnViewPlotsActionPerformed

    private void tblFieldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFieldsMouseClicked
        int row = tblFields.getSelectedRow();
        if (tblFields.getRowSelectionAllowed()) {
            assignFieldId = tblFields.getValueAt(row, 0).toString();
            assignFieldName= tblFields.getValueAt(row, 1).toString();
            enableButtons();
        }
    }//GEN-LAST:event_tblFieldsMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(FieldManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FieldManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FieldManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FieldManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FieldManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPlot;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnViewPlots;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFields;
    // End of variables declaration//GEN-END:variables
}
