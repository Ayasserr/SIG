package com.models;

import com.views.MainFrame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class HeaderTableModel extends AbstractTableModel {

    private String [] columnsName = {"Invoice Num", "Invoice Date", "Customer Name", "Invoice Total"};
    private ArrayList<InvoiceHeader> invoices;

    public HeaderTableModel(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
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
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader inv = invoices.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return inv.getId();
            case 1:
                return MainFrame.sdf.format(inv.getDate());
            case 2:
                return inv.getCustomerName();
            case 3:
                return inv.getTotal();
            default:
                return "";
        }
    }
}
