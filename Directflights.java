import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Directflights{
	private Cities a;
	private Cities b;
	private Date departDate;
	private String timedepart;
	private String timearrival;
	private double price;
	private static int numberofline;
	public Directflights(){
		numberofline++;
	}
	public Directflights(Cities a, Cities b, double price , String timedepart, String timearrival){
		this.a = a;
		this.b = b;
		this.price = price;
		this.timedepart = timedepart;
		this.timearrival = timearrival;
		this.departDate = new Date();
		numberofline++;
	}
	public String geta(){
		return a.getname();
	}
	public Cities getAcity(){
		return a;
	}
	public Cities getBciy(){
		return b;
	}
	public int getida(){
		return a.getid();
	}
	public int getidb(){
		return b.getid();
	}
	
	public String getb(){
		return b.getname();
	}
	public Date getdepartdate(){
		return departDate;
	}
	public String gettimearrival(){
		return timearrival;
	}
	public String gettimedepart(){
		return timedepart;
	}
	public double getprice(){
		return price;
	}
	
	public void displaydirect(int i){
		System.out.println();

	
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Flight Number " + i);
		 System.out.printf("%-30s%-15s-%30s\n", "From", "Depart ", "TO");
		System.out.printf("%-30s%-15s-%30s\n", geta() ,gettimedepart() , "--->      "+getb());
		System.out.printf("%-30s%-15s-%17s\n", "EI Part lntl.Apt.", getdepartdate(), gettimearrival());
		System.out.println("Price: " + getprice()+"$");
		System.out.println("------------------------------------------------------------------------------");
	
	System.out.println();
	}
	
}
