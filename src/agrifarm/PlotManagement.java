/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IP
 */
public class PlotManagement extends javax.swing.JFrame {
    private static final String fieldDB = "fieldDB.ser";
    private static final String plotDB= "plotDB.ser";
    
    Vector plotVector = new Vector<Plot>();
    String fieldId, fieldName;
    /**
     * Creates new form PlotManagement
     */
    public PlotManagement() {
        initComponents();
    }
    
    public PlotManagement(String Id, String name) {
        this.fieldId = Id;
        this.fieldName = name;
        initComponents();
        getPlots();
        searchPlots(Id);
    }

    public void setPlotsTable(Vector<Plot> vb)
    {
        DefaultTableModel plotTable = new DefaultTableModel();
        Vector columnName = new Vector();
        columnName.addElement("ID");
        columnName.addElement("Plot Name");
        columnName.addElement("Location");
        columnName.addElement("Field");
        plotTable.setColumnIdentifiers(columnName);
        try
        {
            for(int i=0;i<vb.size();i++)
            {
                Plot ff = (Plot)vb.get(i);
                Vector tableData = new Vector();
                tableData.addElement(ff.getId());
                tableData.addElement(ff.getName());
                tableData.addElement(ff.getLocation());
                tableData.addElement(ff.getFieldName());
                
                plotTable.addRow(tableData);
            }
            tblPlot.setModel(plotTable);
        }
        catch(Exception e)
        {}
    }
    
    private void getPlots(){
        try{

            FileInputStream in = new FileInputStream(plotDB);
            ObjectInputStream oi;  
                try{             
                    while(true){
                        oi = new ObjectInputStream(in);
                        Plot allPlots = (Plot) oi.readObject();
                        plotVector.add(allPlots);
                    }                
                } catch(EOFException e){

                }

            in.close();

        } catch(IOException e){} 
        catch (ClassNotFoundException ex) {}
  }
   
    
    public void searchPlots(String Id){
        String searchInput = Id;
        Vector plotSearchVector = new Vector<Plot>();
        
        for(int i=0; i<plotVector.size(); i++){
            Plot plots = (Plot) plotVector.get(i);
            
            if(plots.getFieldId().equals(searchInput)){
                plotSearchVector.add(plots);
            }
        }  
        setPlotsTable(plotSearchVector);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlot = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPlot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Plot Name", "Location", "Field"
            }
        ));
        jScrollPane1.setViewportView(tblPlot);

        btnAdd.setText("Add Plot");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdd))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PlotManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlotManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlotManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlotManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlotManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPlot;
    // End of variables declaration//GEN-END:variables
}