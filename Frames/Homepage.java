package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entities.*;

public class Homepage extends JFrame implements ActionListener
{

    JLabel namelbl1, bgLabel, rawIcon ;
    JButton backbtn;
    JPanel panel;
    FrameIntro f1;
	Account account;

    // Extra buttons
    JButton btnBookCar;
    JButton btnViewProfile;
    JButton btnLogout;
	ImageIcon appIcon;

    public Homepage(Account account,FrameIntro f1)
    {
        super("Homepage");
        this.setSize(800,450);
        this.setLocationRelativeTo(null);
		
		ImageIcon appIcon = new ImageIcon("images/VehicleLogo.png");
		this.setIconImage(appIcon.getImage());
		
	
        this.f1 = f1;
		this.account = account;
        panel = new JPanel();
		panel.setBackground(new Color(182,213,182));
        panel.setLayout(null);

        namelbl1 = new JLabel("Welcome, " + account.getName());
        namelbl1.setBounds(50,30,300,40);
        namelbl1.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(namelbl1);

        ImageIcon rawIcon = new ImageIcon("./images/Homepage.png");  
		JLabel bgLabel = new JLabel(rawIcon);
		bgLabel.setBounds(0, 0, 800, 450);

        // New action buttons
        btnBookCar = new JButton("Book a Vehicle");
        btnBookCar.setBounds(40,80,150,40);
        btnBookCar.addActionListener(this);
        panel.add(btnBookCar);

        btnViewProfile = new JButton("View Profile");
        btnViewProfile.setBounds(40,140,150,40);
        btnViewProfile.addActionListener(this);
        panel.add(btnViewProfile);

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(650,300,100,40);
        btnLogout.addActionListener(this);
        panel.add(btnLogout);
	
		panel.add(bgLabel);
        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == backbtn)
        {
            // Back to login
            this.setVisible(false);
            FrameIntro f1 = new FrameIntro();
            f1.setVisible(true);
        }
        else if(ae.getSource() == btnBookCar)
        {
            JOptionPane.showMessageDialog(this,
                "Booking page coming soon.\nHere you will select vehicles, dates and confirm booking.");
        }		
		
		//(Talha) View Profile Details
        else if(ae.getSource() == btnViewProfile)
		{
        String details =
              "Name: " + account.getName()
            + "\nEmail: " + account.getEmail()
            + "\nPassword: " + account.getPass()
            + "\nRegistered Vehicle: " + account.getVehicle();

        JOptionPane.showMessageDialog(this, details, "Profile Details",
                                      JOptionPane.INFORMATION_MESSAGE);
		}
        else if(ae.getSource() == btnLogout)
        {
            this.setVisible(false);
            FrameIntro f1 = new FrameIntro();
            f1.setVisible(true);
        }
    }
}
