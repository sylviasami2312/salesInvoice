package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import view.SalesFrame;

public class tableHeader extends AbstractTableModel {
	   private ArrayList<InvoiceHeader> invoices;
	    private String[] columns = {"Num", "Name", "Date", "Total"};

	    public tableHeader(ArrayList<InvoiceHeader> invoices) {
	        this.invoices = invoices;
	    }
	   
	      @Override
	    public int getRowCount() {
	        return invoices.size();
	    }

	  
	      @Override
	    public int getColumnCount() {
	        return columns.length;
	    }

	   
	      @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        InvoiceHeader inv = invoices.get(rowIndex);
	        switch (columnIndex) {
	            case 0:
	                return inv.getinvNum();
	            case 1: 
	                return inv.getName();
	            case 2:
	                return SalesFrame.df.format(inv.getDate());
	            case 3:
	                return inv.getTotal();
	            default:
	                return "";
	        }
	        
	    }


	      @Override
	    public String getColumnName(int column) {
	        return columns[column];
	    }
	    
	}

