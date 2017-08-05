/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;

import agrifarm.Sensor.SensorType;
import agrifarm.Sensor.FieldStation;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.UUID;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Dharshana
 */
public class hardwareManagement extends javax.swing.JFrame {
    private static final String sensorDB="sensorDB.ser";
    /**
     * Creates new form sensorManagement
     */
    public hardwareManagement() {
        initComponents();
        //load table by default
        loadSensors();
    }
    
     public void loadSensors() {
        try {
            Vector<Vector<String>> data = new Vector<>();
            Vector<String> header = new Vector<>();
            header.add("Sensor");
            header.add("Location");
            header.add("Frequency");
            header.add("Enabled");
            FileInputStream in = new FileInputStream(sensorDB);
            ObjectInputStream ois;
            try {
                while (true) {
                    ois = new ObjectInputStream(in);
                    Sensor newSensor = (Sensor) ois.readObject();
                    Vector v = new Vector();
                    v.add(newSensor.getSensorType());
                    v.add(newSensor.getLocation());
                    v.add(newSensor.getFrequency());
                    v.add(newSensor.isEnabled());
                    data.add(v);
                    
                }
            } catch (EOFException e) {
                System.out.println(e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(hardwareManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("should print4");
            sensorListTable.setModel(new DefaultTableModel(data, header));
            TableColumn enabledColumn = sensorListTable.getColumnModel().getColumn(3);
            JComboBox comboBox = new JComboBox();
            comboBox.addItem("yes");
            comboBox.addItem("no");
            enabledColumn.setCellEditor(new DefaultCellEditor(comboBox));


            System.out.println("should print");
            in.close();

        } catch (IOException e) {
            System.out.println(e);

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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sensorListTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        newSensorFieldStationComboBox = new javax.swing.JComboBox<>();
        newSensorTypeComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        newSensorUpdateFrequencyTextField = new javax.swing.JTextField();
        newSensorEnableStatusComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        newSensorAddButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        newSensorLocationTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setToolTipText("");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Field Station");

        sensorListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(sensorListTable);

        jLabel2.setText("Sensors");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Current Sensors", jPanel1);

        jLabel3.setText("Select Field Station");

        newSensorFieldStationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        newSensorTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Air Temperature", "Pressure", "Soil Moisture", "Acidity", "Soil Temperature", "Light Sensor" }));

        jLabel4.setText("Sensor Type");

        jLabel5.setText("Update Frequency");

        newSensorUpdateFrequencyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSensorUpdateFrequencyTextFieldActionPerformed(evt);
            }
        });

        newSensorEnableStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "true", "false" }));

        jLabel6.setText("Enable Status");

        newSensorAddButton.setText("Add New Sensor");
        newSensorAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSensorAddButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Location");

        newSensorLocationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSensorLocationTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newSensorFieldStationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(newSensorTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(newSensorAddButton)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6))
                    .addComponent(newSensorEnableStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(newSensorLocationTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newSensorUpdateFrequencyTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                .addContainerGap(531, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newSensorFieldStationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newSensorTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newSensorUpdateFrequencyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(7, 7, 7)
                .addComponent(newSensorLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newSensorEnableStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(newSensorAddButton)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Sensors", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newSensorUpdateFrequencyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSensorUpdateFrequencyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newSensorUpdateFrequencyTextFieldActionPerformed

    private void newSensorAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSensorAddButtonActionPerformed
        //Add new sensor
//        Double lat=Double.parseDouble(newSensorLocationTextField.getText());
//        Double lng=Double.parseDouble(newSensorLocationLngTextField.getText());
        String location=newSensorLocationTextField.getText();
        Boolean enabled=Boolean.valueOf(newSensorEnableStatusComboBox.getSelectedItem().toString());
        Long frequency=Long.parseLong(newSensorUpdateFrequencyTextField.getText());
        Date today = new Date();
//        int sensorId=UUID.randomUUID().hashCode();
        int sensorId=7;
        //get enum type from comboBox
        SensorType newSensorType=null;
        System.out.print("xx:"+newSensorTypeComboBox.getSelectedItem().toString());
        switch(newSensorTypeComboBox.getSelectedItem().toString()){
            case "Air Temperature":
                newSensorType=SensorType.AIR_TEMPERATURE;
                break;
            case "Pressure":
                newSensorType=SensorType.PRESSURE;
                break;
            case "Soil Moisture":
                newSensorType=SensorType.SOIL_MOISTURE;
                break;
            case "Acidity":
                newSensorType=SensorType.ACIDITY;
                break;
            case "Soil Temperature":
                newSensorType=SensorType.SOIL_TEMPERATURE;
                break;
            case "Light Sensor":
                newSensorType=SensorType.LIGHT_SENSOR;
                break;
        }
        
        FieldStation newFieldStation = FieldStation.FS1;
        //try to serialize
        try {
            //new sensor object with above variable
            Sensor newSensor = new Sensor(location,enabled,frequency,today,sensorId,newSensorType,new SoilAcidityReader(),newFieldStation);
            Serialize sensorSerialize=new Serialize(newSensor,sensorDB);
            
            //reload sensors and switch back to current sensors pane
            loadSensors();
            jTabbedPane1.setSelectedIndex(0);
        } catch (IOException ex) {
            Logger.getLogger(hardwareManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newSensorAddButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //populate table according to selected field statiom
        System.out.println("string:"+jComboBox1.getSelectedItem().toString());
        System.out.println("int:"+jComboBox1.getSelectedIndex());
        

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void newSensorLocationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSensorLocationTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newSensorLocationTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(hardwareManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hardwareManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hardwareManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hardwareManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hardwareManagement().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton newSensorAddButton;
    private javax.swing.JComboBox<String> newSensorEnableStatusComboBox;
    private javax.swing.JComboBox<String> newSensorFieldStationComboBox;
    private javax.swing.JTextField newSensorLocationTextField;
    private javax.swing.JComboBox<String> newSensorTypeComboBox;
    private javax.swing.JTextField newSensorUpdateFrequencyTextField;
    private javax.swing.JTable sensorListTable;
    // End of variables declaration//GEN-END:variables
}
