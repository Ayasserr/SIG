package com.controllers;

import com.models.HeaderTableModel;
import com.models.InvoiceHeader;
import com.models.InvoiceLine;
import com.views.MainFrame;
import com.views.NewInvFrame;
import com.views.NewLineFrame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ButtonActionListener implements ActionListener {
    private MainFrame mainFrame;
    private NewInvFrame newInv;
    private NewLineFrame newLine;

    private File headerFile;
    private File linesFile;

    public ButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Load":
                load(null, null);
                break;
            case "Save":
                save();
                break;
            case "Create New Invoice":
                System.out.println("here now");
                createInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "Add Item":
                createItem();
                break;
            case "Delete Item":
                deleteItem();
                break;
            case "okInvBtn":
                okBtnNewInv();
                break;
            case "cancelInvBtn":
                cancelBtnNewInv();
                break;
            case "newLineBtn":
                okBtnNewLine();
                break;
            case "cancelLineBtn":
                cancelBtnNewLine();
                break;
        }
    }

    public void load(String headerPath, String linesPath) {
        if (headerPath == null && linesPath == null) {
            JOptionPane.showMessageDialog(mainFrame, "Select header file first, then select line file.", "Invoice files", JOptionPane.WARNING_MESSAGE);
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(mainFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                headerFile = fc.getSelectedFile();
                result = fc.showOpenDialog(mainFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    linesFile = fc.getSelectedFile();
                }
            }
        } else {
            headerFile = new File(headerPath);
            linesFile = new File(linesPath);
        }

        if (headerFile != null && linesFile != null) {
            try {
                List<String> headerLines = Files.lines(Paths.get(headerFile.getAbsolutePath())).collect(Collectors.toList());
                List<String> lineLines = Files.lines(Paths.get(linesFile.getAbsolutePath())).collect(Collectors.toList());
                mainFrame.getInvoices().clear();

                for (String line: headerLines) {
                    String [] lineParts = line.split(",");
                    int invID = Integer.parseInt(lineParts[0]);
                    Date invDate = MainFrame.sdf.parse(lineParts[1]);
                    String custName = lineParts[2];
                    mainFrame.getInvoices().add(new InvoiceHeader(invID, invDate, custName));
                }

                for (String line: lineLines) {
                    String [] lineParts = line.split(",");
                    int invID = Integer.parseInt(lineParts[0]);
                    String name = lineParts[1];
                    double price = Double.parseDouble(lineParts[2]);
                    int count = Integer.parseInt(lineParts[3]);
                    InvoiceHeader inv = mainFrame.getInvoiceByNum(invID);
                    inv.getItems().add(new InvoiceLine(name, price, count, inv));
                }

                mainFrame.setHeaderTableModel(new HeaderTableModel(mainFrame.getInvoices()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(mainFrame, "Cannot find file", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(mainFrame, "Cannot read file", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(mainFrame, "Something wrong with parsing", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void save() {
        String headers = "";
        String lines = "";

        for (InvoiceHeader header: mainFrame.getInvoices()) {
            String headerLine = header.toString();
            headers += headerLine + "\n";

            for (InvoiceLine line: header.getItems()) {
                String lineLine = line.toString();
                lines += lineLine + "\n";
            }
        }
        
        if (headerFile == null && linesFile == null) {
            JOptionPane.showMessageDialog(mainFrame, "Select place to save files", "Invoice files", JOptionPane.INFORMATION_MESSAGE);
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(mainFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                headerFile = fc.getSelectedFile();
                result = fc.showOpenDialog(mainFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    linesFile = fc.getSelectedFile();
                }
            }
        } else {
            try {
                FileWriter headerFileWriter = new FileWriter(headerFile);
                FileWriter linesFileWriter = new FileWriter(linesFile);
                headerFileWriter.write(headers);
                linesFileWriter.write(lines);
                headerFileWriter.flush();
                linesFileWriter.flush();
                headerFileWriter.close();
                linesFileWriter.close();
                JOptionPane.showMessageDialog(mainFrame, "File saved successfully", "Information Message", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(mainFrame, "Cannot find file", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(mainFrame, "Cannot save file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void createInvoice() {
        newInv = new NewInvFrame(mainFrame);
        newInv.setVisible(true);
    }

    private void deleteInvoice() {
        int selectedRow = mainFrame.getInvoicesTable().getSelectedRow();
        if (selectedRow != -1) {
            mainFrame.getInvoices().remove(selectedRow);
            mainFrame.getHeaderTableModel().fireTableDataChanged();
        }
    }

    private void okBtnNewInv() {
        String date = newInv.getDateField().getText();
        String name = newInv.getCustNameField().getText();
        try {
            Date invDate = MainFrame.sdf.parse(date);
            int invNum = mainFrame.getInvoices().size() + 1;
            mainFrame.getInvoices().add(new InvoiceHeader(invNum, invDate, name));
            mainFrame.getHeaderTableModel().fireTableDataChanged();
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame, "Something wrong with parsing", "Error", JOptionPane.ERROR_MESSAGE);
        }
        newInv.setVisible(false);
        newInv = null;
    }

    private void cancelBtnNewInv() {
        newInv.setVisible(false);
        newInv = null;
    }

    private void createItem() {
        newLine = new NewLineFrame(mainFrame);
        newLine.setVisible(true);
    }

    private void deleteItem() {
        int selectedRow = mainFrame.getLinesTable().getSelectedRow();
        if (selectedRow != -1) {
            mainFrame.getLinesTableModel().getInv().getItems().remove(selectedRow);
            mainFrame.getLinesTableModel().fireTableDataChanged();
            mainFrame.getHeaderTableModel().fireTableDataChanged();
        }
    }

    private void okBtnNewLine() {
        String name = newLine.getNameField().getText();
        int price = Integer.parseInt(newLine.getPriceField().getText());
        int count = Integer.parseInt(newLine.getCountField().getText());

        int selectedInvRow = mainFrame.getInvoicesTable().getSelectedRow();
        if (selectedInvRow != -1) {
            InvoiceHeader inv = mainFrame.getInvoiceByNum(selectedInvRow + 1);
            inv.getItems().add(new InvoiceLine(name, price, count, inv));
            mainFrame.getLinesTableModel().fireTableDataChanged();
            mainFrame.getHeaderTableModel().fireTableDataChanged();
        }

        newLine.setVisible(false);
        newInv = null;
    }

    private void cancelBtnNewLine() {
        newLine.setVisible(false);
        newInv = null;
    }
}
