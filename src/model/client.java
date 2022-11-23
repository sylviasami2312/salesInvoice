package model;

import java.time.LocalDateTime;

public class client {
	private int cID;
	private int InvoiceNum;
	private String cName;
	private int  TotalInvoice;
	private LocalDateTime time;
	private InvoiceBody[] item;
	public client(int cID, int InvoiceNum, String cName,
			int TotalInvoice, LocalDateTime time, InvoiceBody[] item) {
		this.cID=cID;
		this.cName=cName;
		this.InvoiceNum=InvoiceNum;
		this.time=time;
		this.TotalInvoice=TotalInvoice;
		this.item=item;
	}
	  public LocalDateTime getTime() {
	        return time.now();
	    }

	    public int getClientID() {
	        return cID;
	    }

	    public void setClientID(int cID) {
	        this.cID = cID;
	    }

	    public int getInvoiceNum() {
	        return InvoiceNum;
	    }

	    public void setInvoiceNum(int InvoiceNum) {
	        this.InvoiceNum = InvoiceNum;
	    }

	    public String getCustomerName() {
	        return cName;
	    }

	    public void setCustomerName(String cName) {
	        this.cName = cName;
	    }

	    public int getTotalInvoice() {
	        return TotalInvoice;
	    }

	    public void setInvoiceTotal(int TotalInvoice) {
	        this.TotalInvoice = TotalInvoice;
	    }

	    public InvoiceBody[] getItem() {
	        return item;
	    }

	    public void setItem(InvoiceBody[] item) {
	        this.item = item;
	    }

	    
	}

				


