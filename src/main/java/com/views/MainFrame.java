package com.views;

import com.controllers.ButtonActionListener;
import com.models.HeaderTableModel;
import com.models.InvoiceHeader;
import com.models.LinesTableModel;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        createInvBtn = new javax.swing.JButton();
        createInvBtn.addActionListener(listener);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        linesTable = new javax.swing.JTable();
        deleteInvBtn = new javax.swing.JButton();
        deleteInvBtn.addActionListener(listener);
        createItemBtn = new javax.swing.JButton();
        createItemBtn.addActionListener(listener);
        deleteItemBtn = new javax.swing.JButton();
        deleteItemBtn.addActionListener(listener);
        invNumberLabel = new javax.swing.JLabel();
        invDateLabel = new javax.swing.JLabel();
        invNameLabel = new javax.swing.JLabel();
        invTotalLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(listener);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(listener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Invoice #", "Date", "Customer Name", "Total"
            }
        ));
        invoicesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoicesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(invoicesTable);

        jLabel1.setText("Invoice #");

        createInvBtn.setText("Create New Invoice");

        jLabel2.setText("Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Total");

        linesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item", "Count", "Price", "Total"
            }
        ));
        jScrollPane2.setViewportView(linesTable);

        deleteInvBtn.setText("Delete Invoice");

        createItemBtn.setText("Add Item");

        deleteItemBtn.setText("Delete Item");

        fileMenu.setText("File");

        loadMenuItem.setText("Load");
        fileMenu.add(loadMenuItem);

        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invDateLabel)
                            .addComponent(invTotalLabel)
                            .addComponent(invNameLabel)
                            .addComponent(invNumberLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(createInvBtn)
                .addGap(32, 32, 32)
                .addComponent(deleteInvBtn)
                .addGap(183, 183, 183)
                .addComponent(createItemBtn)
                .addGap(35, 35, 35)
                .addComponent(deleteItemBtn)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invNumberLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invDateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(invNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotalLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createInvBtn)
                        .addComponent(deleteInvBtn))
                    .addComponent(createItemBtn)
                    .addComponent(deleteItemBtn))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createInvBtnActionPerformed

    private void createItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createItemBtnActionPerformed

    private void deleteItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteItemBtnActionPerformed

    private void deleteInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvBtnActionPerformed

    private void invoicesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoicesTableMouseClicked
        HeaderTableModel headerTableModel = (HeaderTableModel) getInvoicesTable().getModel();
        int selectedRowIndex = invoicesTable.getSelectedRow();

        invNumberLabel.setText(headerTableModel.getValueAt(selectedRowIndex, 0).toString());
        invDateLabel.setText(headerTableModel.getValueAt(selectedRowIndex, 1).toString());
        invNameLabel.setText(headerTableModel.getValueAt(selectedRowIndex, 2).toString());
        invTotalLabel.setText(headerTableModel.getValueAt(selectedRowIndex, 3).toString());

        setLinesTableModel(new LinesTableModel(getInvoiceByNum(selectedRowIndex + 1)));
    }//GEN-LAST:event_invoicesTableMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                mainFrame.listener.load("InvoiceHeader.csv", "InvoiceLines.csv");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvBtn;
    private javax.swing.JButton createItemBtn;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel invDateLabel;
    private javax.swing.JLabel invNameLabel;
    private javax.swing.JLabel invNumberLabel;
    private javax.swing.JLabel invTotalLabel;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable linesTable;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    // Static Variables
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    // Custom Variables
    private ButtonActionListener listener = new ButtonActionListener(this);
    private ArrayList<InvoiceHeader> invoices;
    private HeaderTableModel headerTableModel;
    private LinesTableModel linesTableModel;
    
    // Views
//    private NewInvTable newInvoiceFrame;

    public HeaderTableModel getHeaderTableModel() {
        return headerTableModel;
    }

    public void setHeaderTableModel(HeaderTableModel headerTableModel) {
        this.headerTableModel = headerTableModel;
        getInvoicesTable().setModel(headerTableModel);
    }

    public LinesTableModel getLinesTableModel() {
        return linesTableModel;
    }

    public void setLinesTableModel(LinesTableModel linesTableModel) {
        this.linesTableModel = linesTableModel;
        getLinesTable().setModel(linesTableModel);
    }

    public JTable getInvoicesTable() {
        return invoicesTable;
    }

    public JTable getLinesTable() {
        return linesTable;
    }

    public ButtonActionListener getListener() {
        return listener;
    }

    public ArrayList<InvoiceHeader> getInvoices() {
        if (invoices == null) {
            invoices = new ArrayList<>();
        }
        return invoices;
    }

    public InvoiceHeader getInvoiceByNum(int num) {
        InvoiceHeader inv = null;
        for (InvoiceHeader invHeader: getInvoices()) {
            if (invHeader.getId() == num) {
                inv = invHeader;
                break;
            }
        }
        return inv;
    }
}
