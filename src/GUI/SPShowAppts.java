

package GUI;

import java.util.*;
import javax.swing.table.DefaultTableModel;

public class SPShowAppts extends javax.swing.JFrame {
    
    /**
     * Creates new form ContactEditor
     */
    public SPShowAppts() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSPApptsScrollPane = new javax.swing.JScrollPane();
        jConsumerApptsTable = new javax.swing.JTable();
        jSPApptsCloseButton = new javax.swing.JButton();
        jSPApptsPrompt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cancelling Appointment(s)");

        jConsumerApptsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer Name", "Date", "Start Time", "End Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jSPApptsScrollPane.setViewportView(jConsumerApptsTable);
        if (jConsumerApptsTable.getColumnModel().getColumnCount() > 0) {
            jConsumerApptsTable.getColumnModel().getColumn(0).setResizable(false);
            jConsumerApptsTable.getColumnModel().getColumn(1).setResizable(false);
            jConsumerApptsTable.getColumnModel().getColumn(3).setResizable(false);
        }
        jConsumerApptsTable.getSelectionModel().addListSelectionListener( new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                apptSelected(evt);
            }
        });

        jSPApptsCloseButton.setText("Close");
        jSPApptsCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSPApptsCloseButtonActionPerformed(evt);
            }
        });

        jSPApptsPrompt.setText("Appointments for your business are shown below. Please select the one you would like to cancel.");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jSPApptsCloseButton)
                    .add(jSPApptsScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 478, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jSPApptsPrompt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 476, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(jSPApptsPrompt)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 34, Short.MAX_VALUE)
                .add(jSPApptsScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 251, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jSPApptsCloseButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSPApptsCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSPApptsCloseButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jSPApptsCloseButtonActionPerformed
    
    void populateApptsTable( HashSet<String> apptList )
    {
        DefaultTableModel model = (DefaultTableModel) jConsumerApptsTable.getModel();
        model.setRowCount(0);
        
        apptLocationInTable = new HashMap<Integer,String>();
        Iterator apptIter = apptList.iterator();
        int index = 0;
        while( apptIter.hasNext() )
        {
            String appt = (String) apptIter.next();
            String businessName = appt.substring(0, appt.indexOf(' '));
            appt = appt.substring(appt.indexOf(' ')+1, appt.length());
            String date = appt.substring(0, appt.indexOf(' '));
            appt = appt.substring(appt.indexOf(' ')+1, appt.length());
            String startTime = appt.substring(0, appt.indexOf(' '));
            appt = appt.substring(appt.indexOf(' ')+1, appt.length());
            String endTime = appt.substring(0, appt.indexOf(' '));
            String apptId = appt.substring(appt.indexOf(' ')+1,appt.length());
            model.addRow( new Object[] {businessName,date,startTime,endTime} );
            apptLocationInTable.put(index, apptId);
            ++index;
        }
    }
    
    private void apptSelected(javax.swing.event.ListSelectionEvent evt) {
        if (!evt.getValueIsAdjusting() & (jConsumerApptsTable.getSelectedRow() > -1)) {
            selectedRow = jConsumerApptsTable.getSelectedRow();
            apptId = apptLocationInTable.get(selectedRow);
            apptCancelConfirmation = new ApptCancelConfirmation();
            apptCancelConfirmation.dtm = (DefaultTableModel) jConsumerApptsTable.getModel();			
            apptCancelConfirmation.selectedRow = this.selectedRow;
            apptCancelConfirmation.apptId = this.apptId;
            apptCancelConfirmation.setVisible(true);
            
        }
    }
    
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
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SPShowAppts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SPShowAppts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SPShowAppts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SPShowAppts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new SPShowAppts().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jConsumerApptsTable;
    private javax.swing.JButton jSPApptsCloseButton;
    private javax.swing.JLabel jSPApptsPrompt;
    private javax.swing.JScrollPane jSPApptsScrollPane;
    // End of variables declaration//GEN-END:variables
    
    private ApptCancelConfirmation apptCancelConfirmation;
    
    //static HashSet<String> apptList;
    HashMap<Integer,String> apptLocationInTable;
    private int selectedRow;
    private String apptId;
}