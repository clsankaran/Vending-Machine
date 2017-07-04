import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;

public class VendingApp
{
	int order = 0;
	public static void main(String[] args)
	{
		JFrame frame = new VendingFrame();
		frame.setVisible(true);
	}
}

class VendingFrame extends JFrame
{
	public VendingFrame()
	{
		setTitle("Vending Machine");
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new VendingPanel();
		this.add(panel);
		this.pack();
		centerWindow(this);
	}
	private void centerWindow(Window w)
	{
		 Toolkit tk = Toolkit.getDefaultToolkit();
		 Dimension d = tk.getScreenSize();
		 setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
	}
}

class VendingPanel extends JPanel implements ActionListener
{
	 Machine m = new Machine(1.25);
	 private JButton	  pepsiButton,
						  dietpepsiButton,
						  mountaindewButton,
						  drpepperButton,
						  rootbeerButton,
						  waterButton,
						  quarterButton,
						  dollarButton,
						  refundButton;
	 private JLabel	   priceLabel;
	 private JTextField   amountTextField;
   NumberFormat currency = NumberFormat.getCurrencyInstance();
	public VendingPanel()
	{
		 m.lbeverages(0, new Beverage("Pepsi", m.QUANITY));
				m.lbeverages(1, new Beverage("Diet Pepsi", m.QUANITY));
				m.lbeverages(2, new Beverage("Mountain Dew", m.QUANITY));
				m.lbeverages(3, new Beverage("Dr. Pepper" , m.QUANITY));
				m.lbeverages(4, new Beverage("Root Beer", m.QUANITY));
				m.lbeverages(5, new Beverage("Water", m.QUANITY));
		setLayout(new GridBagLayout());
		Border loweredBorder =
			   BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		JPanel VendingPanel = new JPanel();
		VendingPanel.setLayout(new GridBagLayout());
		VendingPanel.setBorder(BorderFactory.createTitledBorder(loweredBorder, "Vending Machine"));
		
		pepsiButton = new JButton("Pepsi (1.25)");
		setWidth(pepsiButton, 175);
		pepsiButton.addActionListener(this);
		VendingPanel.add(pepsiButton,
			getConstraints(1,0,1,1, GridBagConstraints.WEST));
		
		dietpepsiButton = new JButton("Diet Pepsi (1.25)");
		dietpepsiButton.addActionListener(this);
		setWidth(dietpepsiButton, 175);
		VendingPanel.add(dietpepsiButton,
			getConstraints(1,1,1,1, GridBagConstraints.WEST));
		
		mountaindewButton = new JButton("Mountain Dew (1.25)");
		mountaindewButton.addActionListener(this);
		setWidth(mountaindewButton, 175);
		VendingPanel.add(mountaindewButton,
			 getConstraints(1,2,1,1, GridBagConstraints.WEST));

		drpepperButton = new JButton("Dr. Pepper (1.25)");
		drpepperButton.addActionListener(this);
		setWidth(drpepperButton, 175);
		VendingPanel.add(drpepperButton,
			 getConstraints(1,3,1,1, GridBagConstraints.WEST));

		rootbeerButton = new JButton("Root Beer (1.25)");
		rootbeerButton.addActionListener(this);
		setWidth(rootbeerButton, 175);
		VendingPanel.add(rootbeerButton,
			 getConstraints(1,4,1,1, GridBagConstraints.WEST));

		waterButton = new JButton("Water (1.25)");
		waterButton.addActionListener(this);
		setWidth(waterButton, 175);
		VendingPanel.add(waterButton,
			 getConstraints(1,5,1,1, GridBagConstraints.WEST));

		quarterButton = new JButton("Quarter");
		quarterButton.addActionListener(this);
		setWidth(quarterButton, 100);
		VendingPanel.add(quarterButton,
			 getConstraints(0,0,1,1, GridBagConstraints.WEST));

		dollarButton = new JButton("Dollar");
		dollarButton.addActionListener(this);
		setWidth(dollarButton, 100);
		VendingPanel.add(dollarButton,
			 getConstraints(0,1,1,1, GridBagConstraints.WEST));

		refundButton = new JButton("Refund");
		refundButton.addActionListener(this);
		setWidth(refundButton, 100);
		VendingPanel.add(refundButton,
			 getConstraints(0,3,1,1, GridBagConstraints.WEST));

				amountTextField = new JTextField(5);
				amountTextField.setEditable(false);
				VendingPanel.add(amountTextField,
					 getConstraints(0,2,1,1, GridBagConstraints.WEST));
				
		this.add(VendingPanel,
			  getConstraints(0,1,3,1, GridBagConstraints.WEST));
		setAddEditMode(false);
	}
	private GridBagConstraints getConstraints(int gridx, int gridy,
	int gridwidth, int gridheight, int anchor)
	{
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.anchor = anchor;
		return c;
	}
private void setWidth(JComponent c, int width)
		{
			c.setPreferredSize(new Dimension(width,25));
		}
public void setAddEditMode(boolean e)
{
	pepsiButton.setEnabled(e);
	dietpepsiButton.setEnabled(e);
	mountaindewButton.setEnabled(e);
	drpepperButton.setEnabled(e);
	rootbeerButton.setEnabled(e);
	waterButton.setEnabled(e);
}

public void actionPerformed(ActionEvent e)
{
	Object source = e.getSource();
	if (source == quarterButton)
	{
	m.money +=.25;
	setAddEditMode(true);
	amountTextField.setText(currency.format(m.money));
	}
	if (source == dollarButton)
	{
	m.money +=1.00;
	setAddEditMode(true);
	amountTextField.setText(currency.format(m.money));
	}

   if (source == pepsiButton)
   {
	   order(0);
   m.getMoney(0);
   amountTextField.setText(currency.format(m.money));

   }
   if (source == dietpepsiButton)
   {
	   order(1);
   m.getMoney(1);
   amountTextField.setText(currency.format(m.money));

   }
   if (source == mountaindewButton)
   {
	   order(2);
   m.getMoney(2);
   amountTextField.setText(currency.format(m.money));
   }
   if (source == drpepperButton)
   {
	   order(3);
   m.getMoney(3);
   amountTextField.setText(currency.format(m.money));

   }
   if (source == rootbeerButton)
   {
	   order(4);
	m.getMoney(4);
	amountTextField.setText(currency.format(m.money));
   }
   if(source == waterButton)
   {
	order(5);
   m.getMoney(5);
   amountTextField.setText(currency.format(m.money));

   }
   if (source == refundButton)
   {
	   m.refund();
	   amountTextField.setText(currency.format(m.money));
   }
}
public void order(int orders)
{
   if(m.money >= m.cost)
   {
	   JOptionPane.showMessageDialog(this, "Enjoy your " + m.getName(orders));
	   amountTextField.setText(currency.format(m.money));
   }
   else if(m.money < m.cost)
   {
	   setAddEditMode(false);
   JOptionPane.showMessageDialog(this, "Enter more money");
   }
}
}