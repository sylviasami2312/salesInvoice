package view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRootPane;
import java.awt.GridLayout;


public class newJLine extends JDialog{

	 private JTextField ItemNameT;
	    private JTextField CountT;
	    private JTextField PriceT;
	    private JLabel NameL;
	    private JLabel CountL;
	    private JLabel PriceL;
	    private JButton OK;
	    private JButton Cancel;
	    
	    public newJLine(SalesFrame frame) {
	        ItemNameT = new JTextField(20);
	        NameL = new JLabel("Item Name");
	        
	        CountT = new JTextField(20);
	        CountL = new JLabel("Item Count");
	        
	        PriceT = new JTextField(20);
	        PriceL = new JLabel("Item Price");
	        
	        OK = new JButton("OK");
	        Cancel = new JButton("Cancel");
	        
	        OK.setActionCommand("newLineOK");
	        Cancel.setActionCommand("newLineCancel");
	        
	       OK.addActionListener(frame.getListener());
	        Cancel.addActionListener(frame.getListener());
	        setLayout(new GridLayout(4, 2));
	        add(NameL);
	        add(ItemNameT);
	        add(CountL);
	        add(CountT);
	        add(PriceL);
	        add(PriceT);
	        add(OK);
	        add(Cancel);
	        setModal(true);
	        pack();
	    }
	    
	    public JTextField getItemNameT() {
	        return ItemNameT;
	    }
	    public JTextField getCountT() {
	        return CountT;
	    }


	    public JTextField getPriceT() {
	        return PriceT;
	    }

}
