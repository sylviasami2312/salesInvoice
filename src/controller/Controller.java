package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.InvoiceBody;
import model.InvoiceHeader;
import model.itemTable;
import model.tableHeader;
import view.SalesFrame;
import view.newJDialog;
import view.newJLine;

public class Controller implements ActionListener, ListSelectionListener {
	  private newJLine lineDialog;
	    private newJDialog headerDialog;
	    // int invNum=0;
	    //  List<String> lLines;
	    private SalesFrame frame;
	    //  private NewJFrame  frame1;
	    private List<String> hLines;
	    //File hFile;
	    //File lFile;

	    public Controller(SalesFrame frame) {
	        this.frame = frame;
	    }

	    public SalesFrame getFrame() {
	        return frame;
	    }

	    public void setFrame(SalesFrame frame) {
	        this.frame = frame;
	    }

	    public List<String> gethLines() {
	        return hLines;
	    }

	    public void sethLines(List<String> hLines) {
	        this.hLines = hLines;
	    }

	    /*   public Controller(NewJFrame frame) { 
	        this.frame1 = frame;
	    }*/
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String action = e.getActionCommand();

	        switch (action) {
	            case "New Invoice": {
	                newInvoice();
	            }
	            break;

	            case "Delete Invoice": {

	                deleteInvoice();

	            }

	            break;

	            case "New Line":
	                newLine();
	                break;

	            case "Delete Line":
	                deleteLine();
	                break;

	            case "newInvoiceOK":
	                newInvoiceOK();
	                break;

	            case "newInvoiceCancel":
	                newInvoiceCancel();
	                break;

	            case "newLineOK": {
	                try {
	                    newLineOK();
	                } catch (IOException ex) {
	                	java.util.logging.Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	                }
	            }
	            break;

	            case "newLineCancel":
	                newLineCancel();
	                break;
	            case "Load":
	                load(null, null);
	                break;

	            case "Save": {
	                try {
	                    save();
	                } catch (IOException | NullPointerException ex) {
	                	java.util.logging.Logger.getLogger(Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	                }
	            }
	            break;

	        }
	    }

	    @Override
	    public void valueChanged(ListSelectionEvent e) throws ArrayIndexOutOfBoundsException {
	        int selectedRow = frame.getInvoicesTable().getSelectedRow();
	        System.out.println("Row Selected " + selectedRow);
	        if (selectedRow != -1) {
	            InvoiceHeader selectedInv = frame.getInvoices().get(selectedRow);
	            frame.getCustomerNameLbl().setText(selectedInv.getName());
	            frame.getInvDateLbl().setText(frame.df.format(selectedInv.getDate()));
	            frame.getInvNumLbl().setText("" + selectedInv.getinvNum());
	            frame.getInvTotalLbl().setText("" + selectedInv.getTotal());
	            frame.setItemTableModel(new itemTable(selectedInv.getItems()));
	        } else {
	            frame.getCustomerNameLbl().setText("");
	            frame.getInvNumLbl().setText("");
	            frame.getInvTotalLbl().setText("");
	            frame.getInvDateLbl().setText("");
	            frame.setItemTableModel(new itemTable());

	        }
	    }

	    private void newLine() {
	        int selectedInvoice = frame.getInvoicesTable().getSelectedRow();
	        if (selectedInvoice == -1) {
	            JOptionPane.showMessageDialog(frame, "First, select Invoice to add item to it", "Error", JOptionPane.ERROR_MESSAGE);
	        } else {
	            lineDialog = new newJLine(frame);
	            lineDialog.setVisible(true);
	        }
	    }

	    private void newInvoice() {
	        /*  File myObj = new File("New Invoice");
	        INVOICEHeader newON = new INVOICEHeader(0,null,null);
	      myObj.createNewFile();
	      load(myObj.getPath(),lFile.getPath());
	        JOptionPane.showMessageDialog(frame,myObj.getName() + " created");
	        frame.getInvoices().add(newON);
	         */
	        headerDialog = new newJDialog(frame);
	        headerDialog.setVisible(true);
	    }

