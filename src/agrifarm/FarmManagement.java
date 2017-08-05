/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dilshan
 */
public class FarmManagement extends javax.swing.JFrame {

    private static final String farmDB = "farmDB.ser";
    Vector<Integer> farmID = new Vector<Integer>();
    Vector farmVector = new Vector<Farm>();
    String currentUser = DataManagement.userName;
    private Farm selectedFarm;
    private AddFieldFarm farm;
    private String assignFarmId, assignFarmName;
    boolean status;
    
    public FarmManagement() {
        initComponents();
        getFarms();
        searchFarms();
    }

    private void enableButtons() {
        btnViewField.setEnabled(true);
        btnAddField.setEnabled(true);
        btnDeleteFarm.setEnabled(true);
    }
    
    public void setFarmsTable(Vector<Farm> farm) {
        DefaultTableModel farmTable = new DefaultTableModel();
        Vector columnName = new Vector();
        columnName.addElement("ID");
        columnName.addElement("Farm Name");
        columnName.addElement("Location");
        farmTable.setColumnIdentifiers(columnName);
        try{
            for(int i=0; i<farm.size(); i++)
            {
                Farm ff = (Farm)farm.get(i);
                Vector tableData = new Vector();
                tableData.addElement(ff.getId());
                tableData.addElement(ff.getName());
                tableData.addElement(ff.getArea());
                farmTable.addRow(tableData);
            }
            tblFarms.setModel(farmTable);
        }
        catch(Exception e)
        {}
    }
    
    private void getFarms(){
        try{
            FileInputStream in = new FileInputStream(farmDB);
            ObjectInputStream oi;  
                try{             
                    while(true){
                        oi = new ObjectInputStream(in);
                        Farm allFarms = (Farm) oi.readObject();
                        farmVector.add(allFarms);
                    }                
                } catch(EOFException e){}

            in.close();

        } catch(IOException e){} 
        catch (ClassNotFoundException ex) {}
    }
    
    public void searchFarms(){
        Vector farmSearchVector = new Vector<Farm>();
        
        for(int i=0; i<farmVector.size(); i++){
            Farm farms = (Farm) farmVector.get(i);
            if(farms.getUser().contentEquals(currentUser)){
                farmSearchVector.add(farms);
            }
        }  
        setFarmsTable(farmSearchVector);
    }
    
    public boolean deleteFarms(String id){
        Vector farmSearchVector = new Vector<Farm>();
        
        for(int i=0; i<farmVector.size(); i++){
            Farm farms = (Farm) farmVector.get(i);
            if(farms.getId().contentEquals(id)){
                farmVector.removeElement(farms);
                System.out.println("farm vector: "+farmVector);
                status = true;
            }
        }  
        return status;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFarms = new javax.swing.JTable();
        btnAddFarm = new javax.swing.JButton();
        btnAddField = new javax.swing.JButton();
        btnViewField = new javax.swing.JButton();
        btnDeleteFarm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 116, 0, 215));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        tblFarms.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 0), null, null));
        tblFarms.setFont(new java.awt.Font("Hoefler Text", 0, 18)); // NOI18N
        tblFarms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Area"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblFarms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFarmsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblFarms);

        btnAddFarm.setBackground(new java.awt.Color(255, 255, 204));
        btnAddFarm.setFont(new java.awt.Font("Hoefler Text", 0, 18)); // NOI18N
        btnAddFarm.setText("Add Farm");
        btnAddFarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFarmActionPerformed(evt);
            }
        });

        btnAddField.setBackground(new java.awt.Color(204, 255, 255));
        btnAddField.setFont(new java.awt.Font("Hoefler Text", 0, 18)); // NOI18N
        btnAddField.setText(" Add Field");
        btnAddField.setToolTipText("Please select a row");
        btnAddField.setEnabled(false);
        btnAddField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFieldActionPerformed(evt);
            }
        });

        btnViewField.setBackground(new java.awt.Color(204, 255, 255));
        btnViewField.setFont(new java.awt.Font("Hoefler Text", 0, 18)); // NOI18N
        btnViewField.setText(" View Fields");
        btnViewField.setToolTipText("Please select a row");
        btnViewField.setEnabled(false);
        btnViewField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewFieldActionPerformed(evt);
            }
        });

        btnDeleteFarm.setBackground(new java.awt.Color(255, 204, 204));
        btnDeleteFarm.setFont(new java.awt.Font("Hoefler Text", 0, 18)); // NOI18N
        btnDeleteFarm.setText("Delete Farm");
        btnDeleteFarm.setToolTipText("Please select a row");
        btnDeleteFarm.setEnabled(false);
        btnDeleteFarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFarmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeleteFarm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddFarm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnAddFarm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnDeleteFarm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnAddField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnViewField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Hoefler Text", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Farm Management");

        jLabel2.setFont(new java.awt.Font("Bodoni Ornaments", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("[");

        jLabel3.setFont(new java.awt.Font("Bodoni Ornaments", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("\\");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addGap(242, 242, 242))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE))
            );

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 533));

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnAddFarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFarmActionPerformed
        AddFarm obj = new AddFarm();
        obj.setVisible(true);
    }//GEN-LAST:event_btnAddFarmActionPerformed

    private void btnViewFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFieldActionPerformed
        System.out.println("Farm selected : " + assignFarmId + ", name: " + assignFarmName);
        
        FieldManagement obj = new FieldManagement(assignFarmId,assignFarmName);
        
        obj.farmId = assignFarmId;
        obj.farmName= assignFarmName;
        obj.setVisible(true);
    }//GEN-LAST:event_btnViewFieldActionPerformed

    private void tblFarmsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFarmsMouseClicked
        int row = tblFarms.getSelectedRow();
        if (tblFarms.getRowSelectionAllowed()) {
            assignFarmId = tblFarms.getValueAt(row, 0).toString();
            assignFarmName= tblFarms.getValueAt(row, 1).toString();
            enableButtons();
        }
    }//GEN-LAST:event_tblFarmsMouseClicked

    private void btnAddFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFieldActionPerformed
        System.out.println("Farm selected : " + assignFarmId + ", name: " + assignFarmName);
        
        AddFieldFarm obj = new AddFieldFarm();
        
        obj.farmId = assignFarmId;
        obj.farmName= assignFarmName;
        obj.setVisible(true); 
    }//GEN-LAST:event_btnAddFieldActionPerformed

    private void btnDeleteFarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFarmActionPerformed
        status = deleteFarms(assignFarmId);
        if(status == true) {
            System.out.println("Successfully deleted!");
            getFarms();
            searchFarms();
        } else {
            System.out.println("unable to delete!");
        }
    }//GEN-LAST:event_btnDeleteFarmActionPerformed
 
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
            java.util.logging.Logger.getLogger(FarmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FarmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FarmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FarmManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FarmManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFarm;
    private javax.swing.JButton btnAddField;
    private javax.swing.JButton btnDeleteFarm;
    private javax.swing.JButton btnViewField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblFarms;
    // End of variables declaration//GEN-END:variables
}
