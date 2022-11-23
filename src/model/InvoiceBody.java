package model;

public class InvoiceBody {
	private String name;
	private int count;
	private double price;
	private InvoiceHeader invoice;
	
	public InvoiceBody(String name, int count, int price, InvoiceHeader invoice) {
		this.count=count;
		this.name=name;
		this.price=price;
		this.invoice=invoice;
	}
	public double getTotal() {
        return count * price;
    }
    
    public InvoiceHeader getInv() {
        return invoice;
    }

    public void setInv(InvoiceHeader invoice) {
        this.invoice = invoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "InvoiceBody{" + "name=" + name + ", count=" + count + ", price=" + price + '}';
    }
    
     public String getAsCSV() {
        return invoice.getinvNum() + "," + name + "," + price + "," + count;
    }
    
}

	


