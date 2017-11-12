/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forwardandbackwardchaining;


import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainScreen extends javax.swing.JFrame {
    
    private AbstractChaining fchaining, bchaining;
    
    private JFileChooser fileChooser;
    private String kBase;
    private String queryStr;
    
    public MainScreen() {
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        queryTF = new javax.swing.JTextField();
        chooseBtn = new javax.swing.JButton();
        fcRB = new javax.swing.JRadioButton();
        bcRB = new javax.swing.JRadioButton();
        fileName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kbTA = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        entBtn = new javax.swing.JButton();
        rsTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter Query:");

        queryTF.setEnabled(false);
        queryTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                queryTFKeyTyped(evt);
            }
        });

        chooseBtn.setText("Choose File");
        chooseBtn.setToolTipText("select a textfile containing propostional logic in horn form");
        chooseBtn.setName("chooseBtn"); // NOI18N
        chooseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseBtnActionPerformed(evt);
            }
        });

        fcRB.setText("Forward Chaining");
        fcRB.setEnabled(false);
        fcRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fcRBActionPerformed(evt);
            }
        });

        bcRB.setText("Backward Chaining");
        bcRB.setEnabled(false);
        bcRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcRBActionPerformed(evt);
            }
        });

        kbTA.setEditable(false);
        kbTA.setColumns(20);
        kbTA.setRows(5);
        jScrollPane1.setViewportView(kbTA);

        jLabel2.setText("KNOWLEDGE BASE:");

        jLabel3.setText("RESULT:");

        entBtn.setText("Entail");
        entBtn.setEnabled(false);
        entBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entBtnActionPerformed(evt);
            }
        });

        rsTF.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rsTF)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(52, 52, 52))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(queryTF, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chooseBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fcRB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bcRB))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(entBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(queryTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chooseBtn))
                    .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fcRB)
                    .addComponent(bcRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bcRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcRBActionPerformed
        fcRB.setSelected(false);
        if (!entBtn.isEnabled()) {
            entBtn.setEnabled(true);
        }

    }//GEN-LAST:event_bcRBActionPerformed

    private void chooseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseBtnActionPerformed
        
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter ef = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(ef);
        
        int i = fileChooser.showOpenDialog(this);
        File f;
        if (i == JFileChooser.APPROVE_OPTION) {
            f = fileChooser.getSelectedFile();
            fileName.setText(f.getName());
            queryTF.setEnabled(true);
            fcRB.setEnabled(true);
            bcRB.setEnabled(true);
            try {
                BufferedReader in = new BufferedReader(new FileReader(f));
                kBase = in.readLine();
                
                String[] str = kBase.split(";");
                for (int l = 0; l < str.length; l++) {
                    kbTA.append(str[l] + "\n");
                    
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        

    }//GEN-LAST:event_chooseBtnActionPerformed
    
    private String getFChainingResult(String queryStr, String kBase) {
        fchaining = new ForwardChaining(queryStr, kBase);
        return fchaining.getResult();
    }
    
    private String getBChainingResult(String queryStr, String kBase) {
        bchaining = new BackwardChaining(queryStr, kBase);
        return bchaining.getResult();
    }
    private void entBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entBtnActionPerformed
        fileName.setText("");
        queryStr = queryTF.getText();
        if (fcRB.isSelected()) {
            String result = getFChainingResult(queryStr, kBase);
            rsTF.setText(result);
        }
        if (bcRB.isSelected()) {
            String result = getBChainingResult(queryStr, kBase);
            rsTF.setText(result);
        }
    }//GEN-LAST:event_entBtnActionPerformed

    private void fcRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fcRBActionPerformed
        if (!entBtn.isEnabled()) {
            entBtn.setEnabled(true);
        }
        bcRB.setSelected(false);

    }//GEN-LAST:event_fcRBActionPerformed

    private void queryTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_queryTFKeyTyped
        char inchar = evt.getKeyChar();
        if (!(Character.isAlphabetic(inchar) || (inchar == KeyEvent.VK_BACK_SPACE) || inchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_queryTFKeyTyped

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bcRB;
    private javax.swing.JButton chooseBtn;
    private javax.swing.JButton entBtn;
    private javax.swing.JRadioButton fcRB;
    private javax.swing.JLabel fileName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea kbTA;
    private javax.swing.JTextField queryTF;
    private javax.swing.JTextField rsTF;
    // End of variables declaration//GEN-END:variables
}

