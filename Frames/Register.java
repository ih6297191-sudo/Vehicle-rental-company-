package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import Entities.*;

public class Register extends JFrame implements ActionListener, MouseListener
{
	JLabel regnamlbl,regpasslbl,regemlbl, regimglbl, regtextlbl, regtextlbl2,regtextlbl3;
	JPasswordField regpassfld;
	JTextField regnamfld, regemfld;
	Color myColor,defaultColor,defaultColor2;
	JPanel panel;
	JButton rgstrbtn,backbtn;
	JComboBox<String> regvehcombo;
	ImageIcon img, appIcon;

	
	public Register()
	{
		super("Registration");
		this.setSize(850,450);
		this.setLocationRelativeTo(null);
		
		ImageIcon appIcon = new ImageIcon("images/VehicleLogo.png");
		this.setIconImage(appIcon.getImage());

		myColor=new Color(121,192,194);
		defaultColor = null;
		defaultColor2 = null;
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);
		
		img=new ImageIcon("images/LoginLogo.png");
		regimglbl=new JLabel(img);
		regimglbl.setBounds(20,20,385,300);
		panel.add(regimglbl);

		regtextlbl=new JLabel("READY TO EXPLORE?");
		regtextlbl.setBounds(105,320,300,30);
		regtextlbl.setFont(new Font("Arial",Font.BOLD,20));
		regtextlbl.setForeground(new Color(145,2,2));
		panel.add(regtextlbl);

		regtextlbl2=new JLabel("REGISTER NOW AND DREAME YOUR RIDE!");
		regtextlbl2.setBounds(50,350,350,30);
		regtextlbl2.setFont(new Font("Arial",Font.BOLD,16));
		regtextlbl2.setForeground(new Color(145,2,2));
		panel.add(regtextlbl2);

		regtextlbl3=new JLabel("REGISTRATION");
		regtextlbl3.setBounds(570,20,200,50);
		regtextlbl3.setFont(new Font("Arial",Font.BOLD,22));
		regtextlbl3.setForeground(new Color(00,0,0));
		panel.add(regtextlbl3);
		
		regnamlbl=new JLabel("NAME");
		regnamlbl.setBounds(425,100,100,30);
		regnamlbl.setFont(new Font("Arial",Font.BOLD,16));
		panel.add(regnamlbl);
		
		regnamfld=new JTextField();
		regnamfld.setBounds(525,100,300,30);
		regnamfld.setHorizontalAlignment(JTextField.CENTER);
		regnamfld.setFont(new Font("Arial",Font.BOLD,16));
		panel.add(regnamfld);

		regemlbl=new JLabel("EMAIL");
		regemlbl.setBounds(425,160,100,30);
		regemlbl.setFont(new Font("Arial",Font.BOLD,16));
		panel.add(regemlbl);
		
		regemfld=new JTextField();
		regemfld.setBounds(525,160,300,30);
		regemfld.setHorizontalAlignment(JTextField.CENTER);
		regemfld.setFont(new Font("Arial",Font.BOLD,16));
		panel.add(regemfld);
		
		regpasslbl=new JLabel("PASSWORD");
		regpasslbl.setBounds(425,220,100,30);
		regpasslbl.setFont(new Font("Arial",Font.BOLD,16));
		panel.add(regpasslbl);
		
		regpassfld=new JPasswordField();
		regpassfld.setBounds(525,220,300,30);
		regpassfld.setHorizontalAlignment(JTextField.CENTER);
		regpassfld.setFont(new Font("Arial",Font.BOLD,16));
		regpassfld.setEchoChar('*');
		panel.add(regpassfld);
		
		// New Vehicle Add (Talha)
		JLabel regvehlbl = new JLabel("VEHICLE");
		regvehlbl.setBounds(425,280,100,30);
		regvehlbl.setFont(new Font("Arial",Font.BOLD,16));
		panel.add(regvehlbl);

		String[] vehicles = {"car", "truck", "jeep", "motorcycle", "cycle"};
		regvehcombo = new JComboBox<String>(vehicles);
		regvehcombo.setBounds(525,280,300,30);
		panel.add(regvehcombo);
		
		rgstrbtn=new JButton("CREATE ACCOUNT");
		rgstrbtn.setBounds(525,330,150,30);
		rgstrbtn.addActionListener(this);
		rgstrbtn.addMouseListener(this);
		defaultColor = rgstrbtn.getBackground();
		panel.add(rgstrbtn);
		
		backbtn=new JButton("Back");
		backbtn.setBounds(680,330,90,30);
		backbtn.addActionListener(this);
		backbtn.addMouseListener(this);
		defaultColor2 = backbtn.getBackground();
		panel.add(backbtn);
		
		
		
		
		this.add(panel);
	}

	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==rgstrbtn)
		{
			rgstrbtn.setBackground(new Color(0,97,21));
		}
		else if(me.getSource()==backbtn)
		{
			backbtn.setBackground(new Color(145,2,2));
		}
	}
	
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==rgstrbtn)
		{
			rgstrbtn.setBackground(defaultColor);
		}
		else if(me.getSource()==backbtn)
		{
			backbtn.setBackground(defaultColor2);
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String s1=regnamfld.getText();
		String s2=new String(regpassfld.getPassword());
		String s3=regemfld.getText();
		String s4 = (String) regvehcombo.getSelectedItem();
		
		if(ae.getSource()==rgstrbtn)
		{
			if(s1.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"FILL UP YOUR NAME");
			}
			else if(s3.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"FILL UP YOUR EMAIL");
			}


			else if(s2.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"FILL UP YOUR PASSWORD");
			}
			
			//(Talha) added cant be duplicate usernames
			Account temp = new Account();
			if(temp.usernameExists(s1))
			{
            JOptionPane.showMessageDialog(null, "This username is already taken. Please choose another one.");
            return;
			}
			
			else
			{
				//(Talha) added s4 (vehicle choose)
				Account acc = new Account(s1, s2, s3, s4);
				if(acc.addAccount())
				{
					JOptionPane.showMessageDialog(null, "Account created successfully.");
					this.setVisible(false);
					FrameIntro f1=new FrameIntro();
					f1.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Unable to save account. Please try again.");
				}
			}
		}
		else if(ae.getSource()==backbtn)
		{
			this.setVisible(false);
			FrameIntro f1=new FrameIntro();
			f1.setVisible(true);
		}
	}
}