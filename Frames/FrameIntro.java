package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import Entities.*;

public class FrameIntro extends JFrame implements MouseListener, ActionListener
{
	JLabel namelbl,passlbl,logimglbl,signlbl,logimgslbl,logimgplbl, loglbl1;
	JPanel panel;
	JTextField namfld;
	JPasswordField passfld;
	JButton logbtn, signbtn, backbtn;
	Color myColor,defaultColor,defaultColor2;
	JCheckBox rbck;
	ImageIcon logimg, logimgs, logimgp, appIcon;
	
	// ImageIcon img;
	
	public FrameIntro()
	{
		super("VEHICLE RENTAL SYSTEM");
		this.setSize(850,450); //length,width
		this.setLocationRelativeTo(null);
		
		ImageIcon appIcon = new ImageIcon("images/VehicleLogo.png");
		this.setIconImage(appIcon.getImage());
		
		myColor=new Color(121,192,194);
		defaultColor = null;
		defaultColor2 = null;

		ImageIcon rawIcon = new ImageIcon("./images/Loglogos.png");
		Image scaledImage = rawIcon.getImage().getScaledInstance(300, 75, Image.SCALE_SMOOTH);
		logimg = new ImageIcon(scaledImage);
		logimglbl=new JLabel(logimg);
		logimglbl.setBounds(525,95,300,75);

		ImageIcon rawIcon2 = new ImageIcon("./images/LoginLogop.png");
		Image scaledImage2 = rawIcon2.getImage().getScaledInstance(225, 450, Image.SCALE_SMOOTH);
		logimgs = new ImageIcon(scaledImage2);
		logimgslbl=new JLabel(logimgs);
		logimgslbl.setBounds(290,0,225,412);

		ImageIcon rawIcon3 = new ImageIcon("./images/Loginlogot.png");
		Image scaledImage3 = rawIcon3.getImage().getScaledInstance(225, 450, Image.SCALE_SMOOTH);
		logimgp = new ImageIcon(scaledImage3);
		logimgplbl=new JLabel(logimgp);
		logimgplbl.setBounds(0,0,290,412);

		panel= new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);
		
		loglbl1=new JLabel("LOGIN");
		loglbl1.setBounds(630,20,200,50);
		loglbl1.setFont(new Font("Arial",Font.BOLD,34));
		loglbl1.setForeground(new Color(48,29,29));
		panel.add(loglbl1);
		
		
		panel.add(logimglbl);
		panel.add(logimgslbl);
		panel.add(logimgplbl);

		namelbl=new JLabel ("NAME:");
		namelbl.setBounds(525,170,100,30);
		namelbl.setFont(new Font("Arial",Font.BOLD,16));
		panel.add(namelbl);
		
		namfld=new JTextField();
		namfld.setBounds(525,200,300,30);
		namfld.setHorizontalAlignment(JTextField.CENTER);
		namfld.setFont(new Font("Arial",Font.BOLD,16));
		panel.add(namfld);
		
		passlbl=new JLabel("PASSWORD:");
		passlbl.setBounds(525,240,100,30);
		passlbl.setFont(new Font("Arial",Font.BOLD,16));
		panel.add(passlbl);
		
		passfld=new JPasswordField();
		passfld.setBounds(525,270,300,30);
		passfld.setHorizontalAlignment(JPasswordField.CENTER);
		passfld.setFont(new Font("Arial", Font.BOLD, 18));
		passfld.setEchoChar('*');
		panel.add(passfld);
		
		logbtn=new JButton("LOGIN");
		logbtn.setFont(new Font("Arial",Font.BOLD,14));
		logbtn.setBounds(525,330,300,30);
		//logbtn.setBackground(myColor);
		logbtn.addMouseListener(this);
		logbtn.addActionListener(this);
		defaultColor = logbtn.getBackground();
		panel.add(logbtn);
		
        signlbl=new JLabel("Do you have an account?");
		signlbl.setBounds(525,365,200,30);
		signlbl.setFont(new Font("Italic",Font.PLAIN,16));
		signlbl.setForeground(new Color(0,0,0));
		panel.add(signlbl);

		signbtn=new JButton("SIGNUP");
		signbtn.setBounds(725,365,100,30);
		//signbtn.setBackground(myColor);
		signbtn.setForeground(Color.BLACK);
		signbtn.addMouseListener(this);
		signbtn.addActionListener(this);
		defaultColor2 = signbtn.getBackground();
		panel.add(signbtn);
		
	/* 	backbtn=new JButton("BACK");
		backbtn.setBounds(460,275,100,50);
		backbtn.setBackground(myColor);
		backbtn.addMouseListener(this);
		panel.add(backbtn); */

		rbck=new JCheckBox("Remember me");
		rbck.setBounds(521,305,125,15);
		rbck.setBackground(myColor);
		panel.add(rbck);	
		
	/* 	img=new ImageIcon("./demo.jpg");
		imglbl=new JLabel(img);
		imglbl.setBounds(0,0,850,450);
		panel.add(imglbl);
		*/
		this.add(panel);
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==logbtn)
		{
			logbtn.setBackground(new Color(0,97,21));
		}
		else if(me.getSource()==signbtn)
		{
			signbtn.setBackground(new Color(145,2,2));
		}
		else if(me.getSource()==backbtn)
		{
			backbtn.setBackground(Color.WHITE);
			backbtn.setBackground(Color.CYAN);
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==logbtn)
		{
			logbtn.setBackground(defaultColor);
		}
		else if(me.getSource()==signbtn)
		{
			signbtn.setBackground(defaultColor2);
		}
		else if(me.getSource()==backbtn)
		{
			backbtn.setBackground(myColor);
			backbtn.setForeground(Color.BLACK);
		}
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==logbtn)
		{
			String name = namfld.getText().trim();
			String pass = new String(passfld.getPassword());

			if(name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please enter your name.");
				return;
			}

			if(pass.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please enter your password.");
				return;
			}

			Account account = new Account();
			if(account.getAccount(name, pass))
			{
				this.setVisible(false);
				Homepage home = new Homepage(account, this);
				home.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid username or password.");
			}
		}
		else if(ae.getSource()==signbtn)
		{
			this.setVisible(false);
			Register r1=new Register();
			r1.setVisible(true);
		}
	}

}