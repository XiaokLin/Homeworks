package lib;
import java.io.*;

public class PhoneBookEntry{
	private int ID;
	private String fname;
	private String lname;
	private String email;
	private int zipcode;
	private int number;
	
	public PhoneBookEntry() {
        ID = -1;
        fname = "";
        lname = "";
        email = "";
        zipcode = "";
        number = "";
    }
	
	public PhoneBookEntry(int i, String f, String l, String e, int z, int n) {
		ID = i;
		fname = f;
		lname = l;
		email = e;
		zipcode = z;
		number = n;
	}
	
	public PhoneBookEntry(String f, int n) {
		ID = -1;
		fname = f;
		lname = "";
		email = "";
		zipcode = "";
		number = n;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void printBookEntry() {
		System.out.println("ID: " + ID);
		System.out.println("First Name: " + this.fname);
		System.out.println("Last Name: " + this.lname);
		System.out.println("Email: " + this.email);
		System.out.println("Zipcode: " + this.zipcode);
		System.out.println("Number: " + this.number);
		
	}
}