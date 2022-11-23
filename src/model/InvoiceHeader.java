package model;

import java.util.ArrayList;
import java.util.Date;

import view.SalesFrame;

public class InvoiceHeader {

	private String name;
	private int invNum;
	private Date date;
	private ArrayList<InvoiceBody> items;
	
	public InvoiceHeader(int invNum, Date date, String name) {
		this.date=date;
		this.invNum=invNum;
		this.name=name;
	}
	  public double getTotal() {
	        int total = 0;
	        for (InvoiceBody item : getItems()) {
	            total += item.getTotal();
	        }
	        return total;
	    }
	    
	    public ArrayList<InvoiceBody> getItems() {
	        if (items == null) {
	            items = new ArrayList<>();
	        }
	        return items;
	    }
	    
	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public int getinvNum() {
	        return invNum;
	    }

	    public void setNum(int invNum) {
	        this.invNum = invNum;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	 
	    public String toString() {
	        return "InvoiceHeader{" + "Invoice num=" + invNum + ", name=" + name + ", date=" + date + '}';
	    }
	     public String getAsCSV() {
	        return invNum + "," + SalesFrame.df.format(date) + "," + name;
	    }
	}


