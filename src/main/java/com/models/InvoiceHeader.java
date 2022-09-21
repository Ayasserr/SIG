package com.models;

import com.views.MainFrame;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    private int id;
    private Date date;
    private String customerName;
    private ArrayList<InvoiceLine> items;

    public InvoiceHeader(int id, Date date, String customerName) {
        this.id = id;
        this.date = date;
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<InvoiceLine> getItems() {
        // Lazy creation
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    public double getTotal() {
        double total = 0;

        for(InvoiceLine item: getItems()) {
            total += item.calculateTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return id + "," + MainFrame.sdf.format(date) + "," + customerName;
    }
}
