package view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;



public class newJDialog extends JDialog {
	private JTextField NewNameF;
    private JTextField NewDateF;
    private JLabel NewNameL;
    private JLabel NewDateL;
    private JButton OK;
private JButton Cancel;
   

    public newJDialog(SalesFrame frame) {
           NewNameL = new JLabel("Customer Name:");
        NewNameF = new JTextField(20);
        NewDateL = new JLabel("Invoice Date:");
        NewDateF = new JTextField(20);
        OK = new JButton("OK");
        Cancel = new JButton("Cancel");
        
        OK.setActionCommand("newInvoiceOK");
        Cancel.setActionCommand("newInvoiceCancel");
        
        OK.addActionListener(frame.getListener());
        Cancel.addActionListener(frame.getListener());
        setLayout(new GridLayout(3, 2));
        
        add(NewNameL);
        add(NewNameF);
        add(NewDateL);
        add(NewDateF);
        add(OK);
        add(Cancel);
        setModal(true);
        pack();
        
        
    }
      public JTextField getNewNameF() {
        return NewNameF;
    }

    public void setNewNameF(JTextField NewNameF) {
        this.NewNameF = NewNameF;
    }

    public JTextField getNewDateF() {
        return NewDateF;
    }

    public void setNewDateF(JTextField NewDateF) {
        this.NewDateF = NewDateF;
    }

    public JLabel getNewNameL() {
        return NewNameL;
    }

    public void setNewNameL(JLabel NewNameL) {
        this.NewNameL = NewNameL;
    }

    public JLabel getNewDateL() {
        return NewDateL;
    }

    public void setNewDateL(JLabel NewDateL) {
        this.NewDateL = NewDateL;
    }

    public JButton getOK() {
        return OK;
    }

    public void setOK(JButton OK) {
        this.OK = OK;
    }

    public JButton getCancel() {
        return Cancel;
    }

    public void setCancel(JButton Cancel) {
        this.Cancel = Cancel;
    }



}