	    private void deleteInvoice() {
	        //hFile.getPath.delete();
	        //file to be delete  
	        /*   this.hFile.deleteOnExit();              
	        this.lFile.deleteOnExit();        //returns Boolean value   
	JOptionPane.showMessageDialog(frame,hFile.getName() + " deleted");

	JOptionPane.showMessageDialog(frame,lFile.getName() + " deleted");
	lFile=null;
	hFile=null;
	load(null,null);*/
	        int selectedRow = frame.getInvoicesTable().getSelectedRow();
	        if (selectedRow != -1) {
	            frame.getInvoices().remove(selectedRow);
	            frame.getHeaderTableModel().fireTableDataChanged();
	        } else {
	            JOptionPane.showMessageDialog(frame, "First, select Invoice to delete", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        //getting and printing the file name  
	    }

	    private void newInvoiceOK() {
	        try {
	            String dateStr = headerDialog.getNewDateF().getText();
	            String name = headerDialog.getNewNameF().getText();
	            // System.out.print(name+dateStr);
	            Date date = frame.df.parse(dateStr);
	            int num = frame.getNextInvoiceNum();
	            System.out.print(date + "" + num);
	            InvoiceHeader inv = new InvoiceHeader(num, date, name);
	            System.out.print(inv.toString());
	            frame.getInvoices().add(inv);
	            frame.getHeaderTableModel().fireTableDataChanged();
	            newInvoiceCancel();
	        } catch (ParseException ex) {
	            JOptionPane.showMessageDialog(frame, "Error in Date format", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }


	    /*  private void newLines() {
	        INVOICELine newL = new INVOICELine(null,0,0.0,frame.getInvoiceByNum(invNum));
	        this.getlLines().add("");
	        frame.getInvoiceByNum(invNum).getItems().add(newL);
	        System.out.print(this.getlLines().toString());
	    }*/
	    private void deleteLine() {
	        //int f= frame.getLinesTable().getSelectedRow();
	        //frame.getLinesTable().remove(f);
	        //JOptionPane.showMessageDialog(frame,"Line" + f + "is deleted");
	        int selectedInvoice = frame.getInvoicesTable().getSelectedRow();
	        int selectedItem = frame.getLinesTable().getSelectedRow();
	        if (selectedInvoice != -1 && selectedItem != -1) {
	            InvoiceHeader invoice = frame.getInvoices().get(selectedInvoice);
	            invoice.getItems().remove(selectedItem);
	            frame.getItemTableModel().fireTableDataChanged();
	            frame.getHeaderTableModel().fireTableDataChanged();
	            frame.getInvoicesTable().setRowSelectionInterval(selectedInvoice, selectedInvoice);
	        }

	    }

	    public void load(String hPath, String lPath) {
	        //System.out.println("Load File");
	        File hFile = null;
	        File lFile = null;
	        if (hPath == null && lPath == null) {
	            JFileChooser fc = new JFileChooser();
	            JOptionPane.showMessageDialog(frame, "Choose Header File!", "Header", JOptionPane.WARNING_MESSAGE);
	            int result = fc.showOpenDialog(frame);
	            if (result == JFileChooser.APPROVE_OPTION) {
	                hFile = fc.getSelectedFile();
	                JOptionPane.showMessageDialog(frame, "Choose Line File!", "Line", JOptionPane.WARNING_MESSAGE);
	                result = fc.showOpenDialog(frame);
	                if (result == JFileChooser.APPROVE_OPTION) {
	                    lFile = fc.getSelectedFile();
	                }
	            }
	        } else {
	            hFile = new File(hPath);
	            lFile = new File(lPath);
	        }

	        if (hFile != null && lFile != null) {
	            try {
	                List<String> hLines = readFile(hFile);
	                /*
	                [
	                    "1,12-11-2020,Sameer", 
	                    "2,23-10-2021,Rana"
	                ]
	                 */

	                List<String> lLines = readFile(lFile);
	                /*
	                [
	                    "1,Mobile,3200,1",
	                    "1,Cover,90,2",
	                    "1,Headphone,130,1",
	                    "2,Laptop,9000,1",
	                    "2,Mouse,135,2"
	                ]
	                 */
	                System.out.println("check");
	                for (String hLine : hLines) {
	                    /*
	                        hLine = "1,12-11-2020,Sameer"
	                     */
	                    String[] parts = hLine.split(",");
	                    /*
	                        parts = ["1", "12-11-2020", "Sameer"]
	                     */
	                    Date d = new Date();
	                    int num = Integer.parseInt(parts[0]);
	                    try {
	                        d = SalesFrame.df.parse(parts[1]);
	                    } catch (ParseException pex) {
	                    }
	                    String name = parts[2];
	                    InvoiceHeader inv = new InvoiceHeader(num, d, name);
	                    frame.getInvoices().add(inv);
	                    // System.out.print(parts[2]);
	                }
	                frame.setHeaderTableModel(new tableHeader(frame.getInvoices()));

	                for (String lLine : lLines) {
	                    /*
	                        lLine = "1,Mobile,3200,1"
	                     */
	                    String[] parts = lLine.split(",");
	                    /*
	                        parts = ["1", "Mobile", "3200", "1"]
	                     */
	                    int invNum = Integer.parseInt(parts[0]);
	                    String name = parts[1];
	                    int price = Integer.parseInt(parts[2]);
	                    int count = Integer.parseInt(parts[3]);
	                    InvoiceHeader invoice = frame.getInvoiceByNum(invNum);
	                    InvoiceBody item = new InvoiceBody(name, price, count, invoice);
	                }
	                System.out.println("Check");
	            } catch (IOException ex) {
	                JOptionPane.showMessageDialog(frame, "Error while loading files", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }

	    private List<String> readFile(File f) throws IOException {
	        List<String> lines = new ArrayList<>();

	        FileReader fr = new FileReader(f);
	        BufferedReader br = new BufferedReader(fr);
	        String line = null;
	        while ((line = br.readLine()) != null) {
	            lines.add(line);
	        }

	        return lines;
	    }

	    public void save() throws IOException {
	      JFileChooser fc = new JFileChooser();
	        File hFile = null;
	        File lFile = null;
	        
	        JOptionPane.showMessageDialog(frame, "Please, select new file to save Header Data", "Header", JOptionPane.QUESTION_MESSAGE);
	        int result = fc.showSaveDialog(frame);
	        if (result == JFileChooser.APPROVE_OPTION) {
	            hFile = fc.getSelectedFile();
	            JOptionPane.showMessageDialog(frame, "Please, select new file to save Item Data", "Header", JOptionPane.QUESTION_MESSAGE);
	            result = fc.showSaveDialog(frame);
	            if (result == JFileChooser.APPROVE_OPTION) {
	                lFile = fc.getSelectedFile();
	            }
	        }
	        
	        if (hFile != null && lFile != null) {
	            String hData = "";
	            String lData = "";
	            
	            for (InvoiceHeader inv : frame.getInvoices()) {
	                hData += inv.getAsCSV();
	                hData += "\n";
	                for (InvoiceBody line : inv.getItems()) {
	                    lData += line.getAsCSV();
	                    lData += "\n";
	                }
	            }
	            System.out.println("Check");
	            try {
	                FileWriter hfw = new FileWriter(hFile);
	                FileWriter lfw = new FileWriter(lFile);
	                
	                hfw.write(hData);
	                lfw.write(lData);
	                
	                hfw.flush();
	                lfw.flush();
	                
	                hfw.close();
	                lfw.close();
	                
	            } catch (Exception ex) {
	                
	            }
	        }
	    }

	    private void newLineCancel() {
	        lineDialog.setVisible(false);
	        lineDialog.dispose();
	        lineDialog = null;
	    }

	    private void newLineOK() throws IOException, ArrayIndexOutOfBoundsException {
	        try {
	            String name = lineDialog.getItemNameT().getText();
	            int count = Integer.parseInt(lineDialog.getCountT().getText());
	            int price = Integer.parseInt(lineDialog.getPriceT().getText());
	            int selectedInvIndex = frame.getInvoicesTable().getSelectedRow();
	            InvoiceHeader inv = frame.getInvoices().get(selectedInvIndex);

	            InvoiceBody invoiceLine = new InvoiceBody(name, price, count, inv);
	            frame.getHeaderTableModel().fireTableDataChanged();
	            frame.getInvoicesTable().setRowSelectionInterval(selectedInvIndex, selectedInvIndex);
	            newLineCancel();
	        } catch (ArrayIndexOutOfBoundsException ex) {

	        }
	    }

	    private void newInvoiceCancel() {
	        headerDialog.setVisible(false);
	        headerDialog.dispose();
	        headerDialog = null;//To change body of generated methods, choose Tools | Templates.
	    }
	}
