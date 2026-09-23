package Entities;

import java.lang.*;
import java.util.*;
import java.io.*;
import Frames.*;

public class Account
{
	private String name;
	private String pass;
	private String email;
	private String vehicle; 
	File myfile;
	FileWriter fwrite;
	Scanner sc;
	
	public Account()
	{
		
	}
	
	
	public Account(String name, String pass, String email, String vehicle)
	{
		
    this.name = name;
    this.pass = pass;
    this.email = email;
    this.vehicle = vehicle;
	
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setPass(String pass)
	{
		this.pass=pass;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPass()
	{
		return pass;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setVehicle(String vehicle)
	{
    this.vehicle = vehicle;
	}

	public String getVehicle()
	{
    return vehicle;
	}
	
	private File getDataFile()
	{
		File dir = new File(System.getProperty("user.dir"), "Data_all");
		if(!dir.exists())
		{
			dir.mkdirs();
		}
		return new File(dir, "Data.txt");
	}
	
	public boolean addAccount()
	{
		try
		{
			myfile = getDataFile();
			if(!myfile.exists())
			{
				myfile.createNewFile();
			}
			
			try (FileWriter fwrite = new FileWriter(myfile, true);
				BufferedWriter bw = new BufferedWriter(fwrite))
			{
				bw.write(getName() + "\t" + getEmail() + "\t" + getPass() + "\t" + getVehicle() + "\n");
			}
			return true;
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			return false;
		}
	}
	
	public boolean getAccount(String uname,String upass)
	{
		boolean flag=false;
		try
		{
			myfile = getDataFile();
			
			sc=new Scanner(myfile);
			
			while(sc.hasNextLine())
			{
				String line=sc.nextLine();
				String value[]=line.split("\t");
				
				if(value.length >= 4 && value[0].equals(uname) && value[2].equals(upass))
				{
					this.name = value[0];
					this.email = value[1];
					this.pass = value[2];
					this.vehicle = value[3];
					flag = true;
}
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
			return flag;
	}
		
		//(Talha) Cannot Match USername
		public boolean usernameExists(String uname)
		{
			boolean found = false;
			try
			{
				myfile = getDataFile();
				if(!myfile.exists())
				{
					return false; // no file means no users yet
				}

				sc = new Scanner(myfile);
				while(sc.hasNextLine())
				{
					String line = sc.nextLine();
					String value[] = line.split("\t");
					if(value.length >= 1 && value[0].equals(uname))
					{
						found = true;
						break;
					}
				}
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
			return found;
		}
				
			
}