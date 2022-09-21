/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.views;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class NewInvFrame extends JFrame {
    private JTextField dateField;
    private JTextField custNameField;
    private JButton okBtn;
    private JButton cancelBtn;
    private GridLayout grid;

    public NewInvFrame(MainFrame mainFrame) {
        grid = new GridLayout(3, 2);
        grid.setHgap(10);
        grid.setVgap(5);
        dateField = new JTextField(12);
        custNameField = new JTextField(20);
        okBtn = new JButton("OK");
        okBtn.setActionCommand("okInvBtn");
        okBtn.addActionListener(mainFrame.getListener());
        cancelBtn = new JButton("Cancel");
        cancelBtn.setActionCommand("cancelInvBtn");
        cancelBtn.addActionListener(mainFrame.getListener());

        add(new JLabel("Invoice Date"));
        add(dateField);
        add(new JLabel("Customer Name"));
        add(custNameField);
        add(okBtn);
        add(cancelBtn);

        setLayout(grid);
        pack();
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JTextField getCustNameField() {
        return custNameField;
    }
}
