/*
 * Copyright (c) 2010, Oracle. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of Oracle nor the names of its contributors
 *   may be used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package GUI;

import Consumer.Consumer;

public class ConsumerBook extends javax.swing.JFrame {
    
    /**
     * Creates new form ContactEditor
     */
    public ConsumerBook() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jConsumerBookStartTimeLabel = new javax.swing.JLabel();
        jConsumerBookDateLabel = new javax.swing.JLabel();
        jConsumerBookEndTimeLabel = new javax.swing.JLabel();
        jConsumerBookBusinessNameLabel = new javax.swing.JLabel();
        jConsumerBookBusinessNameField = new javax.swing.JTextField();
        jConsumerBookOkButton = new javax.swing.JButton();
        jConsumerBookCancelButton = new javax.swing.JButton();
        jConsumerBookPrompt = new javax.swing.JLabel();
        jConsumerBookDateField = new javax.swing.JFormattedTextField();
        jConsumerBookStartTimeField = new javax.swing.JFormattedTextField();
        jConsumerBookEndTimeField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consumer Booking");

        jConsumerBookStartTimeLabel.setText("Start time:");

        jConsumerBookDateLabel.setText("Date:");

        jConsumerBookEndTimeLabel.setText("End time:");

        jConsumerBookBusinessNameLabel.setText("Business name:");

        jConsumerBookOkButton.setText("OK");
        jConsumerBookOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsumerBookOkButtonActionPerformed(evt);
            }
        });

        jConsumerBookCancelButton.setText("Cancel");
        jConsumerBookCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsumerBookCancelButtonActionPerformed(evt);
            }
        });

        jConsumerBookPrompt.setText("Please provide your appointment details:");

        try {
            jConsumerBookDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jConsumerBookStartTimeField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jConsumerBookEndTimeField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jConsumerBookEndTimeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsumerBookEndTimeFieldActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jConsumerBookPrompt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 413, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(layout.createSequentialGroup()
                            .add(jConsumerBookOkButton)
                            .add(18, 18, 18)
                            .add(jConsumerBookCancelButton))
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jConsumerBookStartTimeLabel)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jConsumerBookEndTimeLabel)
                                .add(jConsumerBookBusinessNameLabel)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jConsumerBookDateLabel))
                            .add(18, 18, 18)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(jConsumerBookDateField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jConsumerBookStartTimeField)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jConsumerBookBusinessNameField)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jConsumerBookEndTimeField))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .add(jConsumerBookPrompt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jConsumerBookDateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jConsumerBookDateLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jConsumerBookStartTimeField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jConsumerBookStartTimeLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jConsumerBookEndTimeLabel)
                    .add(jConsumerBookEndTimeField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jConsumerBookBusinessNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jConsumerBookBusinessNameLabel))
                .add(30, 30, 30)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jConsumerBookOkButton)
                    .add(jConsumerBookCancelButton))
                .add(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jConsumerBookOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsumerBookOkButtonActionPerformed
        String startTime = jConsumerBookStartTimeField.getText();
        String date = jConsumerBookDateField.getText();
        String businessName = jConsumerBookBusinessNameField.getText();
        String endTime = jConsumerBookEndTimeField.getText();
        String str = businessName + " " + consumer_id + " " + date  + " " + startTime + " " + endTime;
        Consumer c = new Consumer();
        c.book(str);
        jConsumerBookPrompt.setText("Appointment registered in the system.");
        this.setVisible(false);    
    }//GEN-LAST:event_jConsumerBookOkButtonActionPerformed

    private void jConsumerBookCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsumerBookCancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jConsumerBookCancelButtonActionPerformed

    private void jConsumerBookEndTimeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsumerBookEndTimeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jConsumerBookEndTimeFieldActionPerformed
    
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
            java.util.logging.Logger.getLogger(ConsumerBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsumerBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsumerBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsumerBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsumerBook().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField jConsumerBookBusinessNameField;
    private javax.swing.JLabel jConsumerBookBusinessNameLabel;
    private javax.swing.JButton jConsumerBookCancelButton;
    private javax.swing.JFormattedTextField jConsumerBookDateField;
    private javax.swing.JLabel jConsumerBookDateLabel;
    private javax.swing.JFormattedTextField jConsumerBookEndTimeField;
    private javax.swing.JLabel jConsumerBookEndTimeLabel;
    private javax.swing.JButton jConsumerBookOkButton;
    private javax.swing.JLabel jConsumerBookPrompt;
    private javax.swing.JFormattedTextField jConsumerBookStartTimeField;
    private javax.swing.JLabel jConsumerBookStartTimeLabel;
    String consumer_id = "";
    // End of variables declaration//GEN-END:variables
    
}