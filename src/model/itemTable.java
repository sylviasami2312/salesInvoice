package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class itemTable extends AbstractTableModel {
	  private ArrayList<InvoiceBody> items;
	    private String[] columns = {"Name", "Price", "Count", "Total"};

	    public itemTable() {
	        this(new ArrayList<InvoiceBody>());
	    }
	    
	    public itemTable(ArrayList<InvoiceBody> items) {
	        this.items = items;
	    }
	   
	     @Override
	    public int getRowCount() {
	        return items.size();
	    }

	    
	     @Override
	    public int getColumnCount() {
	        return columns.length;
	    }

	    
	     @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        InvoiceBody item = items.get(rowIndex);
	        switch (columnIndex) {
	            case 0: return item.getName();
	            case 1: return item.getPrice();
	            case 2: return item.getCount();
	            case 3: return item.getTotal();
	            default: return "";
	        }
	    }

	    
	     @Override
	    public String getColumnName(int column) {
	        return columns[column];
	    }
	    
	}