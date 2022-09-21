package com.models;

import javax.swing.table.AbstractTableModel;

public class LinesTableModel extends AbstractTableModel {
    private String [] columnsName = {"Item", "Count", "Price Total", "Total"};
    private InvoiceHeader inv;

    public LinesTableModel(InvoiceHeader inv) {
        this.inv = inv;
    }

    @Override
    public int getRowCount() {
        return inv.getItems().size();
    }

    @Override
    public int getColumnCount() {
        return columnsName.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnsName[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine line = inv.getItems().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return line.getName();
            case 1:
                return line.getCount();
            case 2:
                return line.getPrice();
            case 3:
                return line.calculateTotal();
            default:
                return "";
        }
    }

    public InvoiceHeader getInv() {
        return inv;
    }
}
