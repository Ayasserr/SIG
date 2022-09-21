package com.views;

import javax.swing.*;
import java.awt.*;

public class NewLineFrame extends JFrame {
    private JTextField nameField;
    private JTextField priceField;
    private JTextField countField;
    private JButton okBtn;
    private JButton cancelBtn;
    private GridLayout grid;

    public NewLineFrame(MainFrame mainFrame) {
        grid = new GridLayout(4, 2);
        grid.setHgap(10);
        grid.setVgap(5);
        nameField = new JTextField(20);
        priceField = new JTextField(10);
        countField = new JTextField(10);
        okBtn = new JButton("OK");
        okBtn.setActionCommand("newLineBtn");
        okBtn.addActionListener(mainFrame.getListener());
        cancelBtn = new JButton("Cancel");
        cancelBtn.setActionCommand("cancelLineBtn");
        cancelBtn.addActionListener(mainFrame.getListener());
        add(new JLabel("Item name"));
        add(nameField);
        add(new JLabel("Item price"));
        add(priceField);
        add(new JLabel("Item count"));
        add(countField);
        add(okBtn);
        add(cancelBtn);
        setLayout(grid);
        pack();
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JTextField getCountField() {
        return countField;
    }
}
